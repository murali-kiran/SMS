package com.sumadga.sms.reponses;

public class GenericJsonResponse {
	
	private Boolean status;
	private String message;		

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

}
