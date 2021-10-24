package Boundary;

public class OrderUI extends UI {
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
            case 3:
                break;
            default:
                break;
            }
        } while (choice < 4);
    }

    public void displayMenu() {
        System.out.println("\n################# ORDER MENU #################");
        System.out.println("1. Create Order.");
        System.out.println("2. Get Order.");
        System.out.println("3. Print Invoice.");
        System.out.println("4. Back.");
    }
}