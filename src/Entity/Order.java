package src.Entity;

import java.util.ArrayList;
import java.util.List;
import src.Database.Database;
import java.text.SimpleDateFormat;
import java.util.Date;



public class Order {

	private int orderID;
	private int tableID;
	private int staffID;
    private String staffName;
	public List<OrderItem> itemList;

    public Order(int orderID, int tableID, int staffID, String staffName){
        this.orderID = orderID;
        this.tableID = tableID;
        this.staffID = staffID;
        this.staffName = staffName;
        this.itemList = new ArrayList<OrderItem>();

    }

	public int getOrderID() {
		return this.orderID;
	}

	public int getStaffID() {
		return this.staffID;
	}
    public String getStaffName() {
		return this.staffName;
	}
	public int getTableID() {
		return this.tableID;
	}

    public void setTableID(int tableID) {
		this.tableID = tableID;
	}

    public int getitems() {
		return this.tableID;
	}

    public void additems(int pax,String name,String type, double price) {
        for (OrderItem i : itemList){
            if(i.getName() == name){
                i.pax += pax;
                return;
            }
        }
        
        OrderItem item = new OrderItem(pax, name, type, price);
        itemList.add(item);
	}

    public void deleteitems(int choice) {
        itemList.remove(choice-1);
	}


    public void print() {
		System.out.printf("Order ID: %d, Service Staff: %s, Table Number: %d\n", this.getOrderID(),this.getStaffName(),this.getTableID());

	}

    public void printItems() {
		// System.out.println("OrderID: " + this.getOrderID());
		// System.out.println("Service Staff: " + this.getStaffID());
		// System.out.println("Table Number: " + this.getTableID());
        
        int counter = 1;

        System.out.printf("Order ID: %d, Service Staff: %s, Table Number: %d\n", this.getOrderID(),this.getStaffName(),this.getTableID());
        System.out.println("          Pax    Dish Name                                   Price");
        System.out.printf("-------------------------------------------------------------------\n");
        for(OrderItem o : itemList){
            o.setTemp(counter);
            System.out.printf(" (%-2d)     %-4d   %-35s         $%.2f\n",o.getTemp(), o.getPax(),o.getName(),(o.getPax()*o.getPrice()));
            counter++;
        }

	}

    public void printAll() {
        System.out.println(" Pax    Dish Name                                   Price");
        System.out.printf("-------------------------------------------------------------\n");
        for(OrderItem o : itemList){
            System.out.printf(" %-4d   %-35s         $%.2f\n", o.getPax(),o.getName(),(o.getPax()*o.getPrice()));
        }

	}


    public void printBill(int orderID, int staffID, int tableID, Boolean member , String staffName) {

        double total = 0;
        double temp;
        String str = "%";
        // SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        SimpleDateFormat formatter1 = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat formatter2 = new SimpleDateFormat("HH:mm:ss");
        Date date = new Date();

        //HEADER
        System.out.printf("----------------------------------------------------------------------------------------------------------------\n\n");
        System.out.printf("                                           %s\n", Database.restaurantName);
        System.out.printf("                                           %s\n", "10 Ang Mo Kio Street 12, Singapore 567740");
        System.out.printf("                                           %s%d\n", "TEL: " , 98765432);
        System.out.printf("                                           %s%d\n\n", "Check #: ", orderID );
        System.out.printf("     Server : %-15s                                                                    Date: ", staffName);
        System.out.println(formatter1.format(date));
        System.out.printf("     Table #: %-15d                                                                    Time: ", tableID);
        System.out.println(formatter2.format(date));
        // System.out.printf("                                                Client: %d\n", 6);
        System.out.printf("----------------------------------------------------------------------------------------------------------------\n\n");

        //BODY
        //System.out.printf("Order ID: %d, Staff ID: %d, Table Number: %d\n", this.getOrderID(),this.getStaffID(),this.getTableID());
        //System.out.println("Pax--Dish Name----------------------------------Price");
        for(OrderItem o : itemList){
            total = total + o.getPax()*o.getPrice();
            System.out.printf("     %-2d      %-35s                                                           $%.2f\n", o.getPax(),o.getName(),(o.getPax()*o.getPrice()));
        }
        System.out.printf("----------------------------------------------------------------------------------------------------------------\n");
        System.out.printf("                                                                                                SUB-TOTAL: $%.2f  \n", total);
        System.out.printf("                                                                                       Tax(GST + Service): $%.2f  \n", total*0.17);
        if(!member){
            System.out.printf("----------------------------------------------------------------------------------------------------------------\n");
            System.out.printf("                                                                                                    TOTAL: $%.2f  \n", total*1.17);
        }
        else{
            temp = (total*1.17)*0.1;
            System.out.printf("                                                                                           Discount (10%s): $%.2f  \n",str,temp);
            System.out.printf("----------------------------------------------------------------------------------------------------------------\n");
            temp = (total*1.17)*0.9;
            System.out.printf("                                                                                                    TOTAL: $%.2f  \n", temp);
        }
        System.out.printf("================================================================================================================\n\n");

        //FOOTER
        System.out.printf("****************************************************************************************************************\n");
        System.out.printf("                                           THANKS FOR DINNING WITH US ! \n");
        System.out.printf("****************************************************************************************************************\n");



	}
    

}