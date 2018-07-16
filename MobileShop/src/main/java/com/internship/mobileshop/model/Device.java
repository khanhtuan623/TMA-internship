package com.internship.mobileshop.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.search.annotations.Analyze;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.Store;

@Entity(name = "device")
@Indexed
public class Device implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "brand")
	@Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
	private String brand;

	@Column(name = "name")
	@Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
	private String name;

	@Column(name = "color")
	@Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
	private String color;

	@Column(name = "memory")
	@Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
	private String memory;

	@Column(name = "infor")
	@Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
	private String infor;

	@Column(name = "quantity")
	@Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
	private int quantity;

	@Column(name = "status")
	@Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
	private String status;

	@Column(name = "price")
	@Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
	private int price;

	@Column(name = "image")
	@Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
	private String image;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getMemory() {
		return memory;
	}

	public void setMemory(String memory) {
		this.memory = memory;
	}

	public String getInfor() {
		return infor;
	}

	public void setInfor(String infor) {
		this.infor = infor;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Device [id=" + id + ", brand=" + brand + ", name=" + name + ", color=" + color + ", memory=" + memory
				+ ", infor=" + infor + ", quantity=" + quantity + ", status=" + status + ", price=" + price + ", image="
				+ image + "]";
	}

}
