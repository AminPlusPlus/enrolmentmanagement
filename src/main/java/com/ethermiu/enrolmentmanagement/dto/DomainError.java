package com.ethermiu.enrolmentmanagement.dto;

public class DomainError {
	 
    private String message;
 
    public DomainError() {}
	    public DomainError(String message) {
	    	this.message = message;
 	    }
	    
	    public void setMessage(String message) {
 	        this.message = message;
	    }
	 
	    public String getMessage( ) {
 	        return message;
	    }
  	}
	
 
