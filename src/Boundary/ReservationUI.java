package src.Boundary;

public class ReservationUI extends UI {
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
        System.out.println("\n################# RESERVATION MENU #################");
        System.out.println("1. Make Reservation.");
        System.out.println("2. Remove Reservation.");
        System.out.println("3. Edit Reservation.");
        System.out.println("4. Back.");
    }
}