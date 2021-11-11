package src.Boundary;

import java.util.HashMap;

import src.Control.ReservationManager;

public class ReservationUI extends UI {
    private ReservationManager reservationManager = new ReservationManager();
    private HashMap<Integer, String> timeslot;

    public ReservationUI() {
        this.timeslot = new HashMap<Integer, String>();
        // last available booking time is 21:00
        this.initTimeslots();
    }

    private void initTimeslots() {
        String[] times = { "11:00", "11:30", "12:00", "12:30", "13:00", "13:30", "14:00", "14:30", "15:00", "15:30",
                "16:00", "16:30", "17:00", "17:30", "18:30", "19:00", "19:30", "20:00", "20:30", "21:00" };
        for (int i = 0; i < times.length; i++) {
            this.timeslot.put(i+1, times[i]);
        }
    }

    private void displayTimeslots() {
        for (int i = 0; i < this.timeslot.size(); i++) {
            System.out.printf("%d. %s\n", i+1, this.timeslot.get(i+1));
        }
    }

    public void run() {
        int choice = -1;
        String custName;

        do {
            this.displayMenu();
            choice = getInput();

            switch (choice) {
            case 1:
                int numPax = -1;
                Boolean dateAvailable;
                Boolean timeAvailable;
                int contactNum = -1;


                System.out.println("Select date of reservation (MM-DD-YYYY): ");
                reservationManager.displayAvailableDates();
                reservationManager.getDateChoice(getInput());

                System.out.println("Select timeslot of reservation: ");
                // dateAvailable = reservationManager.checkDate(getInput());
                // if (!dateAvailable) {
                //     System.out.println("This date is not available for reservation.");
                //     break;
                // }

                // System.out.println("\nSelect time of reservation: ");
                // this.displayTimeslots();
                // timeAvailable = reservationManager.checkTimeslot(getInput());
                // if (!timeAvailable) {
                //     System.out.println("This timeslot is not available for reservation.");
                //     break;
                // }

                // System.out.println("Enter Customer Name: ");
                // custName = getString();

                // System.out.println("Enter contact number: ");
                // contactNum = getInput();

                // System.out.println("Enter number of pax: ");
                // numPax = getInput();

                // reservationManager.makeReservation(dateChoice, timeChoice, custName,
                // contactNum, numPax);
                break;
            case 2:
                break;
            case 3:
                reservationManager.showAllReservations();
                break;
            case 4:
                break;
            default:
                break;
            }
        } while (choice < 5);
    }

    public void displayMenu() {
        System.out.println("\n################# RESERVATION MENU #################");
        System.out.println("1. Make Reservation.");
        System.out.println("2. Remove Reservation.");
        System.out.println("3. Edit Reservation.");
        System.out.println("4. Check Reservation.");
        System.out.println("5. Back.");
    }
}