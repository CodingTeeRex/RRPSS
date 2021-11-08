package src.Entity;

public abstract class Person {
	
	String firstName = "";
	String lastName = "";
	String gender = "";
	int contact = 0;
	
	public abstract String getName();
	public abstract String getFirstName();
	public abstract String getLastName();
	public abstract String getGender();
	public abstract int getContact();
	public abstract void print();
	public boolean compareDuplicate(Person p) {
	
		if ((p.getFirstName().equals(this.getFirstName()) && p.getLastName().equals(this.getLastName())) || (p.getContact() == this.getContact()))
		{
			return true;
		}
		
		return false;
	}
	

}
