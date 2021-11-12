package src.Entity;

import src.Database.TableDatabase;
public class Reservation {

    private String name;
	private int pax;
	private int contact;
	private Table table;
    private String time;
    private String date;

    public Reservation(String name, int pax, int contact, Table table, String time, String date) {
        this.name = name;
        this.pax = pax;
        this.contact = contact;
        this.table = table;
        this.time = time;
        this.date = date;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setPax(int pax) {
        this.pax = pax;
    }

    public int getPax() {
        return this.pax;
    }

    public void setContact(int contact) {
        this.contact = contact;
    }

    public int getContact() {
        return this.contact;
    }

    public void setTable(int tableId) {
        this.table = TableDatabase.tableList.get(tableId);
    }

    public Table getTable() {
        return this.table;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTime() {
        return this.time;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDate() {
        return this.date;
    }

}