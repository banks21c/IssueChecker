package com.goodbyenote.bapdosaptlweb.pos.menu.controller;

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
import com.goodbyenote.bapdosaptlweb.pos.menu.service.MenuService;
import com.goodbyenote.bapdosaptlweb.pos.model.MenuVO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class MenuController {
	
	private static final Logger logger = LoggerFactory.getLogger(MenuController.class);

	@Autowired
	private MenuService menuService;

	@Autowired
    ServletContext context;
	
	public void setServletContext(ServletContext servletContext) {
	     this.context = servletContext;
	}
	
	/**
	 * @param menu
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/pos/menu/list")
	public String list( MenuVO menu
			, Model model
			, HttpServletRequest request) {

		model.addAttribute("menu", menu);
		model.addAttribute("ContextPath",context.getContextPath());

		return "pos/menu/list";
	}	
	
	/**
	 * 
	 * @param menu
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/pos/menu/getList")
	public String getList( MenuVO menu
			, Model model
			, HttpServletRequest request) {

		if(menu == null) menu = new MenuVO();

		//결과 요청
		System.out.println("menuService:"+menuService);
		List<MenuVO> dataList = menuService.list(menu);
		System.out.println("dataList.size:"+dataList.size());
		
		//결과의 갯수 요청
		int cntList = menuService.count(menu);
		logger.debug("******** cntList ===>"+cntList);
		
		//DTO를 결과 model에 저장
		model.addAttribute("dataList", dataList);
		
//		model.addAttribute("menuAuth",menuAuth);
		return "pos/menu/helloworld";
	}
	
	@RequestMapping(value = "/pos/menu/view")
	public String view(MenuVO menu, Model model, HttpServletRequest request){
		MenuVO vo = menuService.view(menu);	
		model.addAttribute("dataVO", vo);
		return "pos/menu/list";
	}
	
	@RequestMapping(value = "/saveMenu.json", method = RequestMethod.POST)
	public ModelAndView insertAction(
			@Valid MenuVO menu,
			BindingResult result, // 파라미터 검증 결과
			RedirectAttributes redirectAttrs,
			Model model,
			HttpServletRequest request) {	

		int resultValue = menuService.insertAction(menu);
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
	 * @param menu
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/pos/menu/menuManage")
	public String menuManage( MenuVO menu
			, Model model
			, HttpServletRequest request) {

		model.addAttribute("menu", menu);
		model.addAttribute("ContextPath",context.getContextPath());
		
		return "pos/menu/menuManage";
	}	
	
}