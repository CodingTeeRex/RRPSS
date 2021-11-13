package src.Entity;

import java.io.Serializable;

public class MenuItem implements Serializable {

	int ID;
	String name = "";
	FoodCategory type;
	String description = "";
	double price = 0.0;

	static enum FoodCategory {
		APPETISER("Appetiser"), MAIN_COURSE("Main_Course"), DRINKS("Drinks"), DESSERT("Dessert");

		private String name;

		public String getName() {
			return this.name;
		}

		FoodCategory(String name) {
			this.name = name;
		}
	}

	// public MenuItem(int ID,String name) {
	// 	this.name = name;
	// 	this.ID = ID;
	// }

	public MenuItem(int ID,String name,String type,double price) {
		this.ID = ID;
		this.name = name;
		if (type.contains("App")) {
			this.type = FoodCategory.APPETISER;
		} else if (type.contains("Main")) {
			this.type = FoodCategory.MAIN_COURSE;
		} else if (type.contains("Drink")) {
			this.type = FoodCategory.DRINKS;
		} else {
			this.type = FoodCategory.DESSERT;
		}
		this.price = price;

	}

	public MenuItem(String name, String description, String type, double price) {
		this.name = name;
		this.description = description;
		this.price = price;
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

	public int getID() {
		return this.ID;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name)
    {
      this.name = name;
    }

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
        this.description = description;
    }

	public String getType() {
		return this.type;
	}

	public void setType(String type)
    {
        // if(new String("Appetiser").equals(type))
        // {
        //     this.type = FoodCategory.APPETISER;
        // }
        // if(new String("Main_Course").equals(type))
        // {
        //     this.type = FoodCategory.MAIN_COURSE;
        // }
        // if(new String("Drinks").equals(type))
        // {
        //     this.type = FoodCategory.DRINKS;
        // }
        // if(new String("Dessert").equals(type))
        // {
        //     this.type = FoodCategory.DESSERT;
        // }

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
	
	public double getPrice(){
		return this.price;
	}

	public void setPrice(double price)
    {
        this.price = price;
    }

	public void print() {
        System.out.println("Name: " + this.getName() );
        System.out.println("\nType: " + this.getType());
        System.out.println("\nDescription: " + this.getDescription());
        System.out.println("\nPrice:" + this.getPrice());
        System.out.println("-----------------------------------------------------------------");
    }

	public void print1() {
		System.out.println("Name: " + this.getName() + " Type: " + type.getName());
		System.out.println("Description: " + this.getDescription());
	}

	public void printsimple() {
		System.out.printf("(%d) %s\n", this.getID() , this.getName());
	}

	public boolean compareDuplicate(MenuItem m) {

		if (this.getName().equals(m.getName())) {
			return true;
		}

		return false;
	}

}
