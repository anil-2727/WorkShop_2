package com.bridgelabz.workshop;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class FoodManager {
	  static FoodManager instance;
	    Scanner sc = new Scanner(System.in);
	    Set<FoodItem> foodList = new HashSet<>(); // it do not add multiple items of same object.

	    private FoodManager() {
	    }

	    public static synchronized FoodManager getInstance(){
	        if (instance == null){
	            instance = new FoodManager();
	        }
	        return instance;
	    }
//	    List<FoodItem> foodList = new ArrayList(); // it do not add multiple items of same object.


	    public void add(FoodItem foodItem){
	        foodList.add(foodItem);
	    }
	    public void addNewFooItem(){
	        FoodItem foodItem = new FoodItem();
	        System.out.print("Enter name of food item :: ");
	        foodItem.name = sc.next();

	        System.out.print("Enter food type :: 1- veg  & 2- nonveg :: ");
	        int choice = sc.nextInt();
	        switch (choice) {
	            case 1 :
	                foodItem.type = FoodItem.Type.VEG;
	            case 2 :
	                foodItem.type = FoodItem.Type.NONVEG;
	        }
	        System.out.print("Enter food category:: 1- main course 2- Starter 3- Juice 4- Desert :: ");
	        int catChoice = sc.nextInt();
	        switch (catChoice){
	            case 1 :
	            foodItem.category = FoodItem.Category.MAIN_COURSE;
	            break;
	            case 2 :
	                foodItem.category = FoodItem.Category.STARTER;
	                break;
	            case 3 :
	                foodItem.category = FoodItem.Category.JUICES;
	                break;
	            case 4 :
	                foodItem.category = FoodItem.Category.DESERT;
	                break;
	            default:
	                System.out.println("ERROE");
	        }

	        System.out.print("Enter Taste :: 1 - spicy 2- sweet 3- salty 4- spicy salty:: ");
	        int tasteChoice = sc.nextInt();
	        switch (tasteChoice){

	            case 1 :
	                foodItem.taste = FoodItem.Taste.SPICY;
	            case 2 :
	                foodItem.taste = FoodItem.Taste.SWEET;
	            case 3 :
	                foodItem.taste = FoodItem.Taste.SALTY;
	            case 4 :
	                foodItem.taste = FoodItem.Taste.SPICY_SALTY;
	        }
	        System.out.print("enter preparation Time :: ");
	        byte prepTime = sc.nextByte();
	        foodItem.preparationTime = prepTime;

	        System.out.print("Enter price :: ");
	        float price = sc.nextFloat();
	        foodItem.price = price;

	        foodList.add(foodItem);
	    }

	    void print() {
	        for (FoodItem element : foodList) {
	            System.out.println(element);
	        }

	    }
	    public void delete(FoodItem foodItem){
	        foodList.remove(foodItem);
	    }

	    public int getFoodCount(){
	       return foodList.size();
	    }

	    public void printAllVegItem() {
	        System.out.println("Printing all veg items");
	        for (FoodItem element : foodList) {
	            if(element instanceof  IVeg) {
	                System.out.println(element);
	            }
	        }

	    }

	    public void printAllNonVegItem() {
	        System.out.println("Printing all Non-veg items");
	        for (FoodItem element : foodList) {
	            if(element instanceof  INonVeg) {
	                System.out.println(element);
	            }
	        }
	    }

	    FoodItem getFoodItem(String name){
	        Iterator iterator = foodList.iterator();
	        if (iterator.hasNext()) {
	            for (int i = 0 ; i < foodList.size(); i++) {
	                if (iterator.hasNext()) {
	                    FoodItem fooditem = (FoodItem) iterator.next();
	                    if (fooditem.name.equalsIgnoreCase(name)){
	                        return fooditem;
	                    }
	                }
	            }
	        }
	        return null;
	    }


	    public void removeFoodItem() {
	        Scanner sc = new Scanner(System.in);
	        System.out.print("enter name to remove food item :: ");
	        String name = sc.nextLine();
	        FoodItem foodItem = getFoodItem(name);
	        if (foodItem == null){
	            System.out.println("***** Sorry no food item found *** ");
	        }else {
	            delete(foodItem);
	        }
	    }


	}

