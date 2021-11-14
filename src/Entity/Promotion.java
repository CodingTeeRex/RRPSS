package src.Entity;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * Reperesents the promotional packages in the restaurant
 * @author Shreejaa Saravanan
 * @version 1.0
 * @since 13-11-2021
 */

public class Promotion implements Serializable {
    private String name;
    private String description;
    private double price;
    private int ID;
    private ArrayList <MenuItem> set = new ArrayList<MenuItem>();

    public Promotion(String Name, double Price, ArrayList<MenuItem> Set, String Description) {
        this.name = Name;
        this.description = Description;
        this.price = Price;
        this.set = Set;
    }
    public Promotion(int ID,String Name, double Price, ArrayList<MenuItem> Set) {
        this.ID = ID;
        this.name = Name;
        this.price = Price;
        this.set = Set;
    }
    public int getID()
    {
        return this.ID;
    }

    public String getName()
    {
        return this.name;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public String getDescription()
    {
        return this.description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public double getPrice()
    {
        return  this.price;
    }
    public void setPrice(double price)
    {
        this.price = price;
    }
    public ArrayList<MenuItem> getSet() {
        return this.set;
    }
    public void setSet(ArrayList<MenuItem> set) {
        this.set = set;
    }
    public void print(){
        System.out.println("Name: " + this.getName());
        System.out.println("Description: " + this.getDescription());
        System.out.println("Price:" + this.getPrice());
        System.out.println("Set:");
        for(MenuItem m: set)
        {
            System.out.println("Name: " + m.getName());
            System.out.println(" Type: " + m.getType());
            System.out.println("Description: " + m.getDescription());
            System.out.println("Price:" + m.getPrice());
            System.out.println("-----------------------------------------------------------------");}
        }

	public void printsimple() {
		System.out.printf("(%d) %s\n", this.getID() , this.getName());
	}
    }

