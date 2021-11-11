
package Entity;
import java.io.Serializable;
public class MenuItem implements Serializable {
    private String name;
    private String description;
    private FoodCategory type;
    private double price;
    public MenuItem(String Name, String Description, String Type, double Price) {
        this.name = Name;
        this.description = Description;
        this.price = Price;
        if(new String("Appetiser").equals(Type))
        {
            this.type = FoodCategory.APPETISER;
        }
        if(new String("Main_Course").equals(Type))
        {
            this.type = FoodCategory.MAIN_COURSE;
        }
        if(new String("Drinks").equals(Type))
        {
            this.type = FoodCategory.DRINKS;
        }
        if(new String("Dessert").equals(Type))
        {
            this.type = FoodCategory.DESSERT;
        }

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
    public void setType(String type)
    {
        if(new String("Appetiser").equals(type))
        {
            this.type = FoodCategory.APPETISER;
        }
        if(new String("Main_Course").equals(type))
        {
            this.type = FoodCategory.MAIN_COURSE;
        }
        if(new String("Drinks").equals(type))
        {
            this.type = FoodCategory.DRINKS;
        }
        if(new String("Dessert").equals(type))
        {
            this.type = FoodCategory.DESSERT;
        }
    }
    public FoodCategory getType()
    {
        return this.type;
    }
    public double getPrice()
    {
        return  this.price;
    }
    public void setPrice(double price)
    {
        this.price = price;
    }
    public void print() {
        System.out.println("Name: " + this.getName() );
        System.out.println(" Type: " + this.getType());
        System.out.println("Description: " + this.getDescription());
        System.out.println("Price:" + this.getPrice());
        System.out.println("-----------------------------------------------------------------");
    }

}
