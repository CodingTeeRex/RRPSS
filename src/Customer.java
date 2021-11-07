
public class Customer extends Person {
	
	boolean member = false;
	Membership membership;
	
	public Customer(String firstName, String lastName, String gender, int contact, String membership)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.contact = contact;
		if (!membership.equals("NA"))
		{
			this.member = true;
		}
		else
		{
			this.member = false;
		}
		this.membership = new Membership(membership);
		
	}
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return this.lastName + " " + this.firstName;
	}
	public String getFirstName()
	{
		return this.firstName;
	}
	public String getLastName()
	{
		return this.lastName;
	}

	@Override
	public String getGender() {
		// TODO Auto-generated method stub
		return this.gender;
	}

	@Override
	public int getContact() {
		// TODO Auto-generated method stub
		return this.contact;
	}
	public boolean getMember()
	{
		return this.member;
	}
	public void setMemberShip(Membership m)
	{
		if (m == null)
		{
			this.member = false;
			this.membership = null;
		}
		else
		{
			this.member = true;
			this.membership = m;
		}
	}
	@Override
	public void print() {
		// TODO Auto-generated method stub
		System.out.println("Name: " + this.getName());
		System.out.println("Gender: " + this.getGender() + " Contact: " + this.contact);
		System.out.println("Member: " + this.getMember() + " Title: " + this.membership.getType());
	}


}
