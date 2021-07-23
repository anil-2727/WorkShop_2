package com.bridgelabz.workshop;


import java.util.Objects;

interface IVeg{ }

interface INonVeg { }

public class FoodItem {
	  enum Taste {SPICY , SWEET, SALTY, SPICY_SALTY}
	    enum Category {MAIN_COURSE, STARTER, JUICES, DESERT}
	    enum Type { VEG, NONVEG}
	    Taste taste;
	    Type type;
	    float price;
	    byte preparationTime;
	    Category category;
	    String name;


	    @Override
	    public boolean equals(Object o) {
	        if (this == o) return true;
	        if (o == null || getClass() != o.getClass()) return false;
	        FoodItem foodItem = (FoodItem) o;
	        return Float.compare(foodItem.price, price) == 0 && preparationTime == foodItem.preparationTime && taste == foodItem.taste && category == foodItem.category && Objects.equals(name, foodItem.name);
	    }

	    @Override
	    public int hashCode() {
	        return Objects.hash(taste, price, preparationTime, category, name);
	    }

	    @Override
	    public String toString() {
	        return "FoodItem{" +
	                "name=" + name +
//	                ", type=" + type +
	                ", taste=" + taste +
	                ", price= " + price +
	                ", preparationTime=" + preparationTime +
	                ", category=" + category +
	                '}';
	    }

//	    public  void printMainIngredients();


}

