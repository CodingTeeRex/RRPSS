package src.Control;

import src.Database.TableDatabase;
import src.Entity.Table;
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
        HashMap<Integer, Table> db = TableDatabase.getTableDB();

        Table table = db.get(tableID);
        System.out.println("Table: " + table.getId() + ", Seats: " + table.getSeats() + ", Taken: " + table.isTaken() + ".");
    }

    public void showAllTables() {
        HashMap<Integer, Table> db = TableDatabase.getTableDB();

        for (Table table : db.values()) {
            System.out.println("Table: " + table.getId() + ", Seats: " + table.getSeats() + ", Taken: " + table.isTaken() + ".");
        }
    }

    public void showTables(Boolean showTaken) {
        HashMap<Integer, Table> db = TableDatabase.getTableDB();

        for (Table table : db.values()) {
            if (showTaken) {
                if (table.isTaken())
                    System.out.println("Table: " + table.getId() + ", Seats: " + table.getSeats() + ", Taken: " + table.isTaken() + ".");
            } else {
                if (!table.isTaken())
                    System.out.println("Table: " + table.getId() + ", Seats: " + table.getSeats() + ", Taken: " + table.isTaken() + ".");
            }
            
        }
    }

    public int getNumTables() {
        return tableDB.getNumTables();
    }

    public void initTables(int numTables) {
        HashMap<Integer, Table> db = TableDatabase.getTableDB();

        if (db.isEmpty()) { 
            for (int i = 0; i < numTables; i++) {
                this.addTable(i+1, (int)(Math.random() * 9) + 2);
            }
        } else {
            System.out.println("Tables already initialized.");
            System.out.println("Table Database must be cleared before re-initializing.");
        }
    }
}
