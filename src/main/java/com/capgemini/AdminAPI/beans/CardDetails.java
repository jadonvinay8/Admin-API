package com.capgemini.AdminAPI.beans;

public class CardDetails {
	
	private	String cardNumber;
	private	String dateofExpiry;
	private	String nameOnCard;
	
	public CardDetails() {
		// TODO Auto-generated constructor stub
	}

	public CardDetails(String cardNumber, String dateofExpiry, String nameOnCard) {
		super();
		this.cardNumber = cardNumber;
		this.dateofExpiry = dateofExpiry;
		this.nameOnCard = nameOnCard;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getDateofExpiry() {
		return dateofExpiry;
	}

	public void setDateofExpiry(String dateofExpiry) {
		this.dateofExpiry = dateofExpiry;
	}

	public String getNameOnCard() {
		return nameOnCard;
	}

	public void setNameOnCard(String nameOnCard) {
		this.nameOnCard = nameOnCard;
	}
	
	
}
