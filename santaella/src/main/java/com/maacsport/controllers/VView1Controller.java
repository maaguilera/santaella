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



import com.maacsport.dao.VTypeDao;
import com.maacsport.dao.VView1Dao;
import com.maacsport.exceptions.CustomException;
import com.maacsport.model.VQuota;
import com.maacsport.model.VType;
import com.maacsport.model.VView1;
import com.maacsport.model.VView1All;
import com.maacsport.model.advanced.VTypeEditor;

import com.maacsport.service.VView1Service;

@Controller("vview1Controller")
@RequestMapping("/veronica/vista")
@Transactional

public class VView1Controller {
	
    @Autowired
    private VView1Service myService;
    
    @Autowired
    private VView1Dao myDao;
    @Autowired
    private VTypeDao vTypeDao;
    
    protected Logger logger;

	public VView1Controller() {
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
	
	 
	 

    
    @RequestMapping(value={"/listView1","/listView1/{typee}"},  method=RequestMethod.GET)
    public ModelAndView listView1(@PathVariable Map<String, String> pathVariablesMap, 
    								 
    								   Map<String, Object> map, 
    								   HttpServletRequest req) {
    	 
    	 PagedListHolder<VView1> productList = null;
    	 
    	 String typee = pathVariablesMap.get("typee");
    	 
    	 if(null == typee) {
             // First Request, Return first set of list
             VView1All temp = myService.getVView1All();
             
             productList = new PagedListHolder<VView1>();
             productList.setSource(temp.getPhonesList());
             productList.setPageSize(10);
             
             req.getSession().setAttribute("phonesList",  productList);
             
             req.getSession().setAttribute("vView1Group",  temp.getvView1Group());
             
             req.getSession().setAttribute("vPerson18",  temp.getPerson18());
             
             req.getSession().setAttribute("update18",  temp.getUpdate18());
         
             printPageDetails(productList);
             
         } else if("next".equals(typee)) {
             // Return next set of list
             productList = (PagedListHolder<VView1>) req.getSession()
                                 .getAttribute("phonesList");
             
             productList.nextPage();
             
             printPageDetails(productList);
             
         } else if("prev".equals(typee)) {
             // Return previous set of list
             productList = (PagedListHolder<VView1>) req.getSession()
                                 .getAttribute("phonesList");
             
             productList.previousPage();
             
             printPageDetails(productList);
             
         } else {
             // Return specific index set of list
             System.out.println("type:" + typee);
             
             productList = (PagedListHolder<VView1>) req.getSession()
                                 .getAttribute("phonesList");
             
             int pageNum = Integer.parseInt(typee);
             
             productList.setPage(pageNum);
             
             printPageDetails(productList);
         }
                              
         
         ModelAndView model = new ModelAndView("listView1");
         
       
       
                 
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
    

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelAndView saveBook(BindingResult result,HttpServletRequest req) {
    	 logger.info("Acción saveVQuota"); 
    	 ModelAndView mav = new ModelAndView(); 
    	
    	 PagedListHolder<VView1> productList = (PagedListHolder<VView1>) req.getSession().getAttribute("phonesList");
    	 
    	 if (result!=null && result.hasErrors()) {  
                                
    	   

			productList.nextPage();

			printPageDetails(productList);
			
		     mav.setViewName("list"); 
             return mav;  
        } 
    	 
           //myDao.save(element);
           //TODO myService.save(productList.getPageList());
           List<String> temp=new ArrayList<String>();
           temp.add("Quotas creadas ");
        
           mav.addObject("result", temp);
           mav.addObject("nome","Listado de Quotas");
           mav.addObject("link","/veronica/vista/listView1");
           mav.setViewName("success");  
           /*
            * Note that there is no slash "/" right after "redirect:"
            * So, it redirects to the path relative to the current path
            */
           return mav;  
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
    

      @ExceptionHandler(TransactionSystemException.class)
	public ModelAndView handleTransactionSystemExceptionException(HttpServletRequest request, Exception ex){
		logger.error("PEpe Requested URL="+request.getRequestURL());
		logger.error("Exception Raised="+ex);
		
		ModelAndView modelAndView = new ModelAndView();
	    modelAndView.addObject("exception", ex);
	    modelAndView.addObject("url", request.getRequestURL() );
	    
	    modelAndView.setViewName("error");
	    return modelAndView;
	}
    
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
