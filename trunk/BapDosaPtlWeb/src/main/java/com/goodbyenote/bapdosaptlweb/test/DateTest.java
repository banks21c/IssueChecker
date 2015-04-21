package com.goodbyenote.bapdosaptlweb.test;

import java.util.Date;

import com.goodbyenote.bapdosaptlweb.common.util.DateUtil;

public class DateTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(DateUtil.getFormatStrFromDate(DateUtil.getDateAdd(new Date(), "h", -6), "YYYYMMdd"));
		
		System.out.println(DateUtil.getFormatStrFromDate(new Date(), "YYYYMMdd"));
	}

}
