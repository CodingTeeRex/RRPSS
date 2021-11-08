package src.Boundary;
public class FoodMenuUI extends UI {
    
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
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            default:
                break;
            }
        } while (choice < 7);
    }

    public void displayMenu() {
        System.out.println("\n################# MENU MANAGER #################");
        System.out.println("1. Add Food Item.");
        System.out.println("2. Remove Food Item.");
        System.out.println("3. Edit Food Item.");
        System.out.println("4. Add Promotion.");
        System.out.println("5. Remove Promotion.");
        System.out.println("6. Edit Promotion.");
		System.out.println("7. Back.");
    }
}