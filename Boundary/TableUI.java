package Boundary;

import Control.TableManager;

public class TableUI extends UI {
    private TableManager tableManager = new TableManager();

    public void run() {
        int choice = -1;
        int tableID = -1, seats = -1;

        do {
            this.displayMenu();
            choice = getInput();

            switch (choice) {
            case 1:
                System.out.println("Enter the Table ID to be created: ");
                tableID = getInput();

                System.out.println("Enter number of seats (min. 2, max. 10): ");
                seats = getInput();
                try {
                    tableManager.addTable(tableID, seats);
                } catch (IllegalArgumentException e) {
                    System.out.println("ERROR!");
                    System.out.println("Table with ID: " + tableID + " already exists.");
                    System.out.println("Or number of seats not allowed.");
                }
                break;
            case 2:
                System.out.println("Enter the Table ID to be removed: ");
                tableID = getInput();
                tableManager.removeTable(tableID);
                break;
            case 3:
                System.out.println("Are you sure you want to delete all tables? Y/N");
                System.out.println("You will lose all table information!");
                String response = getString();
                if (response == "Y")
                    tableManager.deleteAllTables();
                else
                    break;
                break;
            case 4:
                System.out.println("Enter the ID of the table to view details.");
                tableID = getInput();
                tableManager.showTableByID(tableID);
                break;
            case 5:
                tableManager.showAllTables();
                break;
            case 6:
                tableManager.showTables(true); // set arg to true to show booked tables
                break;
            case 7:
                tableManager.showTables(false); // set arg to false to show unbooked tables
                break;
            case 8:
                System.out.println("How many tables do you want to initialize?");
                int numTables = getInput();
                tableManager.initTables(numTables);
                break;
            default:
                break;
            }
        } while (choice < 9);
    }

    public void displayMenu() {
        System.out.println("\n################# TABLE MENU #################");
        System.out.println("1. Add a new table.");
        System.out.println("2. Remove a table.");
        System.out.println("3. Remove all tables.");
        System.out.println("4. Show table by ID.");
        System.out.println("5. Show all tables.");
        System.out.println("6. Show booked tables.");
        System.out.println("7. Remove unbooked tables.");
        System.out.println("8. Initialize tables.");
        System.out.println("9. Back.");
    }
}
