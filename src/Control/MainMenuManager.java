package src.Control;

import javax.sound.sampled.ReverbType;

import src.Boundary.*;
import src.Entity.Restaurant;

public class MainMenuManager {
	private MainMenuUI mainMenuUI = new MainMenuUI();
	private FoodMenuUI foodMenu = new FoodMenuUI();
	private OrderUI orderMenu = new OrderUI();
	private EmployeeUI employeeMenu = new EmployeeUI();
	private ReservationUI reservationMenu = new ReservationUI();
	private CustomerUI customerMenu = new CustomerUI();
	private PaymentUI paymentMenu = new PaymentUI();
	private TableUI tableMenu = new TableUI();
	private RevenueUI revenueMenu = new RevenueUI();

	public void run(Restaurant restaurant) {
		int choice = -1;

		// App loop
		while (true) {

			mainMenuUI.displayMenu(restaurant.getName());
			choice = mainMenuUI.getInput();

			switch (choice) {
				case 1:
					orderMenu.run();
					break;
				case 2:
					reservationMenu.run();
					break;
				case 3:
					paymentMenu.run();
					break;
				case 4:
					foodMenu.run();
					break;
				case 5:
					employeeMenu.run();
					break;
				case 6:
					customerMenu.run();
					break;
				case 7:
					tableMenu.run();
					break;
				case 8:
					revenueMenu.run();
				default:
					System.out.println("Sytem Shutting Down...");
					break;
			}

			if (choice >= 9) break;
		}
	}
}