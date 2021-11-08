package src.Entity;


public class Employee extends Person {

	private int id;
	String title = "";
	
	public Employee(String firstName, String lastName, String gender, int contact, int id, String title)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.contact = contact;
		this.id = id;
		this.title = title;
		
		
	}
	@Override
	public String getName() {
		return this.firstName + " " + this.lastName;
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
		return this.gender;
	}

	@Override
	public int getContact() {
		return this.contact;
	}
	public int getID()
	{
		return this.id;
	}
	public String getTitle()
	{
		return this.title;
	}
	@Override
	public void print() {
		System.out.println("Name: " + this.getName());
		System.out.println("Gender: " + this.getGender() + " Contact: " + this.contact);
		System.out.println("ID: " + this.getID() + " Title: " + this.title);
	}

}
