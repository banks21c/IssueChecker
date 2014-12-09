package com.goodbyenote.bapdosaptlweb.common.model;

public class SessionAdminInfo {
	
	String id;
	String name;
	String mobile;
	String email;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobile() {
		return mobile;
	}
	public String getMobile1() {
		String mobile1 = null;
		if(mobile != null){			
			String[] mobileArr = mobile.split("-");
			
			if(mobileArr != null && mobileArr.length == 3){
				mobile1 = mobileArr[0];
			}			
		}
		
		return mobile1;
	}
	public String getMobile2() {
		String mobile2 = null;
		if(mobile != null){			
			String[] mobileArr = mobile.split("-");
			
			if(mobileArr != null && mobileArr.length == 3){
				mobile2 = mobileArr[1];
			}			
		}
		
		return mobile2;
	}
	public String getMobile3() {
		String mobile3 = null;
		if(mobile != null){			
			String[] mobileArr = mobile.split("-");
			
			if(mobileArr != null && mobileArr.length == 3){
				mobile3 = mobileArr[2];
			}			
		}
		
		return mobile3;
	}		
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public String getEmailStr1() {
		String emailStr1 = null;
		
		if(email != null){
			String[] emailArr = email.split("@");
			
			if(emailArr != null && emailArr.length == 2){
				emailStr1 = emailArr[0];
			}
		}
		
		return emailStr1;
	}
	public String getEmailStr2() {
		String emailStr2 = null;
		
		if(email != null){
			String[] emailArr = email.split("@");
			
			if(emailArr != null && emailArr.length == 2){
				emailStr2 = emailArr[1];
			}
		}
		
		return emailStr2;
	}		
	public void setEmail(String email) {
		this.email = email;
	}

}
