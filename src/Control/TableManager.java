package src.Control;

import src.Database.TableDatabase;
import src.Entity.Table;

public class TableManager {

    public TableManager() {
        new TableDatabase();
        this.initTables(10);
    }

    public void addTable(int tableID, int seats) {
        if (seats < 2 || seats > 11) {
            throw new IllegalArgumentException("Number of seats must be minimum 2 and maximum 10");
        }

        if (TableDatabase.tableList != null) {
            if (TableDatabase.tableList.containsKey(tableID))
                throw new IllegalArgumentException("Table with " + tableID + " already exists");
        }
        
        Table newTable = new Table(tableID, seats);
        TableDatabase.tableList.put(tableID, newTable);
        System.out.println("Table " + tableID + " successfully added");
        
    }

    public void removeTable(int tableID) {
        Table t = TableDatabase.tableList.remove(tableID);
        if (t == null)
            System.out.println("Table does not exist.");
        else
            System.out.println("Table successfully removed.");
    }

    public void deleteAllTables() {
        TableDatabase.tableList.clear();
        System.out.println("Tables deleted.");
    }

    public void showTableByID(int tableID) {

        Table table = TableDatabase.tableList.get(tableID);
        System.out.println("Table: " + table.getId() + ", Seats: " + table.getSeats() + ", Taken: " + table.isTaken() + ".");
    }

    public void showAllTables() {
        for (Table table : TableDatabase.tableList.values()) {
            System.out.println("Table: " + table.getId() + ", Seats: " + table.getSeats() + ", Taken: " + table.isTaken() + ".");
        }
    }

    public void showTables(Boolean showTaken) {

        for (Table table : TableDatabase.tableList.values()) {
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
        return TableDatabase.tableList.size();
    }

    public void initTables(int numTables) {
        if (TableDatabase.tableList.isEmpty()) { 
            for (int i = 0; i < numTables; i++) {
                this.addTable(i+1, (int)(Math.random() * 9) + 2);
            }
        } else {
            System.out.println("Tables already initialized.");
            System.out.println("Table Database must be cleared before re-initializing.");
        }
    }
}
