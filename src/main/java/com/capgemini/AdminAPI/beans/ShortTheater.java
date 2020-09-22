package com.capgemini.AdminAPI.beans;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;

@DynamoDBDocument
public class ShortTheater {
	
	private String id;
	private String name;
	
	public ShortTheater() {
		// Default Constructor
	}
	
	public ShortTheater(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public ShortTheater(String name) {
		super();
		this.name = name;
	}

	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
