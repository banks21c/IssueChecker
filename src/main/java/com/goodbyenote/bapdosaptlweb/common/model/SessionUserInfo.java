package com.goodbyenote.bapdosaptlweb.common.model;

import java.util.Map;

public class SessionUserInfo {
	private String memberId;
	private  String phonenumber;
	private String phonenumber2;
	private String membername;
	private String businessnumber;
	private String membertype;
	private String deviceId;
	private Map e​nvironmentMap;
	
	
	public String getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public String getPhonenumber2() {
		return phonenumber2;
	}
	public void setPhonenumber2(String phonenumber2) {
		this.phonenumber2 = phonenumber2;
	}
	public String getMembername() {
		return membername;
	}
	public void setMembername(String membername) {
		this.membername = membername;
	}
	public String getBusinessnumber() {
		return businessnumber;
	}
	public void setBusinessnumber(String businessnumber) {
		this.businessnumber = businessnumber;
	}
	public String getMembertype() {
		return membertype;
	}
	public void setMembertype(String membertype) {
		this.membertype = membertype;
	}
	public Map getE​nvironmentMap() {
		return e​nvironmentMap;
	}
	public void setE​nvironmentMap(Map e​nvironmentMap) {
		this.e​nvironmentMap = e​nvironmentMap;
	}
	@Override
	public String toString() {
		return "SessionUserInfo [memberId=" + memberId + ", phonenumber="
				+ phonenumber + ", phonenumber2=" + phonenumber2
				+ ", membername=" + membername + ", businessnumber="
				+ businessnumber + ", membertype=" + membertype + ", deviceId="
				+ deviceId + "]";
	}


	
	
}
