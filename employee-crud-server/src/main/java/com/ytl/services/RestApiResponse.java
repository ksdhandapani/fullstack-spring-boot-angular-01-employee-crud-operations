package com.ytl.services;

public class RestApiResponse {

	private Object responseData;
	private Boolean isSuccess;
	private Boolean isException;
	private Boolean isAuthenticationException;
	private String message;

	public Object getResponseData() {
		return responseData;
	}

	public void setResponseData(Object responseData) {
		this.responseData = responseData;
	}

	public Boolean getIsSuccess() {
		return isSuccess;
	}

	public void setIsSuccess(Boolean isSuccess) {
		this.isSuccess = isSuccess;
	}

	public Boolean getIsException() {
		return isException;
	}

	public void setIsException(Boolean isException) {
		this.isException = isException;
	}

	public Boolean getIsAuthenticationException() {
		return isAuthenticationException;
	}

	public void setIsAuthenticationException(Boolean isAuthenticationException) {
		this.isAuthenticationException = isAuthenticationException;
	}

	public RestApiResponse(Object responseData, Boolean isSuccess, Boolean isException,
			Boolean isAuthenticationException, String message) {
		super();
		this.responseData = responseData;
		this.isSuccess = isSuccess;
		this.isException = isException;
		this.isAuthenticationException = isAuthenticationException;
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public RestApiResponse() {
		super();
	}

}
