package com.internship.bank.model;

public class InfoPayment {
	private String name;
	private Long numberCard;
	private int cvc;
	private String expDate;
	private long price;

	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getNumberCard() {
		return numberCard;
	}

	public void setNumberCard(Long numberCard) {
		this.numberCard = numberCard;
	}

	public int getCvc() {
		return cvc;
	}

	public void setCvc(int cvc) {
		this.cvc = cvc;
	}

	public String getExpDate() {
		return expDate;
	}

	public void setExpDate(String expDate) {
		this.expDate = expDate;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

}
