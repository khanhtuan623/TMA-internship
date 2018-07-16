package com.internship.mobileshop.model;

public class InforPayment {
	private String name;
	private String phone;
	private String email;
	private String address;
	private String nameCard;
	private Long numberCard;
	private int securityCard;
	private Long idDevice;
	private String brandDevice;
	private String nameDevice;
	private String colorDevice;
	private String memoryDevice;
	private int qty;
	private int price;
	private String expDate;
	private String datePayment;
	
	
	public InforPayment() {
		super();
	}
	
	
	public InforPayment(String name, String phone, String email, String address, String brandDevice, String nameDevice,
			String colorDevice, String memoryDevice, int price, String datePayment) {
		super();
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.address = address;
		this.brandDevice = brandDevice;
		this.nameDevice = nameDevice;
		this.colorDevice = colorDevice;
		this.memoryDevice = memoryDevice;
		this.price = price;
		this.datePayment = datePayment;
	}


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getNameCard() {
		return nameCard;
	}
	public void setNameCard(String nameCard) {
		this.nameCard = nameCard;
	}
	public Long getNumberCard() {
		return numberCard;
	}
	public void setNumberCard(Long numberCard) {
		this.numberCard = numberCard;
	}
	public int getSecurityCard() {
		return securityCard;
	}
	public void setSecurityCard(int securityCard) {
		this.securityCard = securityCard;
	}
	public Long getIdDevice() {
		return idDevice;
	}
	public void setIdDevice(Long idDevice) {
		this.idDevice = idDevice;
	}
	public String getBrandDevice() {
		return brandDevice;
	}
	public void setBrandDevice(String brandDevice) {
		this.brandDevice = brandDevice;
	}
	public String getNameDevice() {
		return nameDevice;
	}
	public void setNameDevice(String nameDevice) {
		this.nameDevice = nameDevice;
	}
	public String getColorDevice() {
		return colorDevice;
	}
	public void setColorDevice(String colorDevice) {
		this.colorDevice = colorDevice;
	}
	public String getMemoryDevice() {
		return memoryDevice;
	}
	public void setMemoryDevice(String memoryDevice) {
		this.memoryDevice = memoryDevice;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getExpDate() {
		return expDate;
	}
	public void setExpDate(String expDate) {
		this.expDate = expDate;
	}


	public String getDatePayment() {
		return datePayment;
	}


	public void setDatePayment(String datePayment) {
		this.datePayment = datePayment;
	}
	
	
}
