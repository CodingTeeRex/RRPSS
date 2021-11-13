package src.Entity;

import src.Entity.MenuItem.FoodCategory;

public class OrderItem {
    int tempID;
    int pax;
	String name = "";
    FoodCategory type;
	double price;

    public OrderItem(int pax,String name,String type, double price){
        this.pax=pax;
        this.name=name;
        this.price=price;
		this.tempID = 0;
        if (type.contains("App")) {
			this.type = FoodCategory.APPETISER;
		} else if (type.contains("Main")) {
			this.type = FoodCategory.MAIN_COURSE;
		} else if (type.contains("Drink")) {
			this.type = FoodCategory.DRINKS;
		} else {
			this.type = FoodCategory.DESSERT;
		}
    }

	public int getPax() {
		return this.pax;
	}

	public String getName() {
		return this.name;
	}
	public String getType() {
		return this.type.getName();
	}
	
	public double getPrice(){
		return this.price;
	}

	public int getTemp() {
		return this.tempID;
	}
	
	public void setTemp(int temp) {
		this.tempID = temp;
	}
	

}
