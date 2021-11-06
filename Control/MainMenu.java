package Control;

import Boundary.*;

public class MainMenu {
	private MainMenuUI mainMenuUI = new MainMenuUI();
	private FoodMenuUI foodMenu = new FoodMenuUI();
	private OrderUI orderMenu = new OrderUI();
	private EmployeeUI employeeMenu = new EmployeeUI();
	private ReservationUI reservationMenu = new ReservationUI();
	private CustomerUI customerMenu = new CustomerUI();
	private PaymentUI paymentMenu = new PaymentUI();

	public Boolean run(String restaurantName) {
		int choice = -1;

		do {

			mainMenuUI.displayMenu(restaurantName);
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
					// TODO: Print sales report
					break;
				default:
					System.out.println("Sytem Shutting Down...");
					return true;
			}
			return false;

		} while (choice < 8);
	}
}