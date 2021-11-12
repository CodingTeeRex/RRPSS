package src.Database;

import java.util.HashMap;
import src.Entity.Table;

public class TableDatabase {
    public static HashMap<Integer, Table> tableList;

    public TableDatabase() { 
        tableList = new HashMap<Integer, Table>(); // Map unique table number to Table object
    }
 }


