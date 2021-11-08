package src.Boundary;

public class PaymentUI extends UI {
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
            default:
                break;
            }
        } while (choice < 2);
    }

    public void displayMenu() {
        System.out.println("################# PAYMENT MENU #################");
        System.out.println("Please select an option below.");
        System.out.println("1. Make Payment.");
        System.out.println("2. Exit.");
    }
}