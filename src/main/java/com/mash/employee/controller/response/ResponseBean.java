/**
 * 
 */
package com.mash.employee.controller.response;

import java.io.Serializable;

/**
 * @author manoj
 *
 */
public class ResponseBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String status;
	private int statusCode;
	private String message;
	private Object data;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public ResponseBean(String status, int statusCode, String message, Object data) {
		super();
		this.status = status;
		this.statusCode = statusCode;
		this.message = message;
		this.data = data;
	}
	public ResponseBean(String status, int statusCode, String message) {
		super();
		this.status = status;
		this.statusCode = statusCode;
		this.message = message;
	}

	
	
	

}
