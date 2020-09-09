package com.capgemini.AdminAPI.beans;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;

@DynamoDBDocument
public class ShortScreen {

	private String id;
	private String name;
	
	public ShortScreen() {
		// TODO Auto-generated constructor stub
	}
	
	public ShortScreen(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public ShortScreen(String name) {
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
