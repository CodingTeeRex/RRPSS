package Boundary;
public class CustomerUI extends UI {
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
        } while (choice < 3);
    }
    
    public void displayMenu() {
        System.out.println("\n################# CUSTOMER MENU #################");
        System.out.println("1. New Membership.");
        System.out.println("2. Check Membership.");
        System.out.println("3. Back.");
    }
}