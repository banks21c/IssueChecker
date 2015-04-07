package com.goodbyenote.bapdosaptlweb.pos.point.controller;

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
import com.goodbyenote.bapdosaptlweb.pos.point.service.PointService;
import com.goodbyenote.bapdosaptlweb.pos.model.PointVO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class PointController {
	
	private static final Logger logger = LoggerFactory.getLogger(PointController.class);
	
	@Autowired
	private PointService pointService;

	@Autowired
    ServletContext context;
	
	public void setServletContext(ServletContext servletContext) {
	     this.context = servletContext;
	}
	
	/**
	 * @param point
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/pos/point/pointManage")
	public String pointManage( PointVO point
			, Model model
			, HttpServletRequest request) {

		model.addAttribute("point", point);
		model.addAttribute("ContextPath",context.getContextPath());
		return "pos/point/pointManage";
	}	
	
	@RequestMapping(value = "/pos/point/getPointList.json")	
	public ModelAndView getPointList( PointVO point
			, Model model
			, HttpServletRequest request) {
		
		List<PointVO> pointList = pointService.getList(point);

		ModelAndView mav = new ModelAndView();		
		ReturnJsonVO returnJsonVO = new ReturnJsonVO();
		returnJsonVO.setReturnCode("2");// 0: error, 1: returnVal 참조, 2: returnObject참조
//		returnJsonVO.setMessage(loginId);
		returnJsonVO.setReturnObj(pointList);
		mav.addObject(returnJsonVO);
		mav.setViewName("jsonView");
		
		return mav; 
	}	
	
	/**
	 * @param point
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/pos/point/pointRegist")
	public String pointRegist( PointVO point
			, Model model
			, HttpServletRequest request) {

		model.addAttribute("point", point);
		model.addAttribute("ContextPath",context.getContextPath());
		return "pos/point/pointRegist";
	}	
	
	@RequestMapping(value = "/pos/point/savePoint.json", method = RequestMethod.POST)
	public ModelAndView insertAction(
			@Valid PointVO point,
			BindingResult result, // 파라미터 검증 결과
			RedirectAttributes redirectAttrs,
			Model model,
			HttpServletRequest request) {	

		int resultValue = pointService.insertAction(point);
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
	
	@RequestMapping(value = "/pos/point/modifyPointIschecked.json", method = RequestMethod.POST)
	public ModelAndView modifyPointIschecked(
			@Valid PointVO point,
			BindingResult result, // 파라미터 검증 결과
			RedirectAttributes redirectAttrs,
			Model model,
			HttpServletRequest request) {	

		
		System.out.println("memberid:"+point.getMemberid());
		System.out.println("deviceid:"+point.getDeviceid());
		System.out.println("pointid:"+point.getPointid());

		int resultValue = pointService.updatePointIschecked(point);
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
	
	@RequestMapping(value = "/pos/point/modifyPointIsimportant.json", method = RequestMethod.POST)
	public ModelAndView modifyPointIsimportant(
			@Valid PointVO point,
			BindingResult result, // 파라미터 검증 결과
			RedirectAttributes redirectAttrs,
			Model model,
			HttpServletRequest request) {	

		
		System.out.println("memberid:"+point.getMemberid());
		System.out.println("deviceid:"+point.getDeviceid());
		System.out.println("pointid:"+point.getPointid());

		int resultValue = pointService.updatePointIsimportant(point);
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
	 * @param point
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/pos/point/getPointDetail")
	public String getPointDetail(PointVO point, Model model, HttpServletRequest request){
		
		System.out.println("memberid:"+point.getMemberid());
		System.out.println("deviceid:"+point.getDeviceid());
		System.out.println("pointid:"+point.getPointid());

		PointVO detailData = pointService.getDetail(point);
		model.addAttribute("detailData",detailData);
		String url = "pos/point/pointDetail";
		System.out.println("detailData.getPointtype():"+detailData.getPointtype());
		return url;
	}

//예약	
	/**
	 * @param point
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/pos/point/reservation")
	public String reservation( PointVO point
			, Model model
			, HttpServletRequest request) {

		model.addAttribute("point", point);
		model.addAttribute("ContextPath",context.getContextPath());
		return "pos/point/reservation";
	}	
	
	@RequestMapping(value = "/pos/point/getReservationList.json")	
	public ModelAndView getReservationList( PointVO point
			, Model model
			, HttpServletRequest request) {
		
		List<PointVO> pointList = pointService.getReservationList(point);

		ModelAndView mav = new ModelAndView();		
		ReturnJsonVO returnJsonVO = new ReturnJsonVO();
		returnJsonVO.setReturnCode("2");// 0: error, 1: returnVal 참조, 2: returnObject참조
//		returnJsonVO.setMessage(loginId);
		returnJsonVO.setReturnObj(pointList);
		mav.addObject(returnJsonVO);
		mav.setViewName("jsonView");
		
		return mav; 
	}	
	
//고객요구
	
	/**
	 * @param point
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/pos/point/customerRequest")
	public String customerRequest( PointVO point
			, Model model
			, HttpServletRequest request) {

		model.addAttribute("point", point);
		model.addAttribute("ContextPath",context.getContextPath());
		return "pos/point/customerRequest";
	}	
	
	@RequestMapping(value = "/pos/point/getCustomerRequestList.json")	
	public ModelAndView getCustomerRequestList( PointVO point
			, Model model
			, HttpServletRequest request) {
		
		List<PointVO> pointList = pointService.getCustomerRequestList(point);

		ModelAndView mav = new ModelAndView();		
		ReturnJsonVO returnJsonVO = new ReturnJsonVO();
		returnJsonVO.setReturnCode("2");// 0: error, 1: returnVal 참조, 2: returnObject참조
//		returnJsonVO.setMessage(loginId);
		returnJsonVO.setReturnObj(pointList);
		mav.addObject(returnJsonVO);
		mav.setViewName("jsonView");
		
		return mav; 
	}		
}