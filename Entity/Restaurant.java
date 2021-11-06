package Entity;

// import java.util.ArrayList;
// import java.util.HashMap;

import Control.MainMenu;

public class Restaurant {

	private String name;
	private int totalEmployees;
	private int totalTables;
	// private HashMap<Integer, Employee> employeeList;
	// private ArrayList<Table> tableList;

	/**
	 * 
	 * @param totalEmployees
	 * @param totalTables
	 */
	public Restaurant(String name, int totalEmployees, int totalTables) {
		this.name = name;
		this.totalEmployees = totalEmployees;
		this.totalTables = totalTables;
		// employeeList = new HashMap<Integer, Employee>(); // Map employee ID to corresponding Employee object
		// tableList = new ArrayList<Table>();
	}

	public void run() {
		MainMenu mainMenu = new MainMenu();
		
		while (true) {
			Boolean quit = mainMenu.run(this.name);
			if (quit) break;
		}
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getTotalTables() {
		return this.totalTables;
	}

	/** c
	 * 
	 * @param totalTables
	 */
	public void setTotalTables(int totalTables) {
		this.totalTables = totalTables;
	}

	public int getTotalEmployees() {
		return this.totalEmployees;
	}

	/**
	 * 
	 * @param totalEmployees
	 */
	public void setTotalEmployees(int totalEmployees) {
		this.totalEmployees = totalEmployees;
	}

}