package src.Entity;


public class Membership {
	
	//Type of membership
	String type = "";
	float discountPercent = 0.0f;

	static String[] availableMembership = {"Restaurant", "Other Entities"};
	
	//Constructor for membership
	public Membership(String type)
	{
		this.type = type;
		this.discountPercent = setDiscountPercent(type);
	}
	//Obtaining the type of Membership
	public String getType()
	{
		return this.type;
	}
	//Updating the type of Membership
	public void setType(String type)
	{
		this.type = type;
		this.discountPercent = setDiscountPercent(type);
	}
	public static String[] getAvailableMembership()
	{
		printMembership();
		return availableMembership;
	}
	//Printing the available membership in the restaurant
	public static void printMembership()
	{
		System.out.println("============================MEMBERSHIP AVAILABLE====================================");
		for (String s : availableMembership)
		{
			System.out.println(s);
		}
		System.out.println("================================================================================");
	}
	//Set the discount percent according to the membership type
	public float setDiscountPercent(String type)
	{
		if (type.equals("Restaurant"))
		{
			return 0.3f;
		}
		else if (type.equals("Other Entities"))
		{
			return 0.2f;
		}
		else
		{
			return 0.0f;
		}
	}
}
