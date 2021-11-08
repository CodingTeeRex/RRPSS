package src.Entity;

public abstract class Person {

	// Variable for storing the first name of a Person
	String firstName = "";
	// Variable for storing the last name of a Person
	String lastName = "";
	// Variable for storing the gender of a Person
	String gender = "";
	// Variable for storing the contact number of a Person
	int contact = 0;

	// Different Variations of input for Male and Female
	static String[] genders = { "Male", "Female", "M", "F" };

	// Abstract function to be overwritten by the child
	public abstract String getName();

	public abstract String getFirstName();

	public abstract String getLastName();

	public abstract String getGender();

	public abstract int getContact();

	public abstract void setContact(int contact);

	public abstract void print();

	// Obtaining the variation used for inputing the gender
	public static String[] returnGenderSynonym() {
		return genders;
	}

	// Compare to see if person already exist by checking the first and last name OR
	// checking the contact number
	public boolean compareDuplicate(Person p) {

		if ((p.getFirstName().equals(this.getFirstName()) && p.getLastName().equals(this.getLastName()))
				|| (p.getContact() == this.getContact())) {
			return true;
		}

		return false;
	}

}
