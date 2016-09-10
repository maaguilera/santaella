package com.maacsport.controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Collections;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionHandler {

	private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
	 public static final String DEFAULT_ERROR_VIEW = "error maac: ";
	 
	@ExceptionHandler(SQLException.class)
	public String handleSQLException(HttpServletRequest request, Exception ex){
		logger.info("SQLException Occured:: URL="+request.getRequestURL());
		return "database_error";
	}
	
	@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="IOException occured")
	@ExceptionHandler(IOException.class)
	public void handleIOException(){
		logger.error("IOException handler executed va para 404, not found");
		//returning 404 error code
	}
	
	@ExceptionHandler
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ModelAndView handle(HttpServletRequest request,MethodArgumentNotValidException exception) {
        
		  String temp ="";
				  for (Object object : exception.getBindingResult().getFieldErrors()) {
					    if(object instanceof FieldError) {
					        FieldError fieldError = (FieldError) object;

					        logger.info((fieldError.getCode()));
					        temp=temp+fieldError.getCode();
					    }

					    if(object instanceof ObjectError) {
					        ObjectError objectError = (ObjectError) object;

					        logger.info((objectError.getCode()));
					        temp=temp+objectError.getCode();
					    }
					}
				  
				  ModelAndView mav = new ModelAndView(DEFAULT_ERROR_VIEW);

			        mav.addObject("datetime", new Date());
			        mav.addObject("temp",temp);
			        mav.addObject("exception", exception);
			        mav.addObject("url", request.getRequestURL());
			        return mav;
                
    }


    @ExceptionHandler
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ModelAndView handle(HttpServletRequest request,ConstraintViolationException exception) {
    	ModelAndView mav = new ModelAndView(DEFAULT_ERROR_VIEW);

        mav.addObject("datetime", new Date());
        mav.addObject("exception", exception);
        mav.addObject("url", request.getRequestURL());
        return mav;
    }
    
    @ExceptionHandler
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ModelAndView handle(HttpServletRequest request,TransactionSystemException exception) {
    	ModelAndView mav = new ModelAndView(DEFAULT_ERROR_VIEW);

        mav.addObject("datetime", new Date());
        mav.addObject("exception", exception);
        mav.addObject("url", request.getRequestURL());
        return mav;
    }

    private Map error(Object message) {
        return Collections.singletonMap("error", message);
    }
}