package src.Entity;

import java.util.ArrayList;
import java.util.List;

public class Order {

	private int orderID;
	private int tableID;
	private int staffID;
	public List<OrderItem> itemList;

    public Order(int orderID, int tableID, int staffID){
        this.orderID = orderID;
        this.tableID = tableID;
        this.staffID = staffID;
        this.itemList = new ArrayList<OrderItem>();
    }

	public int getOrderID() {
		return this.orderID;
	}

	public int getStaffID() {
		return this.staffID;
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
        OrderItem item = new OrderItem(pax, name, type, price);
        itemList.add(item);
	}


    public void print() {
		System.out.println("OrderID: " + this.getOrderID());
		System.out.println("Service Staff: " + this.getStaffID());
		System.out.println("Table Number: " + this.getTableID());

	}

    public void printAll() {
		// System.out.println("OrderID: " + this.getOrderID());
		// System.out.println("Service Staff: " + this.getStaffID());
		// System.out.println("Table Number: " + this.getTableID());

        System.out.printf("Order ID: %d, Staff ID: %d, Table Number: %d\n", this.getOrderID(),this.getStaffID(),this.getTableID());
        System.out.println("Pax--Dish Name----------------------------------Price");
        for(OrderItem o : itemList){
            System.out.printf(" %d   %s                           $%f\n", o.getPax(),o.getName(),(o.getPax()*o.getPrice()));
        }

	}

    public void printBill(int orderID, int staffID, int tableID, Boolean member) {

        double total = 0;
        double temp;
        String str = "%";

        //HEADER
        System.out.printf("----------------------------------------------------------------------------------------------------------------\n\n");
        System.out.printf("                                                %s\n", "RESTRAUNT NAME");
        System.out.printf("                                                %s\n", "LOCATION");
        System.out.printf("                                                %s%d\n", "TEL: " , 98765432);
        System.out.printf("                                                %s%d\n\n", "Check #: ", orderID );
        System.out.printf("     Server : %15s                                                                    Date: 18/11/2021  \n", "SERVER NAME");
        System.out.printf("     Table #: %15d                                                                    Time: 1720  \n", 2);
        System.out.printf("                                                Client: %d\n", 6);
        System.out.printf("----------------------------------------------------------------------------------------------------------------\n\n");

        //BODY
        //System.out.printf("Order ID: %d, Staff ID: %d, Table Number: %d\n", this.getOrderID(),this.getStaffID(),this.getTableID());
        //System.out.println("Pax--Dish Name----------------------------------Price");
        for(OrderItem o : itemList){
            total = total + o.getPax()*o.getPrice();
            System.out.printf("     %d      %-35s                                                           $%.2f\n", o.getPax(),o.getName(),(o.getPax()*o.getPrice()));
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
        System.out.printf("                                                THANKS FOR DINNING WITH US ! \n");
        System.out.printf("****************************************************************************************************************\n");



	}
    

}