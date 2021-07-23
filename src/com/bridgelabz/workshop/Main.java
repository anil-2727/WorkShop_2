package com.bridgelabz.workshop;

import java.time.LocalTime;
import java.util.*;

public class Main {
	FoodManager foodManager = FoodManager.getInstance();

	public static void main(String[] args) {

		Main main = new Main();
		main.sowMenu();
	}

	void sowMenu() {
		int choice = 0;
		while (choice != 10) {
			Scanner sc = new Scanner(System.in);
			System.out.print(
					"1-show food item :: \n2-update foodItem ::\n3-add food Item \n4-remove food item \n5-place order \n10-exit\n:-> ");
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				foodManager.print();
				break;
			case 2:
				updateFoodItem();
				break;
			case 3:
				foodManager.addNewFooItem();
				break;
			case 4:
				foodManager.removeFoodItem();
				break;
			case 5:
				placeTheOrder();
				break;
			case 10:
				break;
			default:
				System.out.println("ERROR");
				break;
			}
		}
	}

	void updateFoodItem() {
		boolean run = true;
		int parameter = 0;
		while (run) {
			Scanner sc = new Scanner(System.in);
			System.out.print("Enter food item : ");
			String item = sc.next();
			FoodItem foodItem = foodManager.getFoodItem(item);
			System.out.println(foodItem);
			while (parameter != 5) {
				System.out.println("Enter 1-Taste 2-Prep Time, 3-name, 4-category 5-main menu");
				parameter = sc.nextInt();
				switch (parameter) {
				case 1:
					updateTaste(foodItem);
					run = true;
					break;
				case 2:
					updatePreparationTime(foodItem);
					run = true;
					break;
				case 3:
					updateName(foodItem);
					run = true;
					break;
				case 4:
					updateCategory(foodItem);
					run = true;
					break;
				case 5:
					run = false;
					break;
				default:
					System.out.println("OHHHHHOOOOOOO invalid choice");
				}
				System.out.println(foodItem);
			}
		}
	}

	private void updateCategory(FoodItem foodItem) {
		Scanner sc = new Scanner(System.in);
		System.out.println("chose from below : ");
		System.out.println("1-MAIN_COURSE 2-STARTER 3-JUICES 4-DESERT");
		int choice = sc.nextInt();
		switch (choice) {
		case 1:
			foodItem.category = FoodItem.Category.MAIN_COURSE;
			break;
		case 2:
			foodItem.category = FoodItem.Category.STARTER;
			break;
		case 3:
			foodItem.category = FoodItem.Category.JUICES;
			break;
		case 4:
			foodItem.category = FoodItem.Category.DESERT;
			break;
		default:
			System.out.println("OHHOOOOOOO invalid choice");
		}
		System.out.println(foodItem);
	}

	private void updateName(FoodItem foodItem) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter new name : ");
		String name = sc.nextLine();
		foodItem.name = name;
		System.out.println(foodItem);
	}

	private void updateTaste(FoodItem foodItem) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Choose from below ");
		System.out.println("1-SPICY 2-SWEET 3-SALTY 4-SPICY_SALTY");
		System.out.print("Enter your choice : ");
		int taste = sc.nextInt();
		switch (taste) {
		case 1:
			foodItem.taste = FoodItem.Taste.SPICY;
			break;
		case 2:
			foodItem.taste = FoodItem.Taste.SWEET;
			break;
		case 3:
			foodItem.taste = FoodItem.Taste.SALTY;
			break;
		case 4:
			foodItem.taste = FoodItem.Taste.SPICY_SALTY;
		default:
			System.out.println("Enter right taste.");
		}
	}

	public void updatePreparationTime(FoodItem foodItem) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter new time : ");
		byte newTime = sc.nextByte();
		foodItem.preparationTime = newTime;

	}

	public void placeTheOrder() {
		Scanner sc = new Scanner(System.in);
		Order order = new Order();
		System.out.print("Please enter the delivery address ::");
		order.deliveryAddress = sc.nextLine();

		System.out.print("Enter your name :: ");
		order.customerName = sc.nextLine();

		System.out.println("1- DEBIT CARD \n2- CREDIT CARD \n3- COD \n4- UPI \n5-NET BANKING \n6-WALLET.");
		System.out.print("Enter payment Method ::");
		int paymentMethod = sc.nextInt();

		switch (paymentMethod) {
		case 1:
			order.paymentMethod = Order.PaymentMethod.Debit_Card;
			break;
		case 2:
			order.paymentMethod = Order.PaymentMethod.CREDIT_CARD;
			break;
		case 3:
			order.paymentMethod = Order.PaymentMethod.COD;
			break;
		case 4:
			order.paymentMethod = Order.PaymentMethod.UPI;
			break;
		case 5:
			order.paymentMethod = Order.PaymentMethod.NET_BANKING;
			break;
		case 6:
			order.paymentMethod = Order.PaymentMethod.WALLET;
		default:
			System.out.println("Please enter valid payment method.");
		}
		System.out.println("we have this much to order:: ");
		foodManager.print();

		String foodName = "";
		while (!foodName.equalsIgnoreCase("quit")) {

			System.out.print("Enter what you want to buy :: ");
			foodName = sc.next();
			if (!foodName.equalsIgnoreCase("quit")) {
				order.foodList.add(foodManager.getFoodItem(foodName));

				System.out.print("Pleas enter the quantity :: ");
				order.quantity = sc.nextInt();

				order.map.put(foodManager.getFoodItem(foodName), order.quantity);
			}
		}

		System.out.println("yor order list is " + order.map);

		order.orderTime = LocalTime.now();
		System.out.println("Order time is :: " + order.orderTime);
		// System.out.println(order.foodList);
		calculateTotalPrice(order);
	}

	public void calculateTotalPrice(Order order) {
		int totalPrice = 0;
		Iterator iterator = order.map.entrySet().iterator();
		while (iterator.hasNext()) {
			Map.Entry me = (Map.Entry) iterator.next();
			FoodItem foodItem = (FoodItem) me.getKey();
			int quantity = (int) me.getValue();
			int price = (int) foodItem.price;
			totalPrice += quantity * price;
		}
		order.totalPrice = totalPrice;
		System.out.println(" BILL " + order.totalPrice);

	}
}
