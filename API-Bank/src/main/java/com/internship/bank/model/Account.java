package com.internship.bank.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "account")
public class Account {
	@Column(name="name")
	private String name;
	
	@Column(name = "number_card")
	private Long numberCard;
	
	@Column(name="cvc")
	private int cvc;
	
	@Column(name="balance")
	private long balance;
	
	@Column(name="exp_date")
	private String expDate;
	
	@Id
	@Column(name = "number_account")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long numberAccount;
	
	
	
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
	public long getBalance() {
		return balance;
	}
	public void setBalance(long balance) {
		this.balance = balance;
	}
	public String getExpDate() {
		return expDate;
	}
	public void setExpDate(String expDate) {
		this.expDate = expDate;
	}
	public Long getNumberAccount() {
		return numberAccount;
	}
	public void setNumberAccount(Long numberAccount) {
		this.numberAccount = numberAccount;
	}

	
}
