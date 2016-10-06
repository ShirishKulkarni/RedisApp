package com.chase.hackathon.cafeteria.app.model;

public class Item {

	private String name;

	private String unitPrice;

	private int quantity;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Item(String name, String unitPrice, int quantity) {
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

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
