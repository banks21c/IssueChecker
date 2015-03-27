package com.goodbyenote.bapdosaptlweb.pos.order.customer.controller;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.goodbyenote.bapdosaptlweb.common.model.ReturnJsonVO;
import com.goodbyenote.bapdosaptlweb.pos.model.CustomerVO;
import com.goodbyenote.bapdosaptlweb.pos.order.customer.service.CustomerService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class CustomerController {
	
	private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);

	@Autowired
	private CustomerService customerService;
	
	@Autowired
    ServletContext context;
	
	public void setServletContext(ServletContext servletContext) {
	     this.context = servletContext;
	}
	
	
	/**
	 * @param customer
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/pos/order/customer/regularList")
	public String regularList( CustomerVO customer
			, Model model
			, HttpServletRequest request) {

		model.addAttribute("customer", customer);
		model.addAttribute("ContextPath",context.getContextPath());		
		return "pos/order/customer/regularList";
	}		
	/**
	 * @param customer
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/pos/order/customer/regularOrderHistory")
	public String list( CustomerVO customer
			, Model model
			, HttpServletRequest request) {

		model.addAttribute("customer", customer);
		model.addAttribute("ContextPath",context.getContextPath());		
		return "pos/order/customer/regularOrderHistory";
	}	
	
	@RequestMapping(value = "/pos/order/customer/getMemoList.json")	
	public ModelAndView getMemoList( CustomerVO customer
			, Model model
			, HttpServletRequest request) {
		
		List<CustomerVO> customerOrderList = customerService.getList(customer);

		ModelAndView mav = new ModelAndView();		
		ReturnJsonVO returnJsonVO = new ReturnJsonVO();
		returnJsonVO.setReturnCode("2");// 0: error, 1: returnVal 참조, 2: returnObject참조
//		returnJsonVO.setMessage(loginId);
		returnJsonVO.setReturnObj(customerOrderList);
		mav.addObject(returnJsonVO);
		mav.setViewName("jsonView");
		
		return mav; 
	}	
	
	@RequestMapping(value = "/pos/order/customer/saveMemo.json", method = RequestMethod.POST)
	public ModelAndView insertAction(
			@Valid CustomerVO customer,
			BindingResult result, // 파라미터 검증 결과
			RedirectAttributes redirectAttrs,
			Model model,
			HttpServletRequest request) {	

		int resultValue = customerService.insertAction(customer);
		System.out.println("resultValue:"+resultValue);
		ModelAndView mav = new ModelAndView();		
		if(resultValue > 0){
			ReturnJsonVO returnJsonVO = new ReturnJsonVO();
			returnJsonVO.setReturnCode("1");// 0: error, 1: returnVal 참조, 2: returnObject참조
			returnJsonVO.setReturnVal(Integer.toString(resultValue));
			returnJsonVO.setMessage("OK");
			returnJsonVO.setReturnObj("");
			mav.addObject(returnJsonVO);
		}else{
			mav.addObject(null);
		}
		mav.setViewName("jsonView");
		
		return mav; 
	}
	
	
	@RequestMapping(value = "/pos/order/customer/regularDetail")
	public String regularDetail(CustomerVO customer, Model model, HttpServletRequest request){
		
		model.addAttribute("ContextPath",context.getContextPath());		
		return "/pos/order/customer/regularDetail";
	}

	@RequestMapping(value = "/pos/order/customer/getRegularDetail.json")	
	public ModelAndView getRegularDetail( CustomerVO customer
			, Model model
			, HttpServletRequest request) {
		
		CustomerVO regular = customerService.getRegularDetail(customer);

		ModelAndView mav = new ModelAndView();		
		ReturnJsonVO returnJsonVO = new ReturnJsonVO();
		returnJsonVO.setReturnCode("2");// 0: error, 1: returnVal 참조, 2: returnObject참조
//		returnJsonVO.setMessage(loginId);
		returnJsonVO.setReturnObj(regular);
		mav.addObject(returnJsonVO);
		mav.setViewName("jsonView");
		
		return mav; 
	}
	
}