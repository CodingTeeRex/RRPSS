package src.Entity;

// import java.util.ArrayList;
// import java.util.HashMap;

import src.Control.MainMenu;

public class Restaurant {

	private String name;


	/**
	 * 
	 * @param totalEmployees
	 * @param totalTables
	 */
	public Restaurant(String name) {
		this.name = name;
	}

	public void run() {
		MainMenu mainMenu = new MainMenu();
		mainMenu.run(this);
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
}