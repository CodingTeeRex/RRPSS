package src.Entity;


import src.Control.MainMenuManager;

public class Restaurant {

	private String name;


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


}