package com.goodbyenote.issuechecker.test;

import java.util.ArrayList;

public class LamdaClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> arrayList= new ArrayList<Integer>(); 
		for(int i=1; i<=100; i++) 
		arrayList.add(i); 
		 
		//일반적인 for-loop 문 
//		for(Integer m: arrayList)
//		{ 
//			System.out.println(m); 
//		} 
		 
		//lambda식으로 표현한 for-loop문 
		arrayList.forEach( i -> {System.out.println(i);});
	}

}
