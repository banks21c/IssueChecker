package com.goodbyenote.bapdosaptlweb.common.model;

public class ReturnJsonVO {

	String returnCode = "1";	//0:실패, 1:성공
	String ReturnErrorCode;
	String ReturnErrorException;
	String ReturnErrorStackTrace;
	String message;
	Object returnObj;
	public String getReturnCode() {
		return returnCode;
	}
	public void setReturnCode(String returnCode) {
		this.returnCode = returnCode;
	}
	public String getReturnErrorCode() {
		return ReturnErrorCode;
	}
	public void setReturnErrorCode(String returnErrorCode) {
		ReturnErrorCode = returnErrorCode;
	}
	public String getReturnErrorException() {
		return ReturnErrorException;
	}
	public void setReturnErrorException(String returnErrorException) {
		ReturnErrorException = returnErrorException;
	}
	public String getReturnErrorStackTrace() {
		return ReturnErrorStackTrace;
	}
	public void setReturnErrorStackTrace(String returnErrorStackTrace) {
		ReturnErrorStackTrace = returnErrorStackTrace;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getReturnObj() {
		return returnObj;
	}
	public void setReturnObj(Object returnObj) {
		this.returnObj = returnObj;
	}	
	
	

}
