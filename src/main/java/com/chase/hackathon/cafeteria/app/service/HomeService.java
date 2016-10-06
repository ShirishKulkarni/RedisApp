package com.chase.hackathon.cafeteria.app.service;

public interface HomeService {

	public String myOrder();

	public String userOrder();

	public String ackOrder(final String confToken, final String time);

	public void pollFromMerchant();
}
