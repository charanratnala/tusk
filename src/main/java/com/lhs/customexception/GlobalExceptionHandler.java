package com.lhs.customexception;

import org.springframework.stereotype.Component;

@Component
public class GlobalExceptionHandler extends RuntimeException {

	private String errorcode;
	private String errormess;

	public String getErrorcode() {
		return errorcode;
	}

	public void setErrorcode(String errorcode) {
		this.errorcode = errorcode;
	}

	public String getErrormess() {
		return errormess;
	}

	public void setErrormess(String errormess) {
		this.errormess = errormess;
	}

	public GlobalExceptionHandler() {
		super();
	}

	public GlobalExceptionHandler(String errorcode, String errormess) {
		super();
		this.errorcode = errorcode;
		this.errormess = errormess;
	}

}
