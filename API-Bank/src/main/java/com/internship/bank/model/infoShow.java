package com.internship.bank.model;

public class infoShow {

	private Long id;
	
	private String name;
	
	private Long numberCard;
	
	private Long numberAccount;
	
	private String status;
	
	private String exchange;
	
	private long price;
	
	private long refundPriceAvailable;
	
	private String datePayment;

	
	
	public infoShow() {
		super();
	}

	
	
	public infoShow(Long id, String status, long price, long refundPriceAvailable, String datePayment) {
		super();
		this.id = id;
		this.status = status;
		this.price = price;
		this.refundPriceAvailable = refundPriceAvailable;
		this.datePayment = datePayment;
	}



	public infoShow(Long id, String name, Long numberCard, Long numberAccount, String status, String exchange,
			long price, String datePayment) {
		super();
		this.id = id;
		this.name = name;
		this.numberCard = numberCard;
		this.numberAccount = numberAccount;
		this.status = status;
		this.exchange = exchange;
		this.price = price;
		this.datePayment = datePayment;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public Long getNumberAccount() {
		return numberAccount;
	}

	public void setNumberAccount(Long numberAccount) {
		this.numberAccount = numberAccount;
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

	public long getRefundPriceAvailable() {
		return refundPriceAvailable;
	}

	public void setRefundPriceAvailable(long refundPriceAvailable) {
		this.refundPriceAvailable = refundPriceAvailable;
	}

	
	
}
