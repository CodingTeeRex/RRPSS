package src.Entity;

// import java.util.ArrayList;
// import java.util.HashMap;

import src.Control.MainMenuManager;

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
	public Restaurant(String name) {
		this.name = name;
		// employeeList = new HashMap<Integer, Employee>(); // Map employee ID to corresponding Employee object
		// tableList = new ArrayList<Table>();
	}

	public void run() {
		MainMenuManager mainMenu = new MainMenuManager();
		mainMenu.run(this);
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