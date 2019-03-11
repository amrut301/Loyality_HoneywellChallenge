package com.loyality.bo.exception;

/**
 * @author amrmalaj
 *
 */
public class ServiceException extends Throwable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	String message;
	String code;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public ServiceException(String code, String message) {
		this.code = code;
		this.message = message;

	}

	public ServiceException(String message) {
		this.message = message;
	}
	@Override
	public String getMessage() {
		return getMessage();
	}

}
