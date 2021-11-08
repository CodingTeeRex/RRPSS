package src.Control;

import java.util.List;
import src.Entity.Person;
import src.Entity.Employee;
import src.Database.Database;

public class EmployeeManager {
	
	List<Person> employees = Database.employeesDB;
	
	
	public void addEmployee(String firstName, String lastName, String gender, int contact, int id, String title)
	{
		Person employee = new Employee(firstName, lastName, gender, contact, id, title);
		employees.add(employee);
	}

	public void removeEmployee(int id)
	{
		for (Person p : employees)
		{
			if (((Employee)p).getID() == id)
			{
				employees.remove(p);
				System.out.println("Employee " + id + ": removed");
				break;
			}
		}
		System.out.println("Employee " + id + ": Cant be found!");
	}

	public void showAllEmployees() {
		for (Person p : employees) {
			Employee e = (Employee)p;
			System.out.printf("Employee ID: %d, Name: %s, Title: %s, Gender: %s, Contact: %d\n", e.getID(), e.getName(), e.getTitle(), e.getGender(), e.getContact());
		}
	}

	public Boolean getEmployeeByID(int id) {
		for (Person p : employees) {
			Employee e = (Employee)p;
			if (e.getID() == id) {
				System.out.printf("Employee ID: %d, Name: %s, Title: %s, Gender: %s, Contact: %d\n", e.getID(), e.getName(), e.getTitle(), e.getGender(), e.getContact());
				return true;
			}
		}
		return false;
	}
	
}
