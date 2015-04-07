/**
 * 
 */
package com.goodbyenote.bapdosaptlweb.member.service;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.web.WebAppConfiguration;

import com.goodbyenote.bapdosaptlweb.testcase.AbstractTestCase;

/**
 * @author Administrator
 *
 */

public class MemberServiceTest extends AbstractTestCase {
	
	@Autowired
	MemberService memberService;

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
	}

	/**
	 * Test method for {@link com.goodbyenote.bapdosaptlweb.member.service.MemberService#getMemberByBusinessNumber(java.lang.String)}.
	 */
	@Test
	public void testGetMemberByBusinessNumber() {
		String businessNumber = "1304155250";		
		Map userMapTemp = memberService.getMemberByBusinessNumber(businessNumber);
		System.out.println(userMapTemp);
		Assert.assertNotNull(userMapTemp);
	}

}
