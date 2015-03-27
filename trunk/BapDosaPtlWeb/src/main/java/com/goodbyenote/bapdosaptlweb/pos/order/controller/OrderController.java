package com.goodbyenote.bapdosaptlweb.pos.order.controller;

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
import com.goodbyenote.bapdosaptlweb.pos.model.OrderVO;
import com.goodbyenote.bapdosaptlweb.pos.order.service.OrderService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class OrderController {
	
	private static final Logger logger = LoggerFactory.getLogger(OrderController.class);

	@Autowired
    ServletContext context; 
	
	@Autowired
	private OrderService orderService;
	
	public void setServletContext(ServletContext servletContext) {
	     this.context = servletContext;
	}
	
	/**
	 * @param order
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/pos/order/orderMain")
	public String list( OrderVO order
			, Model model
			, HttpServletRequest request) {

		model.addAttribute("order", order);
		model.addAttribute("ContextPath",context.getContextPath());
		return "pos/order/orderMain";
	}	
	
	@RequestMapping(value = "/pos/order/getOrderList.json")	
	public ModelAndView getOrderList( OrderVO order
			, Model model
			, HttpServletRequest request) {
		
		List<OrderVO> orderList = orderService.getList(order);

		ModelAndView mav = new ModelAndView();		
		ReturnJsonVO returnJsonVO = new ReturnJsonVO();
		returnJsonVO.setReturnCode("2");// 0: error, 1: returnVal 참조, 2: returnObject참조
//		returnJsonVO.setMessage(loginId);
		returnJsonVO.setReturnObj(orderList);
		mav.addObject(returnJsonVO);
		mav.setViewName("jsonView");
		
		return mav; 
	}	
	
	@RequestMapping(value = "/pos/order/saveOrder.json", method = RequestMethod.POST)
	public ModelAndView insertAction(
			@Valid OrderVO order,
			BindingResult result, // 파라미터 검증 결과
			RedirectAttributes redirectAttrs,
			Model model,
			HttpServletRequest request) {	

		int resultValue = orderService.insertAction(order);
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
	
	@RequestMapping(value = "/pos/order/modifyOrderIschecked.json", method = RequestMethod.POST)
	public ModelAndView modifyOrderIschecked(
			@Valid OrderVO order,
			BindingResult result, // 파라미터 검증 결과
			RedirectAttributes redirectAttrs,
			Model model,
			HttpServletRequest request) {	

		
		System.out.println("memberid:"+order.getMemberid());
		System.out.println("deviceid:"+order.getDeviceid());

		int resultValue = orderService.updateOrderIschecked(order);
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
	
	@RequestMapping(value = "/pos/order/modifyOrderIsimportant.json", method = RequestMethod.POST)
	public ModelAndView modifyOrderIsimportant(
			@Valid OrderVO order,
			BindingResult result, // 파라미터 검증 결과
			RedirectAttributes redirectAttrs,
			Model model,
			HttpServletRequest request) {	

		
		System.out.println("memberid:"+order.getMemberid());
		System.out.println("deviceid:"+order.getDeviceid());

		int resultValue = orderService.updateOrderIsimportant(order);
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
	
	/**
	 * 메모 상세 조회
	 * 메모 유형
	 * A	메모
	 * B	예약
	 * C	예약해지
	 * D	고객요구
	 * E	이동
	 * F	합석
	 * G	연결
	 * H	연결해제
	 * I	주문
	 * J	포장
	 * K	배달
	 * L	포장판매
	 * M	손실
	 * N	배달실패
	 * O	식권
	 * @param order
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/pos/order/getOrderDetail")
	public String getOrderDetail(OrderVO order, Model model, HttpServletRequest request){
		
		System.out.println("memberid:"+order.getMemberid());
		System.out.println("deviceid:"+order.getDeviceid());

		OrderVO detailData = orderService.getDetail(order);
		model.addAttribute("detailData",detailData);
		String url = "pos/order/orderDetail";
		return url;
	}
	
}