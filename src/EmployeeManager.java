package src;

import java.util.List;

public class EmployeeManager {
	
	//Static list for storing the employees that are working for the restaurant from the Database
	public static List<Person> employees = Database.employeesDB;
	
	//Adding a new employee to the database 
	public static void addEmployee(String firstName, String lastName, String gender, int contact, int id, String title)
	{
		Person employee = new Employee(firstName, lastName, gender, contact, id, title);
		employees.add(employee);
		System.out.println("[ACCEPTED] Employee Successfully Added!");
		employee.print();
	}
	//Removing an exisiting employee from the Database
	public static void removeEmployee(int id)
	{
		for (Person p : employees)
		{
			//Found the employee to remove from the Database
			if (((Employee)p).getID() == id)
			{
				employees.remove(p);
				System.out.println("[ACCEPTED] Employee ID " + id + ": removed");
				return;
			}
		}
		//Unable to find the employee to remove from the Database
		System.out.println("[REJECTED] Employee ID " + id + ": Cant be found!");
	}
	//Updating contact/title of an exisiting employee to the Database
	public static void EditEmployee(int id, int contact, String title)
	{
		for (Person p : employees)
		{
			//Found the employee to update the information
			if (((Employee)p).getID() == id)
			{
				//Contact number to update is provided
				if (contact != -1)
					((Employee)p).setContact(contact);
				//Title to update is provided
				if (!title.equals(""))
					((Employee)p).setTitle(title);
				System.out.println("[ACCEPTED] Employee " + id + ": updated Personal Info");
				p.print();
				return;
			}
		}
		//Unable to find the employee to update the information
		System.out.println("[REJECTED] Employee " + id + ": Cant be found!");
	}
	
	
	
	
	
}
