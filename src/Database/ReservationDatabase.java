package src.Database;

import src.Entity.Table;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.SortedMap;
import java.util.TreeMap;

public class ReservationDatabase {
    public static SortedMap<String, HashMap<String, ArrayList<Table>>> reservationList;

    public ReservationDatabase() {
        reservationList = new TreeMap<String, HashMap<String, ArrayList<Table>>>();
    }
}
