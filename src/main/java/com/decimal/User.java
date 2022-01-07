package com.decimal;

public class User {
	
	private String TransactionType;
	private String creditValue;
	private String Status;
	private String Date;
	private String Time;
	public String getTransactionType() {
		return TransactionType;
	}
	public void setTransactionType(String transactionType) {
		TransactionType = transactionType;
	}
	public String getCreditValue() {
		return creditValue;
	}
	public void setCreditValue(String creditValue) {
		this.creditValue = creditValue;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public String getDate() {
		return Date;
	}
	public void setDate(String date) {
		Date = date;
	}
	public String getTime() {
		return Time;
	}
	public void setTime(String time) {
		Time = time;
	}
	public User(String transactionType, String creditValue, String status, String date, String time) {
		super();
		TransactionType = transactionType;
		this.creditValue = creditValue;
		Status = status;
		Date = date;
		Time = time;
	}
	
	
		
	
	

}
