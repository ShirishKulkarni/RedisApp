package com.pl.hackathon.redis.app.model;

import java.io.Serializable;

public class Item implements Serializable {

	private String name;

	private String unitPrice;

	private String quantity;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Item(String name, String unitPrice, String quantity) {
		super();
		this.name = name;
		this.unitPrice = unitPrice;
		this.quantity = quantity;
	}

	public Item() {
	}

	public String getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(String unitPrice) {
		this.unitPrice = unitPrice;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

}
