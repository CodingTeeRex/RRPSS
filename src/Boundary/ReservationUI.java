package src.Boundary;

import java.text.ParseException;
import java.util.HashMap;

import src.Control.ReservationManager;

public class ReservationUI extends UI {
    private ReservationManager reservationManager = new ReservationManager();

    public void run() {
        int choice = -1;
        String custName;

        do {
            this.displayMenu();
            choice = getInput();

            switch (choice) {
            case 1:
                int numPax = -1;
                Boolean isAvailable = false;
                int contactNum = -1;

                System.out.println("\nSelect date of reservation (MM-DD-YYYY): ");
                reservationManager.displayDates();
                reservationManager.getDateChoice(getInput());

                System.out.println("\nSelect timeslot of reservation: ");
                reservationManager.displayTimes();
                reservationManager.getTimeChoice(getInput());

                isAvailable = reservationManager.checkAvailability();

                if (!isAvailable) {
                    break;
                } else {
                    System.out.println("Select a Table: ");
                    reservationManager.getTableChoice(getInput());

                    System.out.println("Enter Customer Name: ");
                    custName = getString();

                    System.out.println("Enter contact number: ");
                    contactNum = getInput();

                    System.out.println("Enter number of pax: ");
                    numPax = getInput();

                    try {
                        reservationManager.makeReservation(custName, contactNum, numPax);
                    } catch (IllegalArgumentException e) {
                        System.out.println("# Pax is more than available seats for the table");
                        break;
                    }
                }
                break;
            case 2:
                System.out.println("Enter contact number: ");
                reservationManager.removeReservation(getInput());
                break;
            case 3:
                reservationManager.showAllReservations();
                break;
            case 4:
                // System.out.println("Enter Date (MM-DD-YYYY):");
                // String date = getString();
                
                // System.out.println("Enter Time (HH:MM) 24 Hour format: ");
                // String time = getString();

                // reservationManager.setProxyDateTime(date, time);
                // try {
                //     reservationManager.simulateAutoRemove();
                // } catch (ParseException e) {
                //     e.printStackTrace();
                // }
            default:
                break;
            }
        } while (choice < 5);
    }

    public void displayMenu() {
        System.out.println("\n################# RESERVATION MENU #################");
        System.out.println("1. Make Reservation.");
        System.out.println("2. Remove Reservation.");
        System.out.println("3. Check Reservation.");
        System.out.println("4. Set Date");
        System.out.println("5. Back.");
    }
}