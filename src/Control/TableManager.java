package src.Control;

import src.Entity.Table;
import src.Database.TableDatabase;
import java.util.HashMap;

public class TableManager {
    private TableDatabase tableDB;

    public TableManager() {
        this.tableDB = new TableDatabase();
    }

    public void addTable(int tableID, int seats) {
        if (seats < 2 || seats > 11) {
            throw new IllegalArgumentException("Number of seats must be minimum 2 and maximum 10");
        } else if (tableDB.contains(tableID)) {
            throw new IllegalArgumentException("Table with " + tableID + " already exists");
        } else {
            tableDB.addTable(tableID, seats);
            System.out.println("Table " + tableID + " successfully added");
        }
    }

    public void removeTable(int tableID) {
        Table t = tableDB.removeTable(tableID);
        if (t == null)
            System.out.println("Table does not exist.");
        else
            System.out.println("Table successfully removed.");
    }

    public void deleteAllTables() {
        tableDB.deleteAll();
    }

    public void showTableByID(int tableID) {
        HashMap<Integer, Table> db = tableDB.getTableDB();

        Table table = db.get(tableID);
        System.out.println("Table: " + table.getId() + ", Seats: " + table.getSeats() + ", Booked: " + table.isBooked() + ".");
    }

    public void showAllTables() {
        HashMap<Integer, Table> db = tableDB.getTableDB();

        for (Table table : db.values()) {
            System.out.println("Table: " + table.getId() + ", Seats: " + table.getSeats() + ", Booked: " + table.isBooked() + ".");
        }
    }

    public void showTables(Boolean showBooked) {
        HashMap<Integer, Table> db = tableDB.getTableDB();

        for (Table table : db.values()) {
            if (showBooked) {
                if (table.isBooked())
                    System.out.println("Table: " + table.getId() + ", Seats: " + table.getSeats() + ", Booked: " + table.isBooked() + ".");
            } else {
                if (!table.isBooked())
                    System.out.println("Table: " + table.getId() + ", Seats: " + table.getSeats() + ", Booked: " + table.isBooked() + ".");
            }
            
        }
    }

    public int getNumTables() {
        return tableDB.getNumTables();
    }

    public void initTables(int numTables) {
        HashMap<Integer, Table> db = tableDB.getTableDB();

        if (db.isEmpty()) { 
            for (int i = 0; i < numTables; i++) {
                this.addTable(i+1, (int)(Math.random() * 10) + 2);
            }
        } else {
            System.out.println("Tables already initialized.");
            System.out.println("Table Database must be cleared before re-initializing.");
        }
    }
}
