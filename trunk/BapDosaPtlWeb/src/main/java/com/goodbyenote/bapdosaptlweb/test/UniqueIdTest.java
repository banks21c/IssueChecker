package com.goodbyenote.bapdosaptlweb.test;

import com.goodbyenote.bapdosaptlweb.common.util.SecurityUtils;

public class UniqueIdTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String nanoUniqueId =  System.nanoTime() + "_" + SecurityUtils.make32UniqueId();
		String uniqueId =  SecurityUtils.make32UniqueId();
		
		System.out.println(uniqueId + ": " + uniqueId.length());
		System.out.println(nanoUniqueId + ": " + nanoUniqueId.length());
	}

}
