package com.goodbyenote.bapdosaptlweb.common.model;

public class SessionUserInfo {
	String userId;
	String loginId;
	String nickName;
	int cashBalance;
	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	/**
	 * @return the loginId
	 */
	public String getLoginId() {
		return loginId;
	}
	/**
	 * @param loginId the loginId to set
	 */
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	/**
	 * @return the nickName
	 */
	public String getNickName() {
		return nickName;
	}
	/**
	 * @param nickName the nickName to set
	 */
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	/**
	 * @return the cashBalance
	 */
	public int getCashBalance() {
		return cashBalance;
	}
	/**
	 * @param cashBalance the cashBalance to set
	 */
	public void setCashBalance(int cashBalance) {
		this.cashBalance = cashBalance;
	}
	
	
}
