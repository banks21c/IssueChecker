package com.goodbyenote.bapdosaptlweb.common.exception;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.goodbyenote.bapdosaptlweb.common.model.ExceptionVO;
import com.goodbyenote.bapdosaptlweb.common.model.ReturnJsonVO;
import com.goodbyenote.bapdosaptlweb.common.service.CommonService;


@ControllerAdvice
public class DefaultControllerAdvice {
	
	private static final Logger logger = LoggerFactory.getLogger(DefaultControllerAdvice.class);
	
	@Autowired
	CommonService commonService;
	
    @ExceptionHandler(RequriedLoginException.class)
    public ModelAndView handleBusinessException(RequriedLoginException ex, HttpServletRequest request) {
    	
    	String url = request.getRequestURI();
    	String extention = url.substring( url.lastIndexOf(".") + 1);	
    	
    	//logger.error("capture exception: @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@" + ex + " : " + url  + " extention: " + extention);    
    	
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		ex.printStackTrace(pw);
		String stackTrace = sw.toString();    	
		
		ExceptionVO exceptionVO = new ExceptionVO();
		exceptionVO.setUrl(url);
		
		if(ex.getCause() != null){
			exceptionVO.setCause(ex.getCause().toString());
		} else {
			exceptionVO.setCause(ex.toString());
		}
		exceptionVO.setStackTrace(stackTrace);	
		
		System.out.println(exceptionVO);

		//디비 처리 안함
		//commonService.insertExceptionLog(exceptionVO);	
		
		ModelAndView mav = new ModelAndView();		
		ReturnJsonVO returnJsonVO = new ReturnJsonVO();
		returnJsonVO.setReturnCode("0");// 1: 정상, 0: error
		returnJsonVO.setReturnErrorCode("201");  // 201: 로그인에러 
		returnJsonVO.setMessage("로그인하셔야 합니다.");
		returnJsonVO.setReturnErrorException(exceptionVO.getCause());
		returnJsonVO.setReturnErrorStackTrace(exceptionVO.getStackTrace());		
		mav.addObject(returnJsonVO);
		if("json".equals(extention)){
			mav.setViewName("jsonView");
		} else {
			mav.setViewName("error/error");
		}
		
        return mav;
    }
    
	@ExceptionHandler(RuntimeException.class)
	public ModelAndView handleRuntimeException(RuntimeException ex, HttpServletRequest request) {
    	
		logger.error("에러임 RuntimeException: {}", ex);
		
    	String url = request.getRequestURI();
    	String extention = url.substring( url.lastIndexOf(".") + 1);	
    	
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		ex.printStackTrace(pw);
		String stackTrace = sw.toString();    	
		
		ExceptionVO exceptionVO = new ExceptionVO();
		exceptionVO.setUrl(url);
		if(ex.getCause() != null){
			exceptionVO.setCause(ex.getCause().toString());
		} else {
			exceptionVO.setCause(ex.toString());
		}
		exceptionVO.setStackTrace(stackTrace);		

		//디비 처리
		commonService.insertExceptionLog(exceptionVO);
    	
		ModelAndView mav = new ModelAndView();		
		ReturnJsonVO returnJsonVO = new ReturnJsonVO();
		returnJsonVO.setReturnCode("1");// 1: 정상, 0: error
		returnJsonVO.setReturnErrorCode("202");  // 202: RuntimeException
		returnJsonVO.setMessage("exception error");
		returnJsonVO.setReturnErrorException(exceptionVO.getCause());
		returnJsonVO.setReturnErrorStackTrace(exceptionVO.getStackTrace());
		mav.addObject(returnJsonVO);
		if("json".equals(extention)){
			mav.setViewName("jsonView");			
		} else {
			mav.setViewName("error/error");
		}		
		
        return mav;    	

    }
    
    
    
    
}
