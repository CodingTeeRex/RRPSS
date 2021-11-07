import java.util.List;

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
