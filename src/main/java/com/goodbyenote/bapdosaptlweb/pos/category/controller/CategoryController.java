package com.goodbyenote.bapdosaptlweb.pos.category.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.goodbyenote.bapdosaptlweb.common.model.ReturnJsonVO;
import com.goodbyenote.bapdosaptlweb.common.model.SessionUserInfo;
import com.goodbyenote.bapdosaptlweb.pos.category.service.CategoryService;
import com.goodbyenote.bapdosaptlweb.pos.model.CategoryVO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class CategoryController {
	
	private static final Logger logger = LoggerFactory.getLogger(CategoryController.class);
	
	@Autowired
	private CategoryService categoryService;

	@Autowired
    ServletContext context;
	
	public void setServletContext(ServletContext servletContext) {
	     this.context = servletContext;
	}
	
	/**
	 * @param category
	 * @param model
	 * @param request
	 * @param httpSession 
	 * @param memberid 
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked", "unused" })
	@RequestMapping("/pos/category/categoryManage")
	public String getCategoryList( Model model, @RequestParam Map parametaMap, HttpServletRequest request, HttpSession httpSession) {
		
		SessionUserInfo sessionUserInfo = (SessionUserInfo)httpSession.getAttribute("SESSION_USER_INFO");
		
		HashMap searchCondition = new HashMap();		
		
		String isetc = (String)parametaMap.get("isetc");
		String iseditable = (String)parametaMap.get("iseditable");
		
		searchCondition.put("memberid", sessionUserInfo.getMemberId());
		searchCondition.put("isetc", isetc);
		searchCondition.put("iseditable", "Y");
		
		List<Map> categoryList = categoryService.getCategoryList(searchCondition);
		logger.debug("categoryList: " + categoryList);
		//model.addAttribute("adminType", sessionAdminInfo.getAdminTypeCmCode());
		model.addAttribute("categoryList", categoryList);
		model.addAttribute("parametaMap", parametaMap);	
		
		return "pos/category/categoryManage";
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/pos/category/getCategoryJsonList.json")	
	public ModelAndView getCategoryJsonList( @RequestParam Map parametaMap, Model model, HttpServletRequest request ,HttpSession httpSession) {
		
		SessionUserInfo sessionUserInfo = (SessionUserInfo)httpSession.getAttribute("SESSION_USER_INFO");
		
		HashMap searchCondition = new HashMap();		
		
		searchCondition.put("memberid", sessionUserInfo.getMemberId());
		
		List<Map> categoryJsonList = categoryService.getCategoryJsonList(searchCondition);		
		logger.debug("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@categoryJsonList: " + categoryJsonList);
		
		for(int i=0; i<categoryJsonList.size();i++){
			
			Map  categoryMap = categoryJsonList.get(i);			
			BigDecimal categoryid = (BigDecimal)categoryMap.get("CATEGORYID");			
			
			searchCondition.put("categoryid", categoryid);
			
			List<Map> categoryMenuList = categoryService.getCategoryMenuJsonList(searchCondition);
			for(Map categoryMenu : categoryMenuList){
				logger.debug("#################################################categoryMenu: " + categoryMenu);
				
			}
						
			categoryMap.put("categoryMenuList", categoryMenuList);
		}
		
		ModelAndView mav = new ModelAndView();		
		ReturnJsonVO returnJsonVO = new ReturnJsonVO();
		returnJsonVO.setReturnCode("1");// 0: error, 1: 성공
//		returnJsonVO.setMessage(loginId);
		returnJsonVO.setReturnObj(categoryJsonList);		
		logger.debug("categoryJsonList: " + categoryJsonList);
		mav.addObject(returnJsonVO);
		mav.setViewName("jsonView");
		
		return mav;
		
	}
	
	@SuppressWarnings("rawtypes")
	@RequestMapping("/pos/category/insert_ok.json")
	public ModelAndView categoryInsertOk(Model model, @RequestParam Map parametaMap){
		logger.debug(parametaMap.toString());		
		
		categoryService.insertCategory(parametaMap);		
		
		ModelAndView mav = new ModelAndView();		
		ReturnJsonVO returnJsonVO = new ReturnJsonVO();
		
		mav.addObject(returnJsonVO);
		mav.setViewName("jsonView");		
		
		return mav; 
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping("/pos/category/update_ok.json")
	public ModelAndView categoryUpdateOk(Model model, @RequestParam Map parametaMap , HttpSession httpSession){
		
		SessionUserInfo sessionUserInfo = (SessionUserInfo)httpSession.getAttribute("SESSION_USER_INFO");
		
		logger.debug(parametaMap.toString());
		
		parametaMap.put("memberId", sessionUserInfo.getMemberId());
		parametaMap.put("deviceid", sessionUserInfo.getDeviceId());
		
		categoryService.updateCategory(parametaMap);		
		
		ModelAndView mav = new ModelAndView();		
		ReturnJsonVO returnJsonVO = new ReturnJsonVO();
		logger.debug("#################returnJsonVO=" + returnJsonVO.toString());	
		mav.addObject(returnJsonVO);
		mav.setViewName("jsonView");		
		
		return mav; 
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked", "unused" })
	@RequestMapping("/pos/category/categoryMenuManage")
	public String getCategoryMenuList( Model model, @RequestParam Map parametaMap, HttpServletRequest request, HttpSession httpSession) {
		
		SessionUserInfo sessionUserInfo = (SessionUserInfo)httpSession.getAttribute("SESSION_USER_INFO");
		
		HashMap searchCondition = new HashMap();
		String categoryid = (String)parametaMap.get("categoryid");
		String iseditable = (String)parametaMap.get("iseditable");
		
		searchCondition.put("memberid", sessionUserInfo.getMemberId());
		searchCondition.put("categoryid", categoryid);
		searchCondition.put("iseditable", "Y");
		
		List<Map> categoryList = categoryService.getCategoryList(searchCondition);
		List<Map> categoryMenuList = categoryService.getCategoryMenuList(searchCondition);
		logger.debug("categoryMenuList: " + categoryMenuList);
		//model.addAttribute("adminType", sessionAdminInfo.getAdminTypeCmCode());
		model.addAttribute("categoryList", categoryList);
		model.addAttribute("categoryMenuList", categoryMenuList);
		model.addAttribute("parametaMap", parametaMap);	
		
		return "pos/category/categoryMenuManage";
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/pos/category/getCategoryMenuJsonList.json")	
	public ModelAndView getCategoryMenuJsonList( @RequestParam Map parametaMap, Model model, HttpServletRequest request ,HttpSession httpSession) {
		
		SessionUserInfo sessionUserInfo = (SessionUserInfo)httpSession.getAttribute("SESSION_USER_INFO");
		
		HashMap searchCondition = new HashMap();
		
		String categoryid = (String)parametaMap.get("categoryid");
		
		searchCondition.put("memberid", sessionUserInfo.getMemberId());
		searchCondition.put("categoryid", categoryid);		
		
		List<Map> categoryMenuJsonList = categoryService.getCategoryMenuJsonList(searchCondition);		
		
		ModelAndView mav = new ModelAndView();		
		ReturnJsonVO returnJsonVO = new ReturnJsonVO();
		returnJsonVO.setReturnCode("1");// 0: error, 1: 성공
//		returnJsonVO.setMessage(loginId);
		returnJsonVO.setReturnObj(categoryMenuJsonList);		
		logger.debug("categoryMenuJsonList: " + categoryMenuJsonList);
		mav.addObject(returnJsonVO);
		mav.setViewName("jsonView");
		
		return mav;
		
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping("/pos/category/categoryPointManage")
	public String getCategoryPointList( Model model, @RequestParam Map parametaMap, HttpServletRequest request, HttpSession httpSession) {
		
		SessionUserInfo sessionUserInfo = (SessionUserInfo)httpSession.getAttribute("SESSION_USER_INFO");
		
		HashMap searchCondition = new HashMap();
		String categoryid = (String)parametaMap.get("categoryid");
		String iseditable = (String)parametaMap.get("iseditable");
		
		searchCondition.put("memberid", sessionUserInfo.getMemberId());
		searchCondition.put("categoryid", categoryid);
		searchCondition.put("iseditable", "Y");
		
		List<Map> categoryPointList = categoryService.getCategoryPointList(searchCondition);
		logger.debug("categoryPointList: " + categoryPointList);
		//model.addAttribute("adminType", sessionAdminInfo.getAdminTypeCmCode());
		model.addAttribute("categoryPointList", categoryPointList);
		model.addAttribute("parametaMap", parametaMap);	
		
		return "pos/category/categoryPointManage";
	}
	
	/*@RequestMapping(value = "/pos/category/categoryManage")
	public String list( CategoryVO category
			, Model model
			, HttpServletRequest request) {

		model.addAttribute("category", category);
		logger.debug("category: " + category);		
		logger.debug("name: " + category.getName());
		System.out.println("#######################name:"+category.getName());
		return "pos/category/categoryManage";
	}	*/
	
	/*@RequestMapping(value = "/pos/category/getCategoryList.json")	
	public ModelAndView getCategoryList( CategoryVO category
			, Model model
			, HttpServletRequest request) {
		
		List<CategoryVO> categoryList = categoryService.getList(category);
		System.out.println("####################categoryList:"+categoryList);
		logger.debug("categoryList: " + categoryList);
		
		ModelAndView mav = new ModelAndView();		
		ReturnJsonVO returnJsonVO = new ReturnJsonVO();
		returnJsonVO.setReturnCode("2");// 0: error, 1: returnVal 참조, 2: returnObject참조
//		returnJsonVO.setMessage(loginId);
		returnJsonVO.setReturnObj(categoryList);
		mav.addObject(returnJsonVO);
		mav.setViewName("jsonView");
		
		return mav;
		
	}	*/
	
	/**
	 * @param category
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/pos/category/categoryRegist")
	public String categoryRegist( CategoryVO category
			, Model model
			, HttpServletRequest request) {

		model.addAttribute("category", category);
		model.addAttribute("ContextPath",context.getContextPath());
		return "pos/category/categoryRegist";
	}	
	
	@RequestMapping(value = "/pos/category/saveCategory.json", method = RequestMethod.POST)
	public ModelAndView insertAction(
			@Valid CategoryVO category,
			BindingResult result, // 파라미터 검증 결과
			RedirectAttributes redirectAttrs,
			Model model,
			HttpServletRequest request) {	

		int resultValue = categoryService.insertAction(category);
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
	
	@RequestMapping(value = "/pos/category/modifyCategoryIschecked.json", method = RequestMethod.POST)
	public ModelAndView modifyCategoryIschecked(
			@Valid CategoryVO category,
			BindingResult result, // 파라미터 검증 결과
			RedirectAttributes redirectAttrs,
			Model model,
			HttpServletRequest request) {	

		
		System.out.println("memberid:"+category.getMemberid());
		System.out.println("deviceid:"+category.getDeviceid());
		System.out.println("categoryid:"+category.getCategoryid());

		int resultValue = categoryService.updateCategoryIschecked(category);
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
	
	@RequestMapping(value = "/pos/category/modifyCategoryIsimportant.json", method = RequestMethod.POST)
	public ModelAndView modifyCategoryIsimportant(
			@Valid CategoryVO category,
			BindingResult result, // 파라미터 검증 결과
			RedirectAttributes redirectAttrs,
			Model model,
			HttpServletRequest request) {	

		
		System.out.println("memberid:"+category.getMemberid());
		System.out.println("deviceid:"+category.getDeviceid());
		System.out.println("categoryid:"+category.getCategoryid());

		int resultValue = categoryService.updateCategoryIsimportant(category);
		System.out.println("resultValue:"+resultValue);
		ModelAndView mav = new ModelAndView();		
		if(resultValue > 0){
			ReturnJsonVO returnJsonVO = new ReturnJsonVO();
			returnJsonVO.setReturnCode("1");// 0: error, 1: 성공
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
	 * @param category
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/pos/category/getCategoryDetail")
	public String getCategoryDetail(CategoryVO category, Model model, HttpServletRequest request){
		
		System.out.println("memberid:"+category.getMemberid());
		System.out.println("deviceid:"+category.getDeviceid());
		System.out.println("categoryid:"+category.getCategoryid());

		CategoryVO detailData = categoryService.getDetail(category);
		model.addAttribute("detailData",detailData);
		String url = "pos/category/categoryDetail";
		return url;
	}

//예약	
	/**
	 * @param category
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/pos/category/reservation")
	public String reservation( CategoryVO category
			, Model model
			, HttpServletRequest request) {

		model.addAttribute("category", category);
		model.addAttribute("ContextPath",context.getContextPath());
		return "pos/category/reservation";
	}	
	
	@RequestMapping(value = "/pos/category/getReservationList.json")	
	public ModelAndView getReservationList( CategoryVO category
			, Model model
			, HttpServletRequest request) {
		
		List<CategoryVO> categoryList = categoryService.getReservationList(category);

		ModelAndView mav = new ModelAndView();		
		ReturnJsonVO returnJsonVO = new ReturnJsonVO();
		returnJsonVO.setReturnCode("2");// 0: error, 1: returnVal 참조, 2: returnObject참조
//		returnJsonVO.setMessage(loginId);
		returnJsonVO.setReturnObj(categoryList);
		mav.addObject(returnJsonVO);
		mav.setViewName("jsonView");
		
		return mav; 
	}	
	
//고객요구
	
	/**
	 * @param category
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/pos/category/customerRequest")
	public String customerRequest( CategoryVO category
			, Model model
			, HttpServletRequest request) {

		model.addAttribute("category", category);
		model.addAttribute("ContextPath",context.getContextPath());
		return "pos/category/customerRequest";
	}	
	
	@RequestMapping(value = "/pos/category/getCustomerRequestList.json")	
	public ModelAndView getCustomerRequestList( CategoryVO category
			, Model model
			, HttpServletRequest request) {
		
		List<CategoryVO> categoryList = categoryService.getCustomerRequestList(category);

		ModelAndView mav = new ModelAndView();		
		ReturnJsonVO returnJsonVO = new ReturnJsonVO();
		returnJsonVO.setReturnCode("2");// 0: error, 1: returnVal 참조, 2: returnObject참조
//		returnJsonVO.setMessage(loginId);
		returnJsonVO.setReturnObj(categoryList);
		mav.addObject(returnJsonVO);
		mav.setViewName("jsonView");
		
		return mav; 
	}		
}