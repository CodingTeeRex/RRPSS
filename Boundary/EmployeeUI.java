package Boundary;
public class EmployeeUI extends UI {
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
			default:
				break;
			}
		} while (choice < 4);
	}

	public void displayMenu() {
		System.out.println("\n################# EMPLOYEE MENU #################");
		System.out.println("1. Add Employee.");
		System.out.println("2. Remove Employee.");
		System.out.println("3. Edit Employee.");
		System.out.println("4. Back.");
	}
}