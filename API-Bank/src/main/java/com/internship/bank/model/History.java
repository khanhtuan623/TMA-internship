package com.internship.bank.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "history")
public class History {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "number_card")
	private Long numberCard;
	
	@Column(name = "cvc")
	private int cvc;

	@Column(name="balance")
	private long balance;
	
	@Column(name = "number_account")
	private Long numberAccount;

	@Column(name="status")
	private String status;
	
	@Column(name="exchange")
	private String exchange;
	
	@Column(name="exp_date")
	private String expDate;
	
	@Column(name = "price")
	private long price;
	
	@Column(name="refund_price_available")
	private long refundPriceAvai;

	@Column(name = "date_payment")
	private String datePayment;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getNumberAccount() {
		return numberAccount;
	}

	public void setNumberAccount(Long numberAccount) {
		this.numberAccount = numberAccount;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public String getDatePayment() {
		return datePayment;
	}

	public void setDatePayment(String datePayment) {
		this.datePayment = datePayment;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getExchange() {
		return exchange;
	}

	public void setExchange(String exchange) {
		this.exchange = exchange;
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

	public long getRefundPriceAvai() {
		return refundPriceAvai;
	}

	public void setRefundPriceAvai(long refundPriceAvai) {
		this.refundPriceAvai = refundPriceAvai;
	}
	
	
	

}
