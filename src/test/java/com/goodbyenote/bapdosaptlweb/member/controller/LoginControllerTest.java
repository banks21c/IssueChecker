/**
 * 
 */
package com.goodbyenote.bapdosaptlweb.member.controller;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import com.goodbyenote.bapdosaptlweb.testcase.AbstractTestCase;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

/**
 * @author Administrator
 *
 */
public class LoginControllerTest extends AbstractTestCase {
	
	private MockMvc mockMvc;
	
	@Autowired
	LoginController loginController;
	
    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    protected WebApplicationContext wac;	

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		this.mockMvc = webAppContextSetup(this.wac).build();
	}


	@Test
	public void testLoginOk() {
		//fail("Not yet implemented");
		
		System.out.println("testLoginOk..");
		
		String businessNumber = "1304155250";
		MockHttpSession httpSession = new MockHttpSession();
		Map parametaMap = new HashMap();
		parametaMap.put("BUSINESSNUMBER", businessNumber);
		
		MockHttpServletResponse  response = new MockHttpServletResponse();
		ModelAndView mav = loginController.loginOk(new ExtendedModelMap(), parametaMap, httpSession);
				
		Assert.assertNotNull(mav);	
	}
	
	@Test
	public void testLoginOk1() throws Exception {
		//fail("Not yet implemented");
		
		String returnStr = mockMvc.perform(get("/login/loginOk.json?BUSINESSNUMBER=1304155250")).andReturn().getResponse().getContentAsString();
		System.out.println(returnStr);
		Assert.assertNotNull(returnStr);
	}	

}
