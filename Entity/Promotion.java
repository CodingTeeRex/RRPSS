package Entity;
import java.io.Serializable;
import java.util.ArrayList;
public class Promotion implements Serializable {
    private String name;
    private String description;
    private double price;
    private ArrayList <MenuItem> set = new ArrayList<MenuItem>();
    public Promotion(String Name, double Price, ArrayList<MenuItem> Set, String Description) {
        this.name = Name;
        this.description = Description;
        this.price = Price;
        this.set = Set;
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
    }

