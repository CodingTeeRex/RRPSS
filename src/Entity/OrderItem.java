package src.Entity;

import java.util.ArrayList;

public class OrderItem {
    int tempID;
    int pax;
	String name = "";
    FoodCategory type;
	double price;
	private ArrayList <MenuItem> set = new ArrayList<MenuItem>();

    public OrderItem(int pax,String name,FoodCategory type, double price){
        this.pax=pax;
        this.name=name;
        this.price=price;
		this.tempID = 0;
		this.type = type;

    }

	public OrderItem(int pax,String name, double price,ArrayList<MenuItem> Set){
        this.pax=pax;
        this.name=name;
        this.price=price;
		this.tempID = 0;
		this.set = Set;

    }

	public int getPax() {
		return this.pax;
	}
	public String getName() {
		return this.name;
	}
	public FoodCategory getType() {
		return this.type;
	}
	
	public double getPrice(){
		return this.price;
	}
	public void setPax(int pax)
	{
		this.pax = pax;
	}
	public void setPrice(double price)
	{
		this.price = price;
	}
	public int getTemp() {
		return this.tempID;
	}
	
	public void setTemp(int temp) {
		this.tempID = temp;
	}
	public ArrayList<MenuItem> getSet() {
        return this.set;
    }
    public void setSet(ArrayList<MenuItem> set) {
        this.set = set;
    }
	
}
