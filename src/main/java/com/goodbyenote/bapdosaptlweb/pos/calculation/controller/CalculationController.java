package com.goodbyenote.bapdosaptlweb.pos.calculation.controller;

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
import com.goodbyenote.bapdosaptlweb.pos.calculation.service.CalculationService;
import com.goodbyenote.bapdosaptlweb.pos.model.CalculationVO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class CalculationController {
	
	private static final Logger logger = LoggerFactory.getLogger(CalculationController.class);
	
	@Autowired
	private CalculationService calculationService;

	@Autowired
    ServletContext context;
	
	public void setServletContext(ServletContext servletContext) {
	     this.context = servletContext;
	}
	
	/**
	 * @param calculation
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/pos/calculation/calculation")
	public String calculation( CalculationVO calculation
			, Model model
			, HttpServletRequest request) {

		model.addAttribute("calculation", calculation);
		model.addAttribute("ContextPath",context.getContextPath());
		return "pos/calculation/calculation";
	}	

	/**
	 * @param calculation
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/pos/calculation/calculationList")
	public String list( CalculationVO calculation
			, Model model
			, HttpServletRequest request) {

		model.addAttribute("calculation", calculation);
		model.addAttribute("ContextPath",context.getContextPath());
		return "pos/calculation/calculationList";
	}	
	
	@RequestMapping(value = "/pos/calculation/getCalculationList.json")	
	public ModelAndView getCalculationList( CalculationVO calculation
			, Model model
			, HttpServletRequest request) {
		
		List<CalculationVO> calculationList = calculationService.getList(calculation);

		ModelAndView mav = new ModelAndView();		
		ReturnJsonVO returnJsonVO = new ReturnJsonVO();
		returnJsonVO.setReturnCode("2");// 0: error, 1: returnVal 참조, 2: returnObject참조
//		returnJsonVO.setMessage(loginId);
		returnJsonVO.setReturnObj(calculationList);
		mav.addObject(returnJsonVO);
		mav.setViewName("jsonView");
		
		return mav; 
	}	
	
	/**
	 * @param calculation
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/pos/calculation/calculationRegist")
	public String calculationRegist( CalculationVO calculation
			, Model model
			, HttpServletRequest request) {

		model.addAttribute("calculation", calculation);
		model.addAttribute("ContextPath",context.getContextPath());
		return "pos/calculation/calculationRegist";
	}	
	
	@RequestMapping(value = "/pos/calculation/saveCalculation.json", method = RequestMethod.POST)
	public ModelAndView insertAction(
			@Valid CalculationVO calculation,
			BindingResult result, // 파라미터 검증 결과
			RedirectAttributes redirectAttrs,
			Model model,
			HttpServletRequest request) {	

		int resultValue = calculationService.insertAction(calculation);
		System.out.println("resultValue:"+resultValue);
		ModelAndView mav = new ModelAndView();		
		if(resultValue > 0){
			ReturnJsonVO returnJsonVO = new ReturnJsonVO();
			returnJsonVO.setReturnCode("1");// 0: error, 1: returnVal 참조, 2: returnObject참조
			//returnJsonVO.setReturnVal(Integer.toString(resultValue));
			returnJsonVO.setMessage("OK");
			returnJsonVO.setReturnObj(Integer.toString(resultValue));
			mav.addObject(returnJsonVO);
		}else{
			mav.addObject(null);
		}
		mav.setViewName("jsonView");
		
		return mav; 
	}
	
	@RequestMapping(value = "/pos/calculation/modifyCalculationIschecked.json", method = RequestMethod.POST)
	public ModelAndView modifyCalculationIschecked(
			@Valid CalculationVO calculation,
			BindingResult result, // 파라미터 검증 결과
			RedirectAttributes redirectAttrs,
			Model model,
			HttpServletRequest request) {	

		
		System.out.println("memberid:"+calculation.getMemberid());
		System.out.println("deviceid:"+calculation.getDeviceid());

		int resultValue = calculationService.updateCalculationIschecked(calculation);
		System.out.println("resultValue:"+resultValue);
		ModelAndView mav = new ModelAndView();		
		if(resultValue > 0){
			ReturnJsonVO returnJsonVO = new ReturnJsonVO();
			returnJsonVO.setReturnCode("1");// 0: error, 1: returnVal 참조, 2: returnObject참조
			//returnJsonVO.setReturnVal(Integer.toString(resultValue));
			returnJsonVO.setMessage("OK");
			returnJsonVO.setReturnObj(Integer.toString(resultValue));
			mav.addObject(returnJsonVO);
		}else{
			mav.addObject(null);
		}
		mav.setViewName("jsonView");
		
		return mav; 
	}
	
	@RequestMapping(value = "/pos/calculation/modifyCalculationIsimportant.json", method = RequestMethod.POST)
	public ModelAndView modifyCalculationIsimportant(
			@Valid CalculationVO calculation,
			BindingResult result, // 파라미터 검증 결과
			RedirectAttributes redirectAttrs,
			Model model,
			HttpServletRequest request) {	

		
		System.out.println("memberid:"+calculation.getMemberid());
		System.out.println("deviceid:"+calculation.getDeviceid());

		int resultValue = calculationService.updateCalculationIsimportant(calculation);
		System.out.println("resultValue:"+resultValue);
		ModelAndView mav = new ModelAndView();		
		if(resultValue > 0){
			ReturnJsonVO returnJsonVO = new ReturnJsonVO();
			returnJsonVO.setReturnCode("1");// 0: error, 1: returnVal 참조, 2: returnObject참조
			//returnJsonVO.setReturnVal(Integer.toString(resultValue));
			returnJsonVO.setMessage("OK");
			returnJsonVO.setReturnObj(Integer.toString(resultValue));
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
	 * @param calculation
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/pos/calculation/getCalculationDetail")
	public String getCalculationDetail(CalculationVO calculation, Model model, HttpServletRequest request){
		
		System.out.println("memberid:"+calculation.getMemberid());
		System.out.println("deviceid:"+calculation.getDeviceid());

		CalculationVO detailData = calculationService.getDetail(calculation);
		model.addAttribute("detailData",detailData);
		String url = "pos/calculation/calculationDetail";
		return url;
	}

//예약	
	/**
	 * @param calculation
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/pos/calculation/reservation")
	public String reservation( CalculationVO calculation
			, Model model
			, HttpServletRequest request) {

		model.addAttribute("calculation", calculation);
		model.addAttribute("ContextPath",context.getContextPath());
		return "pos/calculation/reservation";
	}	
	
	@RequestMapping(value = "/pos/calculation/getReservationList.json")	
	public ModelAndView getReservationList( CalculationVO calculation
			, Model model
			, HttpServletRequest request) {
		
		List<CalculationVO> calculationList = calculationService.getReservationList(calculation);

		ModelAndView mav = new ModelAndView();		
		ReturnJsonVO returnJsonVO = new ReturnJsonVO();
		returnJsonVO.setReturnCode("2");// 0: error, 1: returnVal 참조, 2: returnObject참조
//		returnJsonVO.setMessage(loginId);
		returnJsonVO.setReturnObj(calculationList);
		mav.addObject(returnJsonVO);
		mav.setViewName("jsonView");
		
		return mav; 
	}	
	
//고객요구
	
	/**
	 * @param calculation
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/pos/calculation/customerRequest")
	public String customerRequest( CalculationVO calculation
			, Model model
			, HttpServletRequest request) {

		model.addAttribute("calculation", calculation);
		model.addAttribute("ContextPath",context.getContextPath());
		return "pos/calculation/customerRequest";
	}	
	
	@RequestMapping(value = "/pos/calculation/getCustomerRequestList.json")	
	public ModelAndView getCustomerRequestList( CalculationVO calculation
			, Model model
			, HttpServletRequest request) {
		
		List<CalculationVO> calculationList = calculationService.getCustomerRequestList(calculation);

		ModelAndView mav = new ModelAndView();		
		ReturnJsonVO returnJsonVO = new ReturnJsonVO();
		returnJsonVO.setReturnCode("2");// 0: error, 1: returnVal 참조, 2: returnObject참조
//		returnJsonVO.setMessage(loginId);
		returnJsonVO.setReturnObj(calculationList);
		mav.addObject(returnJsonVO);
		mav.setViewName("jsonView");
		
		return mav; 
	}		
}