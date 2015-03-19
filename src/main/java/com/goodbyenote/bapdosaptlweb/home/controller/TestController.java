package com.goodbyenote.bapdosaptlweb.home.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {
	@RequestMapping("/test.do")
	public ModelAndView home() {
		ModelAndView mav = new ModelAndView("test");
		mav.addObject("message", "hello, world!");

		return mav;
	}
}