package com.goodbyenote.bapdosaptlweb.common.model;

import java.util.Date;

public class ExceptionVO {
	
	private String url;
	private String stackTrace;
	private String cause;
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getStackTrace() {
		return stackTrace;
	}
	public void setStackTrace(String stackTrace) {
		this.stackTrace = stackTrace;
	}
	public String getCause() {
		return cause;
	}
	public void setCause(String cause) {
		this.cause = cause;
	}
	@Override
	public String toString() {
		return "ExceptionVO [url=" + url + ", stackTrace=" + stackTrace
				+ ", cause=" + cause + "]";
	}
	
	
}
