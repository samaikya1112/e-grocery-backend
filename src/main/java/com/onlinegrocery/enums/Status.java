package com.onlinegrocery.enums;

public enum Status {
	
    PLACED("PLACED"),

    SHIPPED("SHIPPED"),

    ONTHEWAY("ONTHEWAY"),

    PICKDUP("PICKDUP"),
	
	DELIVERED("DELIVERED");

	
	private String status;

	Status(String status){

	this.status = status;

	}

	public String getStatus() {

	return status;

	}
		
    
}

