package com.goodbyenote.bapdosaptlweb.pos.memo.controller;

import java.util.List;

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
public class MemoController {
	
	private static final Logger logger = LoggerFactory.getLogger(MemoController.class);

	@Autowired
	private MemoService memoService;
	
	/**
	 * @param memo
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/pos/memo/memoList")
	public String list( MemoVO memo
			, Model model
			, HttpServletRequest request) {

		model.addAttribute("memo", memo);
		
		return "pos/memo/memoList";
	}	
	
	@RequestMapping(value = "/pos/memo/getMemoList.json")	
	public ModelAndView getMemoList( MemoVO memo
			, Model model
			, HttpServletRequest request) {
		
		List<MemoVO> memoList = memoService.getList(memo);

		ModelAndView mav = new ModelAndView();		
		ReturnJsonVO returnJsonVO = new ReturnJsonVO();
		returnJsonVO.setReturnCode("2");// 0: error, 1: returnVal 참조, 2: returnObject참조
//		returnJsonVO.setMessage(loginId);
		returnJsonVO.setReturnObj(memoList);
		mav.addObject(returnJsonVO);
		mav.setViewName("jsonView");
		
		return mav; 
	}	
	
	@RequestMapping(value = "/pos/memo/saveMemo.json", method = RequestMethod.POST)
	public ModelAndView insertAction(
			@Valid MemoVO memo,
			BindingResult result, // 파라미터 검증 결과
			RedirectAttributes redirectAttrs,
			Model model,
			HttpServletRequest request) {	

		int resultValue = memoService.insertAction(memo);
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
	
	
	@RequestMapping(value = "/pos/memo/getMemoDetail")
	public String getMemoDetail(MemoVO memo, Model model, HttpServletRequest request){
		
		MemoVO detailData = memoService.getDetail(memo);
		System.out.println("detailData:"+detailData);
		model.addAttribute("detailData",detailData);
		return "/pos/memo/memoDetail";
	}
	
}