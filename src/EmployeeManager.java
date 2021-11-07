import java.util.List;

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
			if (((Employee)p).id == id)
			{
				employees.remove(p);
				System.out.println("Employee " + id + ": removed");
				break;
			}
		}
		System.out.println("Employee " + id + ": Cant be found!");
	}
	
	
	
	
	
}
