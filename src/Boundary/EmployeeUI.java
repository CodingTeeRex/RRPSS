package src.Boundary;

import src.Control.EmployeeManager;

public class EmployeeUI extends UI {
	EmployeeManager empMngr = new EmployeeManager();

	public void run() {
		int choice = -1;

		do {
			this.displayMenu();
			choice = getInput();
			switch (choice) {
			case 1:
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				empMngr.showAllEmployees();
				break;
			case 5:
				System.out.println("Enter employee's ID: ");
				int id = getInput();
				Boolean res = empMngr.getEmployeeByID(id);
				if (!res)
					System.out.println("No employee with this ID was found");
			default:
				break;
			}
		} while (choice < 6);
	}

	public void displayMenu() {
		System.out.println("\n################# EMPLOYEE MENU #################");
		System.out.println("1. Add Employee.");
		System.out.println("2. Remove Employee.");
		System.out.println("3. Edit Employee.");
		System.out.println("4. Show all Employees.");
		System.out.println("5. Find employee by ID.");
		System.out.println("6. Back.");
	}
}