package isi.tn.exception;

import java.util.Date;

public class ErrorDetails {
	private Date timestamp;
	private String message;
	private String details;
	public ErrorDetails() {
		super();
		// TODO Auto-generated constructor stub
	
		this.timestamp = timestamp;
		this.message = message;
		this.details = details;
		
	}
	
	public Date getTimestamp() {
		return timestamp;
	}

	public String getMessage() {
		return message;
	}

	public String getDetails() {
		return details;
	}
	
}
