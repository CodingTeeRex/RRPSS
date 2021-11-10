// import MenuItem;

package Control;

import java.util.Scanner;

public class OrderManager1 {

	// public void run() {

	// }

	public void displayMenu() {
        System.out.println("################# FOOD MENU #################");
        System.out.println("1. Appetizer.");
        System.out.println("2. Main Course.");
        System.out.println("3. Drinks.");
        System.out.println("4. Dessert.");
        System.out.println("5. Back.");
	}

    public void displaysubMenu(int choice) {
        System.out.println("################# FOOD MENU #################");
        System.out.println("1. Appetizer.");
        System.out.println("2. Main Course.");
        System.out.println("3. Drinks.");
        System.out.println("4. Dessert.");
        System.out.println("5. Back.");
	}

	public void createOrder(int staffID , int tableNo) {
        // need to do check if order exists


        System.out.println("Order Successfully Created");
        System.out.println("Redirect to add order");
        addOrder(tableNo);
	}

	public void addOrder(int tableNo) {
        Scanner sc = new Scanner(System.in);
        int choice = -1;
        

        do {
            this.displayMenu();
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    displaysubMenu(1);
                    break;
                case 2:
                    displaysubMenu(1);
                    break;
                case 3:
                    displaysubMenu(1);
                    break;
                case 4:
                    displaysubMenu(4);
                    break;
                default:
                    break;
                }
        } while (choice < 5);

	}

	// private MenuItem[] getOrder() {

	// }

}