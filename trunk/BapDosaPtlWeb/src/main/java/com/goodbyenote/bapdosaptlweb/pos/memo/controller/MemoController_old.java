package com.goodbyenote.bapdosaptlweb.pos.memo.controller;

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
import com.goodbyenote.bapdosaptlweb.pos.memo.service.MemoService;
import com.goodbyenote.bapdosaptlweb.pos.model.MemoVO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class MemoController_old {
	
	private static final Logger logger = LoggerFactory.getLogger(MemoController_old.class);
	
//	@Autowired
//	private MemoService memoService;
//
//	@Autowired
//    ServletContext context;
//	
//	public void setServletContext(ServletContext servletContext) {
//	     this.context = servletContext;
//	}
//	
//	/**
//	 * @param memo
//	 * @param model
//	 * @param request
//	 * @return
//	 */
//	@RequestMapping(value = "/pos/memo/memoList")
//	public String list( MemoVO memo
//			, Model model
//			, HttpServletRequest request) {
//
//		model.addAttribute("memo", memo);
//		model.addAttribute("ContextPath",context.getContextPath());
//
//		return "pos/memo/memoList";
//	}	
//	
//	@RequestMapping(value = "/pos/memo/getMemoList.json")	
//	public ModelAndView getMemoList( MemoVO memo
//			, Model model
//			, HttpServletRequest request) {
//		
//		List<MemoVO> memoList = memoService.getList(memo);
//
//		ModelAndView mav = new ModelAndView();		
//		ReturnJsonVO returnJsonVO = new ReturnJsonVO();
//		returnJsonVO.setReturnCode("2");// 0: error, 1: returnVal 참조, 2: returnObject참조
////		returnJsonVO.setMessage(loginId);
//		returnJsonVO.setReturnObj(memoList);
//		mav.addObject(returnJsonVO);
//		mav.setViewName("jsonView");
//		
//		return mav; 
//	}	
//	
//	/**
//	 * @param memo
//	 * @param model
//	 * @param request
//	 * @return
//	 */
//	@RequestMapping(value = "/pos/memo/memoRegist")
//	public String memoRegist( MemoVO memo
//			, Model model
//			, HttpServletRequest request) {
//
//		model.addAttribute("memo", memo);
//		model.addAttribute("ContextPath",context.getContextPath());
//		return "pos/memo/memoRegist";
//	}	
//	
//	@RequestMapping(value = "/pos/memo/saveMemo.json", method = RequestMethod.POST)
//	public ModelAndView insertAction(
//			@Valid MemoVO memo,
//			BindingResult result, // 파라미터 검증 결과
//			RedirectAttributes redirectAttrs,
//			Model model,
//			HttpServletRequest request) {	
//
//		int resultValue = memoService.insertAction(memo);
//		System.out.println("resultValue:"+resultValue);
//		ModelAndView mav = new ModelAndView();		
//		if(resultValue > 0){
//			ReturnJsonVO returnJsonVO = new ReturnJsonVO();
//			returnJsonVO.setReturnCode("1");// 0: error, 1: returnVal 참조, 2: returnObject참조
//			//returnJsonVO.setReturnVal(Integer.toString(resultValue));
//			returnJsonVO.setMessage("OK");
//			returnJsonVO.setReturnObj(Integer.toString(resultValue));
//			mav.addObject(returnJsonVO);
//		}else{
//			mav.addObject(null);
//		}
//		mav.setViewName("jsonView");
//		
//		return mav; 
//	}
//	
//	@RequestMapping(value = "/pos/memo/modifyMemoIschecked.json", method = RequestMethod.POST)
//	public ModelAndView modifyMemoIschecked(
//			@Valid MemoVO memo,
//			BindingResult result, // 파라미터 검증 결과
//			RedirectAttributes redirectAttrs,
//			Model model,
//			HttpServletRequest request) {	
//
//		
//		System.out.println("ischecked:"+memo.getIschecked());
//		System.out.println("memberid:"+memo.getMemberid());
//		System.out.println("deviceid:"+memo.getDeviceid());
//		System.out.println("memoid:"+memo.getMemoid());
//
//		int resultValue = memoService.updateMemoIschecked(memo);
//		System.out.println("resultValue:"+resultValue);
//		ModelAndView mav = new ModelAndView();		
//		if(resultValue > 0){
//			ReturnJsonVO returnJsonVO = new ReturnJsonVO();
//			returnJsonVO.setReturnCode("1");// 0: error, 1: returnVal 참조, 2: returnObject참조
//			//returnJsonVO.setReturnVal(Integer.toString(resultValue));
//			returnJsonVO.setMessage("OK");
//			returnJsonVO.setReturnObj(Integer.toString(resultValue));
//			mav.addObject(returnJsonVO);
//		}else{
//			mav.addObject(null);
//		}
//		mav.setViewName("jsonView");
//		
//		return mav; 
//	}
//	
//	@RequestMapping(value = "/pos/memo/modifyMemoIsimportant.json", method = RequestMethod.POST)
//	public ModelAndView modifyMemoIsimportant(
//			@Valid MemoVO memo,
//			BindingResult result, // 파라미터 검증 결과
//			RedirectAttributes redirectAttrs,
//			Model model,
//			HttpServletRequest request) {	
//
//		
//		System.out.println("isimportant:"+memo.getIsimportant());
//		System.out.println("memberid:"+memo.getMemberid());
//		System.out.println("deviceid:"+memo.getDeviceid());
//		System.out.println("memoid:"+memo.getMemoid());
//
//		int resultValue = memoService.updateMemoIsimportant(memo);
//		System.out.println("resultValue:"+resultValue);
//		ModelAndView mav = new ModelAndView();		
//		if(resultValue > 0){
//			ReturnJsonVO returnJsonVO = new ReturnJsonVO();
//			returnJsonVO.setReturnCode("1");// 0: error, 1: returnVal 참조, 2: returnObject참조
//			//returnJsonVO.setReturnVal(Integer.toString(resultValue));
//			returnJsonVO.setMessage("OK");
//			returnJsonVO.setReturnObj(Integer.toString(resultValue));
//			mav.addObject(returnJsonVO);
//		}else{
//			mav.addObject(null);
//		}
//		mav.setViewName("jsonView");
//		
//		return mav; 
//	}
//	
//	/**
//	 * 메모 상세 조회
//	 * 메모 유형
//	 * A	메모
//	 * B	예약
//	 * C	예약해지
//	 * D	고객요구
//	 * E	이동
//	 * F	합석
//	 * G	연결
//	 * H	연결해제
//	 * I	주문
//	 * J	포장
//	 * K	배달
//	 * L	포장판매
//	 * M	손실
//	 * N	배달실패
//	 * O	식권
//	 * @param memo
//	 * @param model
//	 * @param request
//	 * @return
//	 */
//	@RequestMapping(value = "/pos/memo/getMemoDetail")
//	public String getMemoDetail(MemoVO memo, Model model, HttpServletRequest request){
//		
//		System.out.println("memberid:"+memo.getMemberid());
//		System.out.println("deviceid:"+memo.getDeviceid());
//		System.out.println("memoid:"+memo.getMemoid());
//
//		MemoVO detailData = memoService.getDetail(memo);
//		System.out.println("detailData contents:"+detailData.getContents());
//		System.out.println("detailData isimportant:"+detailData.getIsimportant());
//		model.addAttribute("detailData",detailData);
//		String url = "pos/memo/memoDetail";
//		System.out.println("detailData.getMemotype():"+detailData.getMemotype());
//		return url;
//	}
//
////예약	
//	/**
//	 * @param memo
//	 * @param model
//	 * @param request
//	 * @return
//	 */
//	@RequestMapping(value = "/pos/memo/reservation")
//	public String reservation( MemoVO memo
//			, Model model
//			, HttpServletRequest request) {
//
//		model.addAttribute("memo", memo);
//		model.addAttribute("ContextPath",context.getContextPath());
//		return "pos/memo/reservation";
//	}	
//	
//	@RequestMapping(value = "/pos/memo/getReservationList.json")	
//	public ModelAndView getReservationList( MemoVO memo
//			, Model model
//			, HttpServletRequest request) {
//		
//		List<MemoVO> memoList = memoService.getReservationList(memo);
//
//		ModelAndView mav = new ModelAndView();		
//		ReturnJsonVO returnJsonVO = new ReturnJsonVO();
//		returnJsonVO.setReturnCode("2");// 0: error, 1: returnVal 참조, 2: returnObject참조
////		returnJsonVO.setMessage(loginId);
//		returnJsonVO.setReturnObj(memoList);
//		mav.addObject(returnJsonVO);
//		mav.setViewName("jsonView");
//		
//		return mav; 
//	}	
//	
////고객요구
//	
//	/**
//	 * @param memo
//	 * @param model
//	 * @param request
//	 * @return
//	 */
//	@RequestMapping(value = "/pos/memo/customerRequest")
//	public String customerRequest( MemoVO memo
//			, Model model
//			, HttpServletRequest request) {
//
//		model.addAttribute("memo", memo);
//		model.addAttribute("ContextPath",context.getContextPath());
//		return "pos/memo/customerRequest";
//	}	
//	
//	@RequestMapping(value = "/pos/memo/getCustomerRequestList.json")	
//	public ModelAndView getCustomerRequestList( MemoVO memo
//			, Model model
//			, HttpServletRequest request) {
//		
//		List<MemoVO> memoList = memoService.getCustomerRequestList(memo);
//
//		ModelAndView mav = new ModelAndView();		
//		ReturnJsonVO returnJsonVO = new ReturnJsonVO();
//		returnJsonVO.setReturnCode("2");// 0: error, 1: returnVal 참조, 2: returnObject참조
////		returnJsonVO.setMessage(loginId);
//		returnJsonVO.setReturnObj(memoList);
//		mav.addObject(returnJsonVO);
//		mav.setViewName("jsonView");
//		
//		return mav; 
//	}		
}