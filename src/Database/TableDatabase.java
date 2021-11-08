package src.Database;

import java.util.HashMap;
import src.Entity.Table;

public class TableDatabase {
    private HashMap<Integer, Table> tableList;

    public TableDatabase() { 
        this.tableList = new HashMap<Integer, Table>(); // Map unique table number to Table object
    }

    public HashMap<Integer, Table> getTableDB() {
        return this.tableList;
    }

    public void addTable(int tableID, int seats) {
        Table newTable = new Table(tableID, seats);
        this.tableList.put(tableID, newTable);
    }

    public Table removeTable(int tableID) {
        return this.tableList.remove(tableID);
    }

    public void deleteAll() {
        this.tableList.clear();
    }

    public Boolean contains(int tableID) {
        return this.tableList.containsKey(tableID);
    }

    public int getNumTables() {
        return this.tableList.size();
    }
 }


