package src.Control;

import java.util.HashMap;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import src.Entity.Customer;
import src.Entity.Table;
import src.Database.TableDatabase;
import src.Database.ReservationDatabase;

/**
 * ReservationManager acts as the control between the customer and the tables.
 * Reservations cannot be made on the day itself. (must be made in advance)
 * After a set amount of time, the reservation will be removed after the actual
 * booking time.
 * 
 * @param dateList        contains a list of 30 dates not including the current
 *                        (today's) date.
 *                        <p>
 *                        dateList is used to display the available dates for
 *                        reservation
 * @param reservationList is a HashMap mapping a date formatted to a String to
 *                        an ArrayList of HashMaps where the inner HashMap's key
 *                        value pairs are the customer's name and the table
 *                        object respectively
 */

public class ReservationManager {
	private ArrayList<String> dateList;
	private ArrayList<String> availableDates;
	private int dateChoice;

	public ReservationManager() {

		this.availableDates = new ArrayList<String>();

		new ReservationDatabase();
		this.initReservationList();
	}

	private void initReservationList() {
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy, EEEE");
		Calendar calendar = Calendar.getInstance();

		for (int i = 1; i < 31; i++) {
			calendar.setTime(date);
			calendar.add(Calendar.DATE, 1);
			Date nextDate = calendar.getTime();
			ReservationDatabase.reservationList.put(dateFormat.format(nextDate), new HashMap<String, ArrayList<Table>>());
			date = nextDate;
		}
	}

	public void showAllReservations() {
		Object[] dateKeys = ReservationDatabase.reservationList.keySet().toArray();
		for (int i = 0; i < dateKeys.length; i++) {
			System.out.println(dateKeys[i]);
			if (ReservationDatabase.reservationList.get(dateKeys[i]).size() == 0)
				System.out.println("No reservations on this date.");
		}
	}

	public void displalAvailableTables() {

	}

	public void displayAvailableDates() {
		
		ReservationDatabase.reservationList.forEach((k, v) -> {
			if (ReservationDatabase.reservationList.get(k) == null || ReservationDatabase.reservationList.get(k).size() < TableDatabase.tableList.size()) {
				this.availableDates.add(k);
			}
		});

		for (int i = 0; i < this.availableDates.size(); i++) {
			System.out.printf("%d. %s\n", i+1, this.availableDates.get(i));
		}
	}

	public void getDateChoice(int dateChoice) {
		this.dateChoice = dateChoice;
		System.out.printf("%s selected.\n", this.availableDates.get(dateChoice));
	}

	public void displayAvailableTimes() {
		String[] times = { "11:00", "11:30", "12:00", "12:30", "13:00", "13:30", "14:00", "14:30", "15:00", "15:30",
				"16:00", "16:30", "17:00", "17:30", "18:30", "19:00", "19:30", "20:00", "20:30", "21:00" };
		
		
	}

	public void makeReservation(int dateChoice, int timeChoice, String custName, int contactNum, int numPax) {

	}
}