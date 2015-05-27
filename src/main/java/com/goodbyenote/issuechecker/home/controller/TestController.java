package com.goodbyenote.issuechecker.home.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {
	@RequestMapping("/home/test.do")
	public ModelAndView home() {
		ModelAndView mav = new ModelAndView("home/test");
		mav.addObject("message", "hello, world!");

		return mav;
	}
}