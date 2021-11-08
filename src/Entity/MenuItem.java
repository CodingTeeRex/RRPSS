package src.Entity;

public class MenuItem {
	
	String name = "";
	FoodCategory type;
	String description = "";
	float price = 0.0f;
	
	
	static enum FoodCategory
	{
		APPETISER ("Appetiser"),
		MAIN_COURSE ("Main_Course"),
		DRINKS ("Drinks"),
		DESSERT ("Dessert");

		private String name;
		public String getName(){ return this.name; }
		FoodCategory(String name)
		{
			this.name = name;
		}
	}
	
	
	public MenuItem(String name,String description,String type)
	{
		this.name = name;
		this.description = description;
		
		if (type.contains("App"))
		{
			this.type = FoodCategory.APPETISER;
		}
		else if (type.contains("Main"))
		{
			this.type = FoodCategory.MAIN_COURSE;
		}
		else if (type.contains("Drink"))
		{
			this.type = FoodCategory.DRINKS;
		}
		else
		{
			this.type = FoodCategory.DESSERT;
		}
	}
	public String getName()
	{
		return this.name;
	}
	public String getDescription()
	{
		return this.description;
	}
	public String getType()
	{
		return this.type.getName();
	}
	public void print()
	{
		System.out.println("Name: " + this.getName() + " Type: " + type.getName());
		System.out.println("Description: " + this.getDescription());
	}
	public boolean compareDuplicate(MenuItem m) {
		
		if (this.getName().equals(m.getName()))
		{
			return true;
		}
		
		return false;
	}

}
