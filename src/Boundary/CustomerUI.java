package src.Boundary;

import src.Control.CustomerManager;
import src.Entity.Customer;
import src.Entity.Membership;
import src.Entity.Person;

public class CustomerUI extends UI {

    public void run() {
        int choice = -1;
        // Continue to run as long as the input entered is within 1-3
        do {
            this.displayMenu();
            choice = getInput();

            switch (choice) {

            case 1:
                displayCustomerDB();
                // Initialised the required attributes to create a membership for the customer
                int contact = -1;
                String membershipType = "";
                // Obtaining a valid customer Contact Number
                System.out.println("Please Enter the Customer's Contact Number (8xxxxxxx - 9xxxxxxx): ");
                contact = super.getValidContactNumber(false);
                // Obtaining a valid membership type
                System.out.println("Please Enter the Customer's Membership Type: ");
                membershipType = super.getInputString(Membership.getAvailableMembership());
                // Applying membership for the Customer via the contact number
                CustomerManager.newMembership(contact, membershipType);
                break;
            case 2:
                displayCustomerDB();
                int cContact = -1;
                // Obtaining a valid customer Contact Number
                System.out.println("Please Enter the Customer's Contact Number (8xxxxxxx - 9xxxxxxx): ");
                cContact = super.getValidContactNumber(false);
                // Checking the membership for the Customer via the contact number
                CustomerManager.checkMembership(cContact);
                break;
            case 3:
                displayCustomerDB();
                int rContact = -1;
                // Obtaining a valid customer Contact Number
                System.out.println("Please Enter the Customer's Contact Number (8xxxxxxx - 9xxxxxxx): ");
                rContact = super.getValidContactNumber(false);
                // Removing the membership for the Customer via the contact number
                CustomerManager.removeMembership(rContact);
                break;
            default:
                break;
            }
        } while (choice < 4 && choice > 0);
    }

    // Displaying the UI menu for Altering Customers
    public void displayMenu() {
        System.out.println("\n################# CUSTOMER MENU #################");
        System.out.println("1. New Membership.");
        System.out.println("2. Check Membership.");
        System.out.println("3. Remove Membership");
        System.out.println("4. Back.");
    }

    // Displaying every customer information stored by the restaurant
    public void displayCustomerDB() {
        System.out.println(
                "============================CUSTOMER INFORMATION AVAILABLE====================================");
        for (Person p : CustomerManager.customers) {
            Customer c = (Customer) p;
            c.printMinimal();
        }
        System.out.println("================================================================================");
        System.out.println();

    }
}