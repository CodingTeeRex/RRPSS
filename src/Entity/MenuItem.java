package src.Entity;

public class MenuItem {

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

	public int getID() {
		return this.ID;
	}

	public String getName() {
		return this.name;
	}

	public String getDescription() {
		return this.description;
	}

	public String getType() {
		return this.type.getName();
	}
	
	public double getPrice(){
		return this.price;
	}

	public void print() {
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
