package src.Control;

import java.util.*;
import src.Database.OrderDatabase;

import src.Entity.Order;

public class PaymentManager {

    public static List<Order> Orders = OrderDatabase.OrderDB;


    public void getInovice(int orderID) {
        System.out.println("============================ INVOICE ====================================");
        for(Order o : Orders){
            if (o.getOrderID() == orderID) {
                o.printAll();
                return;
            }
            
        }
        System.out.println("ERROR Order ID " + orderID + ": Cant be found!");
	}

    public void getReceipt(int orderID, Boolean member ) {
        // System.out.println("============================ Receipt ====================================");
        for(Order o : Orders){
            if (o.getOrderID() == orderID) {
                o.printBill(o.getOrderID(),o.getStaffID(),o.getTableID(),member);
                return;
            }
            
        }
        System.out.println("ERROR Order ID " + orderID + ": Cant be found!");
	}

    public void getAllOrders(){
        System.out.println("============================ All Orders ====================================");
        for(Order o : Orders){
            System.out.printf("Order ID: %d, Staff ID: %d, Table Num: %d\n", o.getOrderID(),o.getStaffID(),o.getTableID());
        }
    }

}