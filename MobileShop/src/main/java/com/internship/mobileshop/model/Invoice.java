package com.internship.mobileshop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "invoice")
public class Invoice {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "id_device")
	private Long idDevice;
	
	@Column(name="id_his_bank")
	private Long idHisBank;
	
	@Column(name = "qty")
	private int quantity;
	
	@Column(name = "total")
	private int total;
	
	@Column(name = "name_customer")
	private String nameCustomer;
	
	@Column(name = "phone_customer")
	private String phoneCustomer;
	
	@Column(name = "address_customer")
	private String addressCustomer;
	
	@Column(name = "date")
	private String date;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdDevice() {
		return idDevice;
	}

	public void setIdDevice(Long idDevice) {
		this.idDevice = idDevice;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public String getNameCustomer() {
		return nameCustomer;
	}

	public void setNameCustomer(String nameCustomer) {
		this.nameCustomer = nameCustomer;
	}

	public String getPhoneCustomer() {
		return phoneCustomer;
	}

	public void setPhoneCustomer(String phoneCustomer) {
		this.phoneCustomer = phoneCustomer;
	}

	public String getAddressCustomer() {
		return addressCustomer;
	}

	public void setAddressCustomer(String addressCustomer) {
		this.addressCustomer = addressCustomer;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Long getIdHisBank() {
		return idHisBank;
	}

	public void setIdHisBank(Long idHisBank) {
		this.idHisBank = idHisBank;
	}

	
}
