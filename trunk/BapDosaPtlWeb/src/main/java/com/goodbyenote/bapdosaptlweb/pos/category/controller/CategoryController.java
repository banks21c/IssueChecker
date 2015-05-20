package com.goodbyenote.bapdosaptlweb.pos.category.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
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
import com.goodbyenote.bapdosaptlweb.common.util.SecurityUtils;
import com.goodbyenote.bapdosaptlweb.pos.category.service.CategoryService;
import com.goodbyenote.bapdosaptlweb.pos.model.CategoryVO;
import com.goodbyenote.bapdosaptlweb.pos.setting.service.SettingService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class CategoryController {
	
	private static final Logger logger = LoggerFactory.getLogger(CategoryController.class);
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private SettingService settingService;

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
		
		//HashMap searchCondition = new HashMap()	
		
		
		String iseditable = "Y";
		
		parametaMap.put("memberid", sessionUserInfo.getMemberId());		
		parametaMap.put("iseditable", iseditable);		
		
		List<Map> categoryList = categoryService.getCategoryJsonList(parametaMap);
		logger.debug("categoryList: " + categoryList);
		//model.addAttribute("adminType", sessionAdminInfo.getAdminTypeCmCode());
		model.addAttribute("categoryList", categoryList);		
		model.addAttribute("parametaMap", parametaMap);	
		
		return "pos/category/categoryManage";
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes", "unused" })
	@RequestMapping(value = "/pos/category/getCategoryJsonList.json")	
	public ModelAndView getCategoryJsonList( @RequestParam Map parametaMap, Model model, HttpServletRequest request ,HttpSession httpSession) {
		
		SessionUserInfo sessionUserInfo = (SessionUserInfo)httpSession.getAttribute("SESSION_USER_INFO");
		
		HashMap searchCondition = new HashMap();		
		
		searchCondition.put("memberid", sessionUserInfo.getMemberId());		
		List<Map> categoryJsonList = categoryService.getCategoryJsonList(searchCondition);		
		String timezonedivision = "1";	// 0:점심시간때, 1: 할인시간때
		searchCondition.put("timezonedivision", timezonedivision);
		Map dcTimezoneSet = settingService.getTimezoneSet(searchCondition);
		timezonedivision = "0";
		searchCondition.put("timezonedivision", timezonedivision);
		Map lunchTimezoneSet = settingService.getTimezoneSet(searchCondition);
		
		for(int i=0; i<categoryJsonList.size();i++){
			
			Map  categoryMap = categoryJsonList.get(i);			
			String categoryid = (String)categoryMap.get("CATEGORYID");			
			String isdeleted = "N";
			
			searchCondition.put("categoryid", categoryid);
			searchCondition.put("isdeleted", isdeleted);
			
			List<Map> categoryMenuList = categoryService.getCategoryMenuJsonList(searchCondition);
			for(Map categoryMenu : categoryMenuList){
				logger.debug("#################################################categoryMenu: " + categoryMenu);
				
			}
						
			categoryMap.put("categoryMenuList", categoryMenuList);
		}
		
		Map returnMap = new HashMap();
		returnMap.put("categoryJsonList", categoryJsonList);
		returnMap.put("isPriceDiffer", "N");
		returnMap.put("isDPdiffer", "N");
		returnMap.put("dcTimezoneSet", dcTimezoneSet);
		returnMap.put("lunchTimezoneSet", lunchTimezoneSet);
		
		ModelAndView mav = new ModelAndView();		
		ReturnJsonVO returnJsonVO = new ReturnJsonVO();
		returnJsonVO.setReturnCode("1");// 0: error, 1: 성공
//		returnJsonVO.setMessage(loginId);
		returnJsonVO.setReturnObj(returnMap);		
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
		
		//HashMap searchCondition = new HashMap();
		String categoryid = (String)parametaMap.get("categoryid");
		String iseditable = "Y";
		String isdeleted = "N";
		
		parametaMap.put("memberid", sessionUserInfo.getMemberId());
		parametaMap.put("categoryid", categoryid);
		parametaMap.put("iseditable", iseditable);
		parametaMap.put("isdeleted", isdeleted);
		
		List<Map> categoryList = categoryService.getCategoryJsonList(parametaMap);
		List<Map> categoryMenuList = categoryService.getCategoryMenuList(parametaMap);
		logger.debug("categoryMenuList: " + categoryMenuList);
		//model.addAttribute("adminType", sessionAdminInfo.getAdminTypeCmCode());
		model.addAttribute("categoryList", categoryList);
		model.addAttribute("categoryMenuList", categoryMenuList);
		model.addAttribute("parametaMap", parametaMap);
		logger.debug("###########parametaMap: " + parametaMap);
		
		return "pos/category/categoryMenuManage";
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes", "unused" })
	@RequestMapping(value = "/pos/category/getCategoryMenuJsonList.json")	
	public ModelAndView getCategoryMenuJsonList( @RequestParam Map parametaMap, Model model, HttpServletRequest request ,HttpSession httpSession) {
		
		SessionUserInfo sessionUserInfo = (SessionUserInfo)httpSession.getAttribute("SESSION_USER_INFO");
		
		//HashMap searchCondition = new HashMap();
		
		String categoryid = (String)parametaMap.get("categoryid");
		String isdeleted = (String)parametaMap.get("isdeleted");
		
		parametaMap.put("memberid", sessionUserInfo.getMemberId());
		parametaMap.put("categoryid", categoryid);
		parametaMap.put("isdeleted", isdeleted);
		
		List<Map> categoryMenuJsonList = categoryService.getCategoryMenuJsonList(parametaMap);		
		
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
		
		//HashMap searchCondition = new HashMap();
		String categoryid = (String)parametaMap.get("categoryid");
		String iseditable = "Y";
		String isdeleted = "N";
		
		parametaMap.put("memberid", sessionUserInfo.getMemberId());
		parametaMap.put("categoryid", categoryid);
		parametaMap.put("iseditable", iseditable);
		parametaMap.put("isdeleted", isdeleted);
		
		List<Map> categoryList = categoryService.getCategoryJsonList(parametaMap);
		List<Map> categoryMenuList = categoryService.getCategoryMenuList(parametaMap);
		logger.debug("categoryMenuList: " + categoryMenuList);
		//model.addAttribute("adminType", sessionAdminInfo.getAdminTypeCmCode());
		model.addAttribute("categoryList", categoryList);
		model.addAttribute("categoryMenuList", categoryMenuList);
		model.addAttribute("parametaMap", parametaMap);
		logger.debug("###########parametaMap: " + parametaMap);
		
		return "pos/category/categoryPointManage";
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/pos/category/getDcTimezoneSet.json")
	public ModelAndView getDcTimezoneSet(@RequestParam Map parametaMap, Model model, HttpServletRequest request , HttpSession httpSession) {

		SessionUserInfo sessionUserInfo = (SessionUserInfo)httpSession.getAttribute("SESSION_USER_INFO");
		
        String timezonedivision = (String)parametaMap.get("timezonedivision");
		
		parametaMap.put("memberid", sessionUserInfo.getMemberId());
		parametaMap.put("timezonedivision", timezonedivision);
		Map dcTimezoneSet = settingService.getTimezoneSet(parametaMap);		
		
		Map returnMap = new HashMap();
		returnMap.put("dcTimezoneSet", dcTimezoneSet);
		
		ModelAndView mav = new ModelAndView();		

		ReturnJsonVO returnJsonVO = new ReturnJsonVO();
		returnJsonVO.setReturnCode("1");// 0: error, 1: 성공
		returnJsonVO.setMessage("OK");
		returnJsonVO.setReturnObj(returnMap);
		logger.debug("returnMap: " + returnMap);
		mav.addObject(returnJsonVO);
		mav.setViewName("jsonView");
		
		return mav; 
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping("/pos/category/MenuInsertOk.json")
	public ModelAndView categoryMenuInsertOk(Model model, @RequestParam Map parametaMap , HttpSession httpSession){
		
		SessionUserInfo sessionUserInfo = (SessionUserInfo)httpSession.getAttribute("SESSION_USER_INFO");
		
		logger.debug(parametaMap.toString());
		
		parametaMap.put("memberid", sessionUserInfo.getMemberId());
		parametaMap.put("deviceid", sessionUserInfo.getDeviceId());	
		parametaMap.put("menuid", SecurityUtils.getTimeFormatUnique());		
		
		categoryService.insertCateMenu(parametaMap);
		logger.debug("#################parametaMap=" + parametaMap);
		
		ModelAndView mav = new ModelAndView();		
		ReturnJsonVO returnJsonVO = new ReturnJsonVO();
		logger.debug("#################returnJsonVO=" + returnJsonVO.toString());	
		mav.addObject(returnJsonVO);
		mav.setViewName("jsonView");		
		
		return mav; 
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping("/pos/category/MenuUpdatetOk.json")
	public ModelAndView categoryMenuUpdateOk(Model model, @RequestParam Map parametaMap , HttpSession httpSession){
		
		SessionUserInfo sessionUserInfo = (SessionUserInfo)httpSession.getAttribute("SESSION_USER_INFO");
		String menuid = (String)parametaMap.get("menuid");
		
		logger.debug(parametaMap.toString());
		
		parametaMap.put("memberId", sessionUserInfo.getMemberId());
		parametaMap.put("deviceid", sessionUserInfo.getDeviceId());	
		//parametaMap.put("menuid", menuid);		
		
		categoryService.updateCateMenu(parametaMap);		
		
		ModelAndView mav = new ModelAndView();		
		ReturnJsonVO returnJsonVO = new ReturnJsonVO();
		logger.debug("#################returnJsonVO=" + returnJsonVO.toString());	
		mav.addObject(returnJsonVO);
		mav.setViewName("jsonView");		
		
		return mav; 
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping("/pos/category/PointUpdatetOk.json")
	public ModelAndView categoryPointUpdateOk(Model model, @RequestParam Map parametaMap , HttpSession httpSession){
		
		SessionUserInfo sessionUserInfo = (SessionUserInfo)httpSession.getAttribute("SESSION_USER_INFO");
		String menuid = (String)parametaMap.get("menuid");
		
		logger.debug(parametaMap.toString());
		
		parametaMap.put("memberId", sessionUserInfo.getMemberId());
		parametaMap.put("deviceid", sessionUserInfo.getDeviceId());	
		parametaMap.put("menuid", menuid);		
		
		categoryService.updateCatePoint(parametaMap);		
		
		ModelAndView mav = new ModelAndView();		
		ReturnJsonVO returnJsonVO = new ReturnJsonVO();
		logger.debug("#################returnJsonVO=" + returnJsonVO.toString());	
		mav.addObject(returnJsonVO);
		mav.setViewName("jsonView");		
		
		return mav; 
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping("/pos/category/updateDcTimezoneSet.json")
	public ModelAndView updateDcTimezoneSet(Model model, @RequestParam Map parametaMap , HttpSession httpSession){
		
		SessionUserInfo sessionUserInfo = (SessionUserInfo)httpSession.getAttribute("SESSION_USER_INFO");
		
		logger.debug(parametaMap.toString());
		String timezonedivision = (String)parametaMap.get("timezonedivision");
		String isdifferenttime = (String)parametaMap.get("isdifferenttime");
		String starttime1 = (String)parametaMap.get("starttime1");
		String starttime2 = (String)parametaMap.get("starttime2");
		String starttime3 = (String)parametaMap.get("starttime3");
		String starttime4 = (String)parametaMap.get("starttime4");
		String starttime5 = (String)parametaMap.get("starttime5");
		String starttime6 = (String)parametaMap.get("starttime6");
		String starttime7 = (String)parametaMap.get("starttime7");
		
		String endtime1 = (String)parametaMap.get("endtime1");
		String endtime2 = (String)parametaMap.get("endtime2");
		String endtime3 = (String)parametaMap.get("endtime3");
		String endtime4 = (String)parametaMap.get("endtime4");
		String endtime5 = (String)parametaMap.get("endtime5");
		String endtime6 = (String)parametaMap.get("endtime6");
		String endtime7 = (String)parametaMap.get("endtime7");
		
		String isusedtime1 = (String)parametaMap.get("isusedtime1");
		String isusedtime2 = (String)parametaMap.get("isusedtime2");
		String isusedtime3 = (String)parametaMap.get("isusedtime3");
		String isusedtime4 = (String)parametaMap.get("isusedtime4");
		String isusedtime5 = (String)parametaMap.get("isusedtime5");
		String isusedtime6 = (String)parametaMap.get("isusedtime6");
		String isusedtime7 = (String)parametaMap.get("isusedtime7");
		
		parametaMap.put("memberid", sessionUserInfo.getMemberId());
		parametaMap.put("timezonedivision", timezonedivision);
		parametaMap.put("isdifferenttime", isdifferenttime);
		parametaMap.put("starttime1", starttime1);
		parametaMap.put("starttime2", starttime2);
		parametaMap.put("starttime3", starttime3);
		parametaMap.put("starttime4", starttime4);
		parametaMap.put("starttime5", starttime5);
		parametaMap.put("starttime6", starttime6);
		parametaMap.put("starttime7", starttime7);
		
		parametaMap.put("endtime1", endtime1);
		parametaMap.put("endtime2", endtime2);
		parametaMap.put("endtime3", endtime3);
		parametaMap.put("endtime4", endtime4);
		parametaMap.put("endtime5", endtime5);
		parametaMap.put("endtime6", endtime6);
		parametaMap.put("endtime7", endtime7);
		
		parametaMap.put("isusedtime1", isusedtime1);
		parametaMap.put("isusedtime2", isusedtime2);
		parametaMap.put("isusedtime3", isusedtime3);
		parametaMap.put("isusedtime4", isusedtime4);
		parametaMap.put("isusedtime5", isusedtime5);
		parametaMap.put("isusedtime6", isusedtime6);
		parametaMap.put("isusedtime7", isusedtime7);
				
		settingService.updateTimezoneSet(parametaMap);
		
		
		ModelAndView mav = new ModelAndView();		
		ReturnJsonVO returnJsonVO = new ReturnJsonVO();
		logger.debug("#################returnJsonVO=" + returnJsonVO.toString());	
		mav.addObject(returnJsonVO);
		mav.setViewName("jsonView");		
		
		return mav; 
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/pos/category/getMenuDiffer.json")
	public ModelAndView getMenuDiffer(@RequestParam Map parametaMap, Model model, HttpServletRequest request , HttpSession httpSession) {

		SessionUserInfo sessionUserInfo = (SessionUserInfo)httpSession.getAttribute("SESSION_USER_INFO");
		parametaMap.put("memberid", sessionUserInfo.getMemberId());
		parametaMap.put("deviceid", sessionUserInfo.getDeviceId());
		Map menuDiffer = categoryService.getMenuDiffer(parametaMap);		
		
		Map returnMap = new HashMap();
		returnMap.put("menuDiffer", menuDiffer);
		
		ModelAndView mav = new ModelAndView();		

		ReturnJsonVO returnJsonVO = new ReturnJsonVO();
		returnJsonVO.setReturnCode("1");// 0: error, 1: 성공
		returnJsonVO.setMessage("OK");
		returnJsonVO.setReturnObj(returnMap);
		logger.debug("returnMap: " + returnMap);
		mav.addObject(returnJsonVO);
		mav.setViewName("jsonView");
		
		return mav; 
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping("/pos/category/menuDifferUpdateOk.json")
	public ModelAndView menuDifferUpdateOk(Model model, @RequestParam Map parametaMap , HttpSession httpSession){
		
		SessionUserInfo sessionUserInfo = (SessionUserInfo)httpSession.getAttribute("SESSION_USER_INFO");
		
		logger.debug(parametaMap.toString());
		String settingvalue = (String)parametaMap.get("settingvalue");
		
		parametaMap.put("memberid", sessionUserInfo.getMemberId());
		parametaMap.put("deviceid", sessionUserInfo.getDeviceId());
		parametaMap.put("settingvalue", settingvalue);
				
		categoryService.updateMenuDiffer(parametaMap);
		
		
		ModelAndView mav = new ModelAndView();		
		ReturnJsonVO returnJsonVO = new ReturnJsonVO();
		logger.debug("#################returnJsonVO=" + returnJsonVO.toString());	
		mav.addObject(returnJsonVO);
		mav.setViewName("jsonView");		
		
		return mav; 
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/pos/category/getDcDiffer.json")
	public ModelAndView getDcDiffer(@RequestParam Map parametaMap, Model model, HttpServletRequest request , HttpSession httpSession) {

		SessionUserInfo sessionUserInfo = (SessionUserInfo)httpSession.getAttribute("SESSION_USER_INFO");
		parametaMap.put("memberid", sessionUserInfo.getMemberId());
		parametaMap.put("deviceid", sessionUserInfo.getDeviceId());
		Map dcDiffer = categoryService.getDcDiffer(parametaMap);		
		
		Map returnMap = new HashMap();
		returnMap.put("dcDiffer", dcDiffer);
		
		ModelAndView mav = new ModelAndView();		

		ReturnJsonVO returnJsonVO = new ReturnJsonVO();
		returnJsonVO.setReturnCode("1");// 0: error, 1: 성공
		returnJsonVO.setMessage("OK");
		returnJsonVO.setReturnObj(returnMap);
		logger.debug("returnMap: " + returnMap);
		mav.addObject(returnJsonVO);
		mav.setViewName("jsonView");
		
		return mav; 
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping("/pos/category/dcDifferUpdateOk.json")
	public ModelAndView dcDifferUpdateOk(Model model, @RequestParam Map parametaMap , HttpSession httpSession){
		
		SessionUserInfo sessionUserInfo = (SessionUserInfo)httpSession.getAttribute("SESSION_USER_INFO");
		
		logger.debug(parametaMap.toString());
		String settingvalue = (String)parametaMap.get("settingvalue");
		
		parametaMap.put("memberid", sessionUserInfo.getMemberId());
		parametaMap.put("deviceid", sessionUserInfo.getDeviceId());
		parametaMap.put("settingvalue", settingvalue);
				
		categoryService.updateDcDiffer(parametaMap);
		
		
		ModelAndView mav = new ModelAndView();		
		ReturnJsonVO returnJsonVO = new ReturnJsonVO();
		logger.debug("#################returnJsonVO=" + returnJsonVO.toString());	
		mav.addObject(returnJsonVO);
		mav.setViewName("jsonView");		
		
		return mav; 
	}
	/*@SuppressWarnings("unchecked")
	@RequestMapping(value = "/pos/category/menuSave.json", method = RequestMethod.POST)
	public ModelAndView insertAction(
			@RequestParam(required=true) Map parametaMap
			,HttpSession httpSession) throws JsonParseException, JsonMappingException, IOException {	
		
		//logger.debug(parametaMap.toString());
		
		String menuObjJson = (String)parametaMap.get("menuObjJson");		
		
		logger.debug(menuObjJson);
		Map<String, Object> menuObjMap = new ObjectMapper().readValue(menuObjJson, HashMap.class) ;
		
		//System.out.println(orderObjMap);
		
		String memberId = (String)menuObjMap.get("memberId");
		String deviceid = (String)menuObjMap.get("deviceid");
		List<Map> menuDataList = (List<Map>)menuObjMap.get("menuDataList");
		
		menuDataList.forEach( 
			menuData -> {
				System.out.println(menuData);
				
				//orderData.put
				
			}
		);
		
		
		
		int resultValue = 1;

		//int resultValue = orderService.insertAction(order);
		System.out.println("resultValue:"+resultValue);
		ModelAndView mav = new ModelAndView();		

		ReturnJsonVO returnJsonVO = new ReturnJsonVO();
		returnJsonVO.setReturnCode("1");// 0: error, 1: 성공
		returnJsonVO.setMessage("OK");
		returnJsonVO.setReturnObj(Integer.toString(resultValue));
		mav.addObject(returnJsonVO);
		mav.setViewName("jsonView");
		
		return mav; 
	}*/
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/pos/category/menuSave.json", method = RequestMethod.POST)
	public ModelAndView menuSave(
			@RequestParam(required=true) Map parametaMap
			,HttpSession httpSession) throws JsonParseException, JsonMappingException, IOException {	
		
		SessionUserInfo sessionUserInfo = (SessionUserInfo)httpSession.getAttribute("SESSION_USER_INFO");
		
		//logger.debug(parametaMap.toString());
		
		String menuObjJson = (String)parametaMap.get("menuObjJson");		
		
		logger.debug(menuObjJson);
		Map<String, Object> menuObjMap = new ObjectMapper().readValue(menuObjJson, HashMap.class) ;
		
		//System.out.println(orderObjMap);		
		int resultValue = categoryService.menuSave(menuObjMap, sessionUserInfo);
		
		System.out.println("resultValue:"+resultValue);
		ModelAndView mav = new ModelAndView();		

		ReturnJsonVO returnJsonVO = new ReturnJsonVO();
		returnJsonVO.setReturnCode("1");// 0: error, 1: 성공
		returnJsonVO.setMessage("OK");
		returnJsonVO.setReturnObj(Integer.toString(resultValue));
		mav.addObject(returnJsonVO);
		mav.setViewName("jsonView");
		
		return mav; 
	}
}