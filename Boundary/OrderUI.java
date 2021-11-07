package Boundary;

import Control.OrderManager;

public class OrderUI extends UI {
    
    public void run() {

        int choice = -1;
        int staffID,tableNo;


        do {
            this.displayMenu();
            choice = getInput();
            OrderManager ordermgt = new OrderManager();

            switch (choice) {
            case 1:
                System.out.println("Enter Staff ID: ");
                staffID = getInput();
                System.out.println("Enter Table Number: ");
                tableNo = getInput();
    
                ordermgt.createOrder(staffID,tableNo);


                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            default:
                break;
            }
        } while (choice < 5);
    }

    public void displayMenu() {
        System.out.println("\n################# ORDER MENU #################");
        System.out.println("1. Create Order.");
        System.out.println("2. Get Order.");
        System.out.println("3. Add Order.");
        System.out.println("4. Delete Order.");
        System.out.println("5. Back.");
    }
}