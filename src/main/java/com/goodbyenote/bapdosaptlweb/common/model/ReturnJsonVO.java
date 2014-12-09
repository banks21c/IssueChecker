package com.goodbyenote.bapdosaptlweb.common.model;

public class ReturnJsonVO {

	String returnCode;
	String returnVal;
	String message;
	Object returnObj;
	
	String articleId;
	
	public String getArticleId() {
		return articleId;
	}
	public void setArticleId(String articleId) {
		this.articleId = articleId;
	}
	/**
	 * @return the returnCode
	 */
	public String getReturnCode() {
		return returnCode;
	}
	/**
	 * @param returnCode the returnCode to set
	 */
	public void setReturnCode(String returnCode) {
		this.returnCode = returnCode;
	}
	/**
	 * @return the returnVal
	 */
	public String getReturnVal() {
		return returnVal;
	}
	/**
	 * @param returnVal the returnVal to set
	 */
	public void setReturnVal(String returnVal) {
		this.returnVal = returnVal;
	}
	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	/**
	 * @return the returnObj
	 */
	public Object getReturnObj() {
		return returnObj;
	}
	/**
	 * @param returnObj the returnObj to set
	 */
	public void setReturnObj(Object returnObj) {
		this.returnObj = returnObj;
	}
	
}
