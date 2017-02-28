package com.maacsport.controllers;


import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import org.springframework.beans.support.PagedListHolder;
import org.springframework.format.annotation.DateTimeFormat;

import com.maacsport.dao.VPersonDao;
import com.maacsport.dao.VTypeDao;
import com.maacsport.exceptions.CustomException;
import com.maacsport.model.VPerson;
import com.maacsport.model.VType;
import com.maacsport.model.advanced.VTypeEditor;
import com.maacsport.service.VPersonService;

@Controller("vpersonController")
@RequestMapping("/veronica/person")
@Transactional

public class VPersonController {
	
    @Autowired
    private VPersonService myService;
    
    @Autowired
    private VPersonDao  myDao;
    @Autowired
    private VTypeDao vTypeDao;
    
    protected Logger logger;

	public VPersonController() {
		logger = LoggerFactory.getLogger(getClass());
	}
	
	@InitBinder
   /* protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) {
        binder.registerCustomEditor(VType.class, new VTypeEditor(vTypeDao));
    }*/
	public void initBinder(WebDataBinder binder) {
		   
		   /*WebDataBinder extends DataBinder.

		   It can be used to register custom formatter, validators and PropertyEditors.

		       WebDataBinder.addCustomFormatter(..);
		       WebDataBinder.addValidators(..);
		       WebDataBinder.registerCustomEditor(..);
		    */
		
		  binder.registerCustomEditor(VType.class, new VTypeEditor(vTypeDao));
			 
	}
	
	@RequestMapping(value = { "/", "/addPerson" })
    public ModelAndView addPerson(Map<String, Object> map) {

           map.put("vperson", new VPerson());

           
           List<String> maleList = new ArrayList<String>();
           maleList.add("Masculino");
           maleList.add("Femenino");
           
           List<VType> temp = vTypeDao.findAll();
           
           map.put("vTypes", temp);
           
           
           ModelAndView model = new ModelAndView("addVPerson");
          
           model.addObject("maleList", maleList);
           return model;
           
           //return "/person/listPersons";
    }

    @RequestMapping(value = { "/", "/listPersons" })
    public ModelAndView listVPersons(Map<String, Object> map) {

           map.put("vperson", new VPerson());

           map.put("getList", myService.getList());
           
           List<String> maleList = new ArrayList<String>();
           maleList.add("Masculino");
           maleList.add("Femenino");
           
       	
           //map.put("maleList", maleList);
           
           ModelAndView model = new ModelAndView("listVPersons");
          
           model.addObject("maleList", maleList);
           return model;
           
           //return "/person/listPersons";
    }
    
    @RequestMapping(value={"/listPersonsPag","/listPersonsPag/{typee}"},  method=RequestMethod.GET)
    public ModelAndView listPersonsPag(@PathVariable Map<String, String> pathVariablesMap, 
    								   @RequestParam(value="name", defaultValue="") String name, 
    								   @RequestParam(value="id", defaultValue="") String id, 
    								   @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @RequestParam(value="dateMe", required=false) Date dateMe, 
    								   @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @RequestParam(value="dateMa", required=false) Date dateMa,  
    								  // @DateTimeFormat(pattern="yyyy-MM-dd") @RequestParam(value="dateMe", required=false) Calendar dateMe,
    								  // @DateTimeFormat(pattern="yyyy-MM-dd") @RequestParam(value="dateMa", required=false) Calendar dateMa,
    								   Map<String, Object> map, 
    								   HttpServletRequest req) {
    	 
    	 PagedListHolder<VPerson> productList = null;
    	 map.put("vperson", new VPerson());
    	 String typee = pathVariablesMap.get("typee");
    	 
    	 if(null == typee) {
             // First Request, Return first set of list
             List<VPerson> phonesList = myService.getList(name,id,dateMe,dateMa);
             
             productList = new PagedListHolder<VPerson>();
             productList.setSource(phonesList);
             productList.setPageSize(10);
             
             req.getSession().setAttribute("phonesList",  productList);
         
             printPageDetails(productList);
             
         } else if("next".equals(typee)) {
             // Return next set of list
             productList = (PagedListHolder<VPerson>) req.getSession()
                                 .getAttribute("phonesList");
             
             productList.nextPage();
             
             printPageDetails(productList);
             
         } else if("prev".equals(typee)) {
             // Return previous set of list
             productList = (PagedListHolder<VPerson>) req.getSession()
                                 .getAttribute("phonesList");
             
             productList.previousPage();
             
             printPageDetails(productList);
             
         } else {
             // Return specific index set of list
             System.out.println("type:" + typee);
             
             productList = (PagedListHolder<VPerson>) req.getSession()
                                 .getAttribute("phonesList");
             
             int pageNum = Integer.parseInt(typee);
             
             productList.setPage(pageNum);
             
             printPageDetails(productList);
         }
                     
    	 List<String> maleList = new ArrayList<String>();
         maleList.add("Masculino");
         maleList.add("Femenino");
         
     	
         //map.put("maleList", maleList);
         
         ModelAndView model = new ModelAndView("listVPersonsPag");
         
         SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
       
         
         if (dateMe != null) model.addObject("dateMe", format.format(dateMe.getTime()));
         if (dateMa != null) model.addObject("dateMa", format.format(dateMa.getTime()));
         model.addObject("name",name);
         model.addObject("dni",id);
         
        
         model.addObject("maleList", maleList);
         
         return  model;
    }
    
    private void printPageDetails(PagedListHolder productList) {
        
        System.out.println("curent page - productList.getPage() :"
                + productList.getPage());
        
        System.out.println("Total Num of pages - productList.getPageCount :"
                + productList.getPageCount());
        
        System.out.println("is First page - productList.isFirstPage :"
                + productList.isFirstPage());
        
        System.out.println("is Last page - productList.isLastPage :"
                + productList.isLastPage());
    }
    
    @RequestMapping(value="/getPerson/{elementId}", method = RequestMethod.GET)
    public ModelAndView getElement(@PathVariable String elementId, Map<String, Object> map) {

           VPerson element = myService.getElement(elementId);

           map.put("vperson", element);
           
           List<String> maleList = new ArrayList<String>();
           maleList.add("Masculino");
           maleList.add("Femenino");
           List<VType> temp = vTypeDao.findAll();
           
           map.put("vTypes", temp);
       	
           //ModelAndView model = new ModelAndView("vpersonEditForm");
           ModelAndView model = new ModelAndView("vpersonEditDinamic");
           
           model.addObject("maleList", maleList);
           return model;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelAndView saveBook(@Valid @ModelAttribute("vperson")VPerson element, BindingResult result) {
    	 logger.info("Acción saveVPerson"); 
    	 ModelAndView mav = new ModelAndView(); 
    	
    	 if (result!=null && result.hasErrors()) {  
             /*
             List<String> temp=new ArrayList<String>();
             for (Object object : result.getFieldErrors()) {
				    if(object instanceof FieldError) {
				        FieldError fieldError = (FieldError) object;

				        logger.info((fieldError.getCode()));
				        temp.add((fieldError.getCode() + " - " + fieldError.getDefaultMessage()));
				    }

				   
				}
    	 */
            //mav.addObject("errors", temp);
             
            
             
             List<String> maleList = new ArrayList<String>();
             maleList.add("Masculino");
             maleList.add("Femenino");
             
         	
             //mav.addObject("vperson", new VPerson());

             List<VType> temp = vTypeDao.findAll();
             
             mav.addObject("vTypes", temp);
             
             mav.addObject("maleList", maleList);
             
            // mav.addObject("showForm", 1);
             
             mav.setViewName("addVPerson"); 
             return mav;  
        } 
    	 
           //myDao.save(element);
           myService.save(element);
           List<String> temp=new ArrayList<String>();
           temp.add("Dni: "+element.getId());
           temp.add("Nombre: " + element.getName());
           mav.addObject("result", temp);
           mav.addObject("nome","Listado de utilizadores");
           mav.addObject("link","/veronica/person/listPersonsPag");
           mav.setViewName("success");  
           /*
            * Note that there is no slash "/" right after "redirect:"
            * So, it redirects to the path relative to the current path
            */
           return mav;  
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String editBook(@Valid @ModelAttribute("person") VPerson element, BindingResult result) {
    	
           //myDao.save(element);
           myService.save(element);

           /*
            * Note that there is no slash "/" right after "redirect:"
            * So, it redirects to the path relative to the current path
            */
           return "redirect:/veronica/person/listVPersons";
    }
    
    @RequestMapping("/delete/{elementId}")
    public String deleteBook(@PathVariable("elementId") String id) {

           myService.delete(id);

           /*
            * redirects to the path relative to the current path
            */
           // return "redirect:../listBooks";

           /*
            * Note that there is the slash "/" right after "redirect:"
            * So, it redirects to the path relative to the project root path
            */
           return "redirect:/veronica/person/listVPersonsPag";
    }
    
    @RequestMapping(value="/excep/{id}", method=RequestMethod.GET)
	public String getEmployee(@PathVariable("id") int id, Model model) throws Exception{
		//deliberately throwing different types of exception
		if(id==1){
			throw new CustomException(id);
		}else if(id==2){
			throw new SQLException("SQLException, id="+id);
		}else if(id==3){
			throw new IOException("IOException, id="+id);
		}else if(id==4){
			throw new java.sql.SQLClientInfoException("SQLClientInfoException, id="+id,null);
		}else if(id==5){
			throw new ConstraintViolationException("ConstraintViolationException, id=" +id,null);
		}else if(id==10){
			
			return "redirect:/veronica/person/listVPersons";
		}else {
			throw new Exception("Generic Exception, id="+id);
		}
		
	}
    
    
    /* - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - */
	/* . . . . . . . . . . . . . EXCEPTION HANDLERS . . . . . . . . . . . . .. */
	/* - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - */

    
    @ExceptionHandler(CustomException.class)
	public ModelAndView handleEmployeeNotFoundException(HttpServletRequest request, Exception ex){
		logger.error("PEpe Requested URL="+request.getRequestURL());
		logger.error("Exception Raised="+ex);
		
		ModelAndView modelAndView = new ModelAndView();
	    modelAndView.addObject("exception", ex);
	    modelAndView.addObject("url", request.getRequestURL() );
	    
	    modelAndView.setViewName("error");
	    return modelAndView;
	}
    
    /*descomentar  
     * @ExceptionHandler(TransactionSystemException.class)
	public ModelAndView handleTransactionSystemExceptionException(HttpServletRequest request, Exception ex){
		logger.error("PEpe Requested URL="+request.getRequestURL());
		logger.error("Exception Raised="+ex);
		
		ModelAndView modelAndView = new ModelAndView();
	    modelAndView.addObject("exception", ex);
	    modelAndView.addObject("url", request.getRequestURL() );
	    
	    modelAndView.setViewName("error");
	    return modelAndView;
	}*/
    
  /*  @ExceptionHandler(ConstraintViolationException.class)
	public ModelAndView handleConstraintViolationExceptionException(HttpServletRequest request, Exception ex){
		logger.error("PEpa Requested URL="+request.getRequestURL());
		logger.error("Exception Raised="+ex);
		
		ModelAndView modelAndView = new ModelAndView();
	    modelAndView.addObject("exception", ex);
	    modelAndView.addObject("url", request.getRequestURL() );
	    
	    modelAndView.setViewName("error");
	    return modelAndView;
	}*/
    
   
    
    @ExceptionHandler({java.sql.SQLClientInfoException.class, java.sql.BatchUpdateException.class})
	public ModelAndView handleVariosException(HttpServletRequest request, Exception ex){
		logger.error("Requested URL="+request.getRequestURL());
		logger.error("Exception Raised="+ex);
		
		ModelAndView modelAndView = new ModelAndView();
	    modelAndView.addObject("exception", ex);
	    modelAndView.addObject("url", request.getRequestURL() );
	    
	    modelAndView.setViewName("error");
	    return modelAndView;
	}
    /* for jboss to catch constrainstviolationexception
    @ExceptionHandler({EJBTransactionRolledbackException.class, java.sql.BatchUpdateException.class})
   	public ModelAndView handleVariosException(HttpServletRequest request, Exception ex){
   		logger.error("Requested URL="+request.getRequestURL());
   		logger.error("Exception Raised="+ex);
   		
   		ModelAndView modelAndView = new ModelAndView();
   	    modelAndView.addObject("exception", ex);
   	    modelAndView.addObject("url", request.getRequestURL() );
   	    
   	    modelAndView.setViewName("error");
   	    return modelAndView;
   	}*/
    
    
  
    

}
