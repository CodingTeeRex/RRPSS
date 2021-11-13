package src.Boundary;

import src.Control.PaymentManager;
import src.Control.OrderManager;

public class PaymentUI extends UI {
    public void run() {
        int choice = -1;
        int orderID = 0;
        Boolean mem = false;

        do {
            this.displayMenu();
            choice = getInput();
            PaymentManager paymentmgt = new PaymentManager();

            switch (choice) {
            case 1:
                String temp;
                do{
                    System.out.println("Enter Order ID: ");
                    temp = getString();

                    if(temp.equals("#")){
                        break;
                    }
                    
                    orderID = Integer.parseInt(temp);

                }while(orderID < 1 || orderID > OrderManager.Orders.size());

                if(temp.equals("#")){
                    break;
                }

                System.out.println("Is the customer a member? (Y/N): ");
                String response = getString();                
                if (response.equals("Y"))
                    mem = true;
                // paymentmgt.getInovice(orderID);
                // System.out.println("Proceed to the counter to make payment.");
                paymentmgt.getReceipt(orderID,mem);

                break;
            case 2:
                paymentmgt.getAllOrders();
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
        System.out.println("2. Get All Orders.");
        System.out.println("3. Exit.");
        // System.out.println("2. Exit.");
        // System.out.println("2. Exit.");

    }
}