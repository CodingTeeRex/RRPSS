package src.Control;

import java.util.HashMap;
import java.util.TreeMap;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;

import src.Entity.Table;
import src.Database.TableDatabase;
import src.Database.ReservationDatabase;
import src.Entity.Reservation;

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
	private ArrayList<String> availableDates;
	private HashMap<Integer, Table> availableTables;
	private int dateChoice;
	private int timeChoice;
	private int tableChoice;
	private String[] times = { "12:00", "12:30", "13:00", "13:30", "14:00", "14:30", "15:00", "15:30", "16:00", "16:30",
			"17:00", "17:30", "18:30", "19:00", "19:30", "20:00", "20:30", "21:00" };

	private String proxyDate;
	private String proxyTime;

	public ReservationManager() {
		new ReservationDatabase();
		this.initReservationList();

		this.availableDates = new ArrayList<String>();
	}

	private void initReservationList() {
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy, EEEE");
		Calendar calendar = Calendar.getInstance();

		for (int i = 1; i < 8; i++) {
			calendar.setTime(date);
			calendar.add(Calendar.DATE, 1);
			Date nextDate = calendar.getTime();
			ReservationDatabase.reservationList.put(dateFormat.format(nextDate), this.initInnerHashMap());
			date = nextDate;
		}
	}

	private TreeMap<String, ArrayList<Reservation>> initInnerHashMap() {
		TreeMap<String, ArrayList<Reservation>> r = new TreeMap<String, ArrayList<Reservation>>();

		for (int i = 0; i < times.length; i++) {
			r.put(times[i], new ArrayList<Reservation>());
		}

		return r;
	}

	public void showAllReservations() {
		Object[] dateKeys = ReservationDatabase.reservationList.keySet().toArray();
		for (int i = 0; i < dateKeys.length; i++) {
			System.out.println();
			System.out.println(dateKeys[i]);
			System.out.println("#################################################");

			ReservationDatabase.reservationList.get(dateKeys[i]).forEach((k, v) -> {
				System.out.println("\nTimeslot: " + k);
				System.out.println("==============================================");
				if (v.isEmpty()) {
					System.out.println("Currently no reservations on this timeslot.\n");
				} else {
					for (int j = 0; j < v.size(); j++) {
						System.out.printf("Table#: %d\t Name: %s\t Contact: %d\n", v.get(j).getTable().getId(),
								v.get(j).getName(), v.get(j).getContact());
					}
				}
			});
		}
	}

	public void showReservationByDate() {
		Object[] dateKeys = ReservationDatabase.reservationList.keySet().toArray();
		for (int i = 0; i < dateKeys.length; i++) {
			System.out.printf("%d. %s\n", i + 1, dateKeys[i]);
		}
	}

	public void displayDates() {
		ReservationDatabase.reservationList.forEach((k, v) -> {
			this.availableDates.add(k);
		});

		for (int i = 0; i < this.availableDates.size(); i++) {
			System.out.printf("%d. %s\n", i + 1, this.availableDates.get(i));
		}
	}

	public void getDateChoice(int dateChoice) {
		this.dateChoice = dateChoice;
		System.out.printf("\n%s selected.\n", this.availableDates.get(dateChoice - 1));
	}

	public void displayTimes() {
		for (int i = 0; i < times.length; i++) {
			System.out.printf("%d. %s\n", i + 1, times[i]);
		}
	}

	public void getTimeChoice(int timeChoice) {
		this.timeChoice = timeChoice;
		System.out.printf("\n%s selected.\n", times[timeChoice - 1]);
	}

	public void getTableChoice(int tableChoice) {
		this.tableChoice = tableChoice;
	}

	public Boolean checkAvailability() {
		String date = this.availableDates.get(this.dateChoice - 1);
		String time = this.times[this.timeChoice - 1];
		Boolean full = false;

		// This is an ArrayList of booked tables for that time and date
		ArrayList<Reservation> reservedTables = ReservationDatabase.reservationList.get(date).get(time);

		// HasmMap to store available tables. Mapping: TableID -> Table
		this.availableTables = TableDatabase.tableList;

		// Compare with all restaurant tables to find which ones are not on the list
		// Not on reservation list means it is not reserved
		if (!reservedTables.isEmpty()) {
			for (int i = 0; i < reservedTables.size(); i++)
				this.availableTables.remove(reservedTables.get(i).getTable().getId()); // remove reserved tables so that
																						// un-reserved tables can be
																						// shown
		} else if (reservedTables.size() == TableDatabase.tableList.size()) {
			full = true;
		}

		// show tables availabe for selected date & time
		if (!full) {
			System.out.printf("Available tables for %s, %s:\n", this.availableDates.get(this.dateChoice - 1),
					times[this.timeChoice - 1]);
			System.out.println("#################################################");
			for (int i = 0; i < this.availableTables.size(); i++) {
				Table t = this.availableTables.get(i + 1);
				if (t != null) {
					System.out.printf("%d. Table %d \t # Seats: %d \t Taken: %b\n", i + 1, t.getId(), t.getSeats(),
							t.isTaken());
				}
			}
		} else {
			System.out.printf("Reservation is full for %s, %s:\n", this.availableDates.get(this.dateChoice - 1),
					times[this.timeChoice - 1]);
			return false;
		}
		return true;
	}

	public void makeReservation(String custName, int contactNum, int numPax) {
		Table t = this.availableTables.get(this.tableChoice);

		if (numPax > t.getSeats()) {
			this.availableDates.clear();
			throw new IllegalArgumentException("Pax > Seats");
		}

		Reservation newReservation = new Reservation(custName, numPax, contactNum, t,
				this.availableDates.get(this.dateChoice - 1), times[this.timeChoice - 1]);
		ReservationDatabase.reservationList.get(this.availableDates.get(this.dateChoice - 1))
				.get(times[this.timeChoice - 1]).add(newReservation);
		this.availableDates.clear();
	}

	public void removeReservation(int contactNum) {
		ReservationDatabase.reservationList.forEach((k, v) -> {
			v.forEach((time, res) -> {
				for (int i = 0; i < res.size(); i++) {
					if (res.get(i).getContact() == contactNum) {
						System.out.printf("Removing reservation for %s at %s, %s\n", res.get(i).getName(),
								res.get(i).getDate(), res.get(i).getTime());
						res.remove(i);
						System.out.println("Successfully removed");
					}
				}
			});
		});
	}

	public void setProxyDateTime(String date, String time) {
		this.proxyDate = date;
		this.proxyTime = time;
	}

	// public void simulateAutoRemove() throws ParseException {
	// 	SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
	// 	SimpleDateFormat toFormat = new SimpleDateFormat("MM-dd-yyyy, EEEE");
	// 	System.out.println(this.proxyDate);
	// 	Date d = dateFormat.parse(this.proxyDate);
	// 	String sd = toFormat.format(d);
	// 	System.out.println("toFormat" + sd);

	// 	try {
	// 		ReservationDatabase.reservationList.get(sd).get(this.proxyTime).forEach((res) -> {
	// 			System.out.println(res.getName());
	// 		});
	// 	} catch (NullPointerException e) {
	// 		System.out.println("ERROR! No entry found to simulate.");
	// 		return;
	// 	}

	// 	ReservationDatabase.reservationList.forEach((k, v) -> {
	// 		System.out.println(k);
	// 		if (k == sd) {
	// 			for (int i = 0; i < ReservationDatabase.reservationList.get(k).get(this.proxyTime).size(); i++) {
	// 				System.out.println(ReservationDatabase.reservationList.get(k).get(this.proxyTime).get(i).getName());
	// 				Timer timer = new Timer();
	// 			}
	// 		}
	// 	});
	// }
}