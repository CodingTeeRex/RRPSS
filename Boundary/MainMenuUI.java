package Boundary;

//import Control.*;

public class MainMenuUI extends UI {
    private FoodMenuUI foodMenu = new FoodMenuUI();
    private OrderUI orderMenu = new OrderUI();
    private EmployeeUI employeeMenu = new EmployeeUI();
    private ReservationUI reservationMenu = new ReservationUI();
    private CustomerUI customerMenu = new CustomerUI();
    private PaymentUI paymentMenu = new PaymentUI();

    public Boolean run(String restaurantName) {
        int choice = -1;

        do {
            this.displayMenu(restaurantName);
            choice = getInput();

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

    public void displayMenu(String restaurantName) {
        System.out.println("\nWelcome to " + restaurantName + " RRPSS!");
        System.out.println("################# MAIN MENU #################");
        System.out.println("Please select an option below.");
        System.out.println("1. Make an order.");
        System.out.println("2. Make a reservation.");
        System.out.println("3. Make Payment.");
        System.out.println("4. Menu Settings.");
        System.out.println("5. Employee Settings.");
        System.out.println("6. Customer Settings.");
        System.out.println("7. Print Sales Revenue Report.");
        System.out.println("8. Exit.");
    }
}