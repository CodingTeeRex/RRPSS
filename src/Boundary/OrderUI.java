package src.Boundary;

import src.Control.OrderManager;
import src.Database.Database;
import src.Entity.Person;

public class OrderUI extends UI {
    
    public void run() {

        int choice = -1;
        int staffID,tableNo,orderID;
        String staffName = "Andy";


        do {
            this.displayMenu();
            choice = getInput();
            OrderManager ordermgt = new OrderManager();

            switch (choice) {
            case 1:
                System.out.println("Enter Table Number: ");
                tableNo = getInput();
                System.out.println("Enter Staff ID: ");
                staffID = getInput();
                

                Person staff =  Database.employeesDB.get(staffID);
                System.out.printf("NAME: %s", staff.getLastName());
    
                ordermgt.createOrder(staffID,tableNo,staffName);
                break;
            case 2:
                System.out.println("Enter Order: ");
                orderID = getInput();
                ordermgt.getOrder(orderID);
                break;
            case 3:
                System.out.println("Enter Order: ");
                orderID = getInput();
                ordermgt.addOrder(orderID);
                break;
            case 4:
                System.out.println("Enter Order: ");
                orderID = getInput();
                ordermgt.deleteOrder(orderID);
                break;
            case 5:
                ordermgt.getAllOrders();
                break;
            default:
                break;
            }
        } while (choice < 6);
    }

    public void displayMenu() {
        System.out.println("\n################# ORDER MENU #################");
        System.out.println("1. Create Order.");
        System.out.println("2. Get Order.");
        System.out.println("3. Add Order.");
        System.out.println("4. Delete Order.");
        System.out.println("5. Get All Orders.");
        System.out.println("6. Back.");
    }
}