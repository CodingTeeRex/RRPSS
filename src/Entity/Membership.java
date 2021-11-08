package src.Entity;

public class Membership {
	
	//Type of membership
	String type = "";

	static String[] availableMembership = {"Restaurant", "Other Entities"};
	
	//Constructor for membership
	public Membership(String type)
	{
		this.type = type;
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
}
