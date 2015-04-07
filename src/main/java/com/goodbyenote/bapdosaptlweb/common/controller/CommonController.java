package com.goodbyenote.bapdosaptlweb.common.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.goodbyenote.bapdosaptlweb.common.model.CommonCodeVO;
import com.goodbyenote.bapdosaptlweb.common.model.ReturnJsonVO;
import com.goodbyenote.bapdosaptlweb.common.service.CommonService;

@Controller
public class CommonController {
	private static final Logger logger = LoggerFactory.getLogger(CommonController.class);
	
	/**
	 * NFS root
	 */
	@Value("#{config['file.serverpath.nfs.root']}")
	private String nfsRootPath;
	
	/**
	 * Temp File Upload Path
	 */
	@Value("#{config['file.path.image']}")
	private String imagePath;
		
	/**
	 * Temp File Upload Path
	 */
	@Value("#{config['file.path.temp']}")
	private String imageTempPath;
	
	@Autowired
	CommonService commonService;

	@RequestMapping("/common/getCommonCode.json")
	public ModelAndView getCommonCode() {
		
		List<CommonCodeVO> commonCodeList = commonService.getCommonCodeList();
		
		ModelAndView mav = new ModelAndView();		
		ReturnJsonVO returnJsonVO = new ReturnJsonVO();
		returnJsonVO.setReturnCode("1");// 0: error, 1: 성공
		returnJsonVO.setReturnObj(commonCodeList);
		mav.addObject(returnJsonVO);
		mav.setViewName("jsonView");
		
		return mav; 
	}	
	
	@RequestMapping("/common/getCommonCodeParents.json")
	public ModelAndView getCommonCodeParents() {
		
		List<CommonCodeVO> commonCodeList = commonService.getCommonCodeParents();
		
		ModelAndView mav = new ModelAndView();		
		ReturnJsonVO returnJsonVO = new ReturnJsonVO();
		returnJsonVO.setReturnCode("1");// 0: error, 1: 성공
		returnJsonVO.setReturnObj(commonCodeList);
		mav.addObject(returnJsonVO);
		mav.setViewName("jsonView");
		
		return mav; 
	}	
	
	
	
}
