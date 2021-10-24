package Control;

import Boundary.MainMenuUI;

public class MainMenu {
	MainMenuUI mainMenu = new MainMenuUI();

	public void run(String restaurantName) {
		while (true) {
			Boolean quit = mainMenu.run(restaurantName);
			if (quit) break;
		}
	}

}