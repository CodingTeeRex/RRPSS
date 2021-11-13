package src.Control;
import java.util.List;

import src.Database.Database;
import src.Entity.Person;
import src.Entity.Customer;

public class CustomerManager {
	
	//Static list for storing the customers that visited the restaurant from the Database
	public static List<Person> customers = Database.customersDB;
	
	//Apply a membership to the respective Customer using Contact number
	public static void newMembership(String firstName, String lastName, String gender, int contact, String membership)
	{
		Person customer = new Customer(firstName, lastName, gender, contact, membership);
		customers.add(customer);
		System.out.println("[ACCEPTED] Employee Successfully Added!");
		customer.print();
	}
	//Obtaining the membership held by a Customer using Contact number
	public static void checkMembership(int contact)
	{
		for (Person p : customers)
		{
			//Customer can be found using the contact number
			if(((Customer)p).getContact() == contact)
			{
				System.out.println("[ACCEPTED] Customer Found!");
				p.print();
				return;
			}
		}
		//Unable to find the customer with the contact number provided
		System.out.println("[REJECTED] Unable to find the Customer with contact number: " + contact );
	}
	//Removing a membership from a Customer using Contact number
	public static void removeMembership(int contact)
	{
		for (Person p : customers)
		{
			//Customer can be found using the contact number and currently hold a membership
			if(((Customer)p).getContact() == contact)
			{
				if (((Customer)p).getMember())
				{
					((Customer)p).setMemberShip("");
					System.out.println("[ACCEPTED] The Customer with contact number: " + contact + " no longer hold a membership");
				}
				else
				{
					System.out.println("[REJECTED] The Customer with contact number: " + contact + " does not hold a membership");
				}					
				return;
			}
		}
		//Unable to find the customer with the contact number provided
		System.out.println("[REJECTED] Unable to find the Customer with contact number: " + contact );
	}
	

}
