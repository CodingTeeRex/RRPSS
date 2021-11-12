package src.Database;

import src.Entity.Reservation;

import java.util.ArrayList;
import java.util.SortedMap;
import java.util.TreeMap;

public class ReservationDatabase {
    public static SortedMap<String, TreeMap<String, ArrayList<Reservation>>> reservationList;

    public ReservationDatabase() {
        reservationList = new TreeMap<String, TreeMap<String, ArrayList<Reservation>>>();
    }
}
