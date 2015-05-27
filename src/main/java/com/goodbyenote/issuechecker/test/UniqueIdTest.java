package com.goodbyenote.issuechecker.test;

import com.goodbyenote.issuechecker.common.util.SecurityUtils;

public class UniqueIdTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String nanoUniqueId =  System.nanoTime() + "_" + SecurityUtils.make32UniqueId();
		String uniqueId =  SecurityUtils.make32UniqueId();
		String timeUniqueId =  System.currentTimeMillis() + "_" + SecurityUtils.make32UniqueId();
		
		System.out.println(uniqueId + ": " + uniqueId.length());
		System.out.println(nanoUniqueId + ": " + nanoUniqueId.length());
		
		System.out.println(timeUniqueId + ": " + timeUniqueId);
		System.out.println(timeUniqueId + ": " + timeUniqueId.length());
		
		for(int i=0; i< 1; i++)
		System.out.println(SecurityUtils.getTimeFormatUnique());
	}

}
