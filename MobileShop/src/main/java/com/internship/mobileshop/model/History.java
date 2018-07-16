package com.internship.mobileshop.model;

public class History {	
	private String userName;

	private Long numberAccount;

	private int price;

	private String datePayment;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Long getNumberAccount() {
		return numberAccount;
	}

	public void setNumberAccount(Long numberAccount) {
		this.numberAccount = numberAccount;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getDatePayment() {
		return datePayment;
	}

	public void setDatePayment(String datePayment) {
		this.datePayment = datePayment;
	}
	
	
}
