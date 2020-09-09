package com.capgemini.AdminAPI.entities;

import java.time.LocalDateTime;

import com.capgemini.AdminAPI.beans.CardDetails;

public class Transaction {
	String transactionId;
	LocalDateTime transactionDate;
	double amount;
	Booking bookingReference;
	CardDetails paymentDetails;
}
