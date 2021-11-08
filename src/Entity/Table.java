package src.Entity;

public class Table {
    private int id;
    private int seats;
    private Boolean booked;

    public Table(int id, int seats) {
        this.id = id;
        this.seats = seats;
        this.booked = false;
    }

    public int getId() {
        return this.id;
    }

    public int getSeats() {
        return this.seats;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSeats(int seats) {
        if (seats < 2 || seats > 11) {
            throw new IllegalArgumentException("Number of seats must be minimum 2 and maximum 10");
        } else {
            this.seats = seats;
        }
    }

    public Boolean isBooked() {
        return this.booked;
    }

    public void bookTable() {
        this.booked = true;
        System.out.println(this.id + " booked successfully.");
    }

    public void removeBooking() {
        if (this.booked) {
            this.booked = !this.booked;
            System.out.println(this.id + " removed booking.");
        } else {
            System.out.println("Table has not been booked. Cannot remove booking.");
        }
    }
}