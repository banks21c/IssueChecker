package com.goodbyenote.issuechecker.pos.main.controller;

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

import com.goodbyenote.issuechecker.common.model.ReturnJsonVO;
import com.goodbyenote.issuechecker.pos.main.service.MainService;
import com.goodbyenote.issuechecker.pos.model.MainVO;
import com.goodbyenote.issuechecker.pos.order.service.OrderService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class MainController {
	
	private static final Logger logger = LoggerFactory.getLogger(MainController.class);

	@Autowired
    ServletContext context; 
	
	@Autowired
	private MainService mainService;
	
	
	public void setServletContext(ServletContext servletContext) {
	     this.context = servletContext;
	}
	
	/**
	 * @param main
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/pos/main/posMain.do")
	public String posMain() {

		return "pos/main/posMain";
	}	
	
	
	
	
	
	@RequestMapping(value = "/pos/main/getMainList.json")	
	public ModelAndView getMainList( MainVO main
			, Model model
			, HttpServletRequest request) {
		
		List<MainVO> mainList = mainService.getList(main);

		ModelAndView mav = new ModelAndView();		
		ReturnJsonVO returnJsonVO = new ReturnJsonVO();
		returnJsonVO.setReturnCode("2");// 0: error, 1: returnVal 참조, 2: returnObject참조
//		returnJsonVO.setMessage(loginId);
		returnJsonVO.setReturnObj(mainList);
		mav.addObject(returnJsonVO);
		mav.setViewName("jsonView");
		
		return mav; 
	}	
	
	@RequestMapping(value = "/pos/main/saveMain.json", method = RequestMethod.POST)
	public ModelAndView insertAction(
			@Valid MainVO main,
			BindingResult result, // 파라미터 검증 결과
			RedirectAttributes redirectAttrs,
			Model model,
			HttpServletRequest request) {	

		int resultValue = mainService.insertAction(main);
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
	
	@RequestMapping(value = "/pos/main/modifyMainIschecked.json", method = RequestMethod.POST)
	public ModelAndView modifyMainIschecked(
			@Valid MainVO main,
			BindingResult result, // 파라미터 검증 결과
			RedirectAttributes redirectAttrs,
			Model model,
			HttpServletRequest request) {	

		
		System.out.println("ischecked:"+main.getIschecked());
		System.out.println("memberid:"+main.getMemberid());
		System.out.println("deviceid:"+main.getDeviceid());

		int resultValue = mainService.updateMainIschecked(main);
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
	
	@RequestMapping(value = "/pos/main/modifyMainIsimportant.json", method = RequestMethod.POST)
	public ModelAndView modifyMainIsimportant(
			@Valid MainVO main,
			BindingResult result, // 파라미터 검증 결과
			RedirectAttributes redirectAttrs,
			Model model,
			HttpServletRequest request) {	

		
		System.out.println("isimportant:"+main.getIsimportant());
		System.out.println("memberid:"+main.getMemberid());
		System.out.println("deviceid:"+main.getDeviceid());

		int resultValue = mainService.updateMainIsimportant(main);
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
	 * @param main
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/pos/main/getMainDetail")
	public String getMainDetail(MainVO main, Model model, HttpServletRequest request){
		
		System.out.println("memberid:"+main.getMemberid());
		System.out.println("deviceid:"+main.getDeviceid());

		MainVO detailData = mainService.getDetail(main);
		System.out.println("detailData contents:"+detailData.getContents());
		System.out.println("detailData isimportant:"+detailData.getIsimportant());
		model.addAttribute("detailData",detailData);
		String url = "pos/main/mainDetail";
		return url;
	}
	
}