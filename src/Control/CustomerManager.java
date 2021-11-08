package src.Control;

import java.util.List;
import src.Entity.Person;
import src.Entity.Membership;
import src.Entity.Customer;
import src.Database.Database;

public class CustomerManager {
	
	List<Person> customers = Database.customersDB;
	
	
	public void newMembership(int contact, String membershipType)
	{
		Membership member = new Membership(membershipType);
		for (Person p : customers)
		{
			if(((Customer)p).getContact() == contact && !((Customer)p).getMember())
			{
				((Customer)p).setMemberShip(member);
			}
		}
	}
	public void removeMembership(int contact)
	{
		for (Person p : customers)
		{
			if(((Customer)p).getContact() == contact && ((Customer)p).getMember())
			{
				((Customer)p).setMemberShip(null);
			}
		}
	}
	

}
