package com.example.demo.exceptionhandler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.exception.CustomExceptions;

@ControllerAdvice
class CustomExceptionHandler {

	@ExceptionHandler(CustomExceptions.class)
	public ModelAndView logException(CustomExceptions e){
		
	    ModelAndView mv = new ModelAndView();
	    mv.addObject("exception", e);
	    mv.setViewName("error");
	    return mv;
	}
}
