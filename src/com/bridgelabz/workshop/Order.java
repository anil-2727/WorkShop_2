package com.bridgelabz.workshop;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Order {
	enum PaymentMethod {
		Debit_Card, CREDIT_CARD, COD, UPI, NET_BANKING, WALLET
	}

	String deliveryAddress;
	String customerName;

	PaymentMethod paymentMethod;

	ArrayList<FoodItem> foodList = new ArrayList<>();

	Integer quantity;

	Map<FoodItem, Integer> map = new HashMap();

	int totalPrice;
	LocalTime orderTime;
}
