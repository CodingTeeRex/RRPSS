package src.Control;

import java.util.List;
import src.Entity.Person;
import src.Entity.Employee;
import src.Database.Database;

/**
 * Control class Employee Manager.
 * 
 * @author Fabian Wong
 * @version 1.0
 * @since 13/11/2021
 */

public class EmployeeManager {
	// Static list for storing the employees that are working for the restaurant
	// from the Database
	public static List<Person> employees = Database.employeesDB;

	
	/** 
	 * 
	 * Adding a new employee to the database
	 * @param firstName
	 * @param lastName
	 * @param gender
	 * @param contact
	 * @param id
	 * @param title
	 */
	// Adding a new employee to the database
	public static void addEmployee(String firstName, String lastName, String gender, int contact, int id,
			String title) {
		Person employee = new Employee(firstName, lastName, gender, contact, id, title);
		employees.add(employee);
		System.out.println("[ACCEPTED] Employee Successfully Added!");
		employee.print();
	}

	
	/** 
	 * Removing an exisiting employee from the Database
	 * @param id
	 */
	// Removing an exisiting employee from the Database
	public static void removeEmployee(int id) {
		for (Person p : employees) {
			// Found the employee to remove from the Database
			if (((Employee) p).getID() == id) {
				employees.remove(p);
				System.out.println("[ACCEPTED] Employee ID " + id + ": removed");
				return;
			}
		}
		// Unable to find the employee to remove from the Database
		System.out.println("[REJECTED] Employee ID " + id + ": Cant be found!");
	}

	
	/** 
	 * Updating contact/title of an exisiting employee to the Database
	 * @param id
	 * @param contact
	 * @param title
	 */
	// Updating contact/title of an exisiting employee to the Database
	public static void editEmployee(int id, int contact, String title) {
		for (Person p : employees) {
			// Found the employee to update the information
			if (((Employee) p).getID() == id) {
				// Contact number to update is provided
				if (contact != -1)
					((Employee) p).setContact(contact);
				// Title to update is provided
				if (!title.equals(""))
					((Employee) p).setTitle(title);
				System.out.println("[ACCEPTED] Employee " + id + ": updated Personal Info");
				p.print();
				return;
			}
		}
		// Unable to find the employee to update the information
		System.out.println("[REJECTED] Employee " + id + ": Cant be found!");
	}

	public static void showAllEmployees() {
		for (Person p : employees) {
			Employee e = (Employee) p;
			System.out.printf("Employee ID: %d, Name: %s, Title: %s, Gender: %s, Contact: %d\n", e.getID(), e.getName(),
					e.getTitle(), e.getGender(), e.getContact());
		}
	}

	
	/** 
	 * Get Empleyee details by their ID
	 * @param id
	 * @return Boolean
	 */
	public static Boolean getEmployeeByID(int id) {
		for (Person p : employees) {
			Employee e = (Employee) p;
			if (e.getID() == id) {
				System.out.printf("Employee ID: %d, Name: %s, Title: %s, Gender: %s, Contact: %d\n", e.getID(),
						e.getName(), e.getTitle(), e.getGender(), e.getContact());
				return true;
			}
		}
		return false;
	}

	
	/** 
	 * Get all the employees in the restarunt
	 * @return List<Person>
	 */
	public static List<Person> getEmployeeList() {
		return employees;
	}
}



