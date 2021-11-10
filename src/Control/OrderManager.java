package src.Control;

import java.util.ArrayList;
import java.util.List;
import src.Database.OrderDatabase;
import src.Database.Database;
import src.Entity.Order;
import src.Entity.MenuItem;

import java.util.Scanner;

public class OrderManager {

    public static List<Order> Orders = OrderDatabase.OrderDB;
    public static List<MenuItem> menuItems = Database.menuItemsDB;
    public static List<MenuItem> itemList = new ArrayList<MenuItem>();
    private static int orderID = 0;
    Scanner sc = new Scanner(System.in);
	// public void run() {

	// }

	public void displayMenu() {
        System.out.println("################# FOOD MENU #################");
        System.out.println("1. Appetiser.");
        System.out.println("2. Main Course.");
        System.out.println("3. Drinks.");
        System.out.println("4. Dessert.");
        System.out.println("5. Back.");
	}

    public void displaysubMenu(int choice) {
        int counter = 1;
        if (choice == 1){
                System.out.println("################# Appetiser MENU #################");
                for (MenuItem m : menuItems) {
                    if(m.getType() == "Appetiser" ){
                        MenuItem item = new MenuItem(counter, m.getName(),m.getType(),m.getPrice());
                        itemList.add(item);
                        counter++;
                    }
                }
                for (MenuItem n : itemList) {
                    n.printsimple();
                }
                // System.out.println("\nEnter \"end\" to go back.");
            return;
        }
        if (choice == 2){
                System.out.println("################# Main Course MENU #################");
                for (MenuItem m : menuItems) {
                    if(m.getType() == "Main_Course" ){
                        MenuItem item = new MenuItem(counter, m.getName(),m.getType(),m.getPrice());
                        itemList.add(item);
                        counter++;
                    }
                }
                for (MenuItem n : itemList) {
                    n.printsimple();
                }
                // System.out.println("\nEnter \"end\" to go back.");
            return;
        }
        if (choice == 3){
                System.out.println("################# Drinks MENU #################");
                for (MenuItem m : menuItems) {
                    if(m.getType() == "Drinks" ){
                        MenuItem item = new MenuItem(counter, m.getName(),m.getType(),m.getPrice());
                        itemList.add(item);
                        counter++;
                    }
                }
                for (MenuItem n : itemList) {
                    n.printsimple();
                }
                // System.out.println("\nEnter \"end\" to go back.");
            return;
        }
        if (choice == 4){
                System.out.println("################# Dessert MENU #################");
                for (MenuItem m : menuItems) {
                    if(m.getType() == "Dessert" ){
                        MenuItem item = new MenuItem(counter, m.getName(),m.getType(),m.getPrice());
                        itemList.add(item);
                        counter++;
                    }
                }
                for (MenuItem n : itemList) {
                    n.printsimple();
                }
                // System.out.println("\nEnter \"end\" to go back.");
            return;
        }

	}

	public void createOrder(int staffID , int tableNo) {

        Order order = new Order(orderID, tableNo, staffID);
        orderID ++;
        Orders.add(order);

        System.out.println("Order Successfully Created");
        order.print(); 
        // getAllOrders();

        // System.out.println("Redirect to add order");
        // addOrder(tableNo);
	}

    public void getOrder(int orderID) {
        System.out.println("============================ ORDER ====================================");
        for(Order o : Orders){
            if (o.getOrderID() == orderID) {
                // System.out.printf("Order ID: %d, Staff ID: %d, Table Num: %d\n", o.getOrderID(),o.getStaffID(),o.getTableID());
                o.printAll();
                return;
            }
            
        }
        System.out.println("ERROR Order ID " + orderID + ": Cant be found!");
	}

	public void addOrder(int orderID) {

        for (Order o : Orders) {
			if (o.getOrderID() == orderID) {
                int choice = -1;
                
        
                do {
                    this.displayMenu();
                    choice = sc.nextInt();
        
                    switch (choice) {
                        case 1:
                            displaysubMenu(1);
                            additems(orderID);
                            itemList.clear();
                            break;
                        case 2:
                            displaysubMenu(2);
                            additems(orderID);
                            itemList.clear();
                            break;
                        case 3:
                            displaysubMenu(3);
                            additems(orderID);
                            itemList.clear();
                            break;
                        case 4:
                            displaysubMenu(4);
                            additems(orderID);
                            itemList.clear();
                            break;
                        default:
                            break;
                        }
                } while (choice < 5);
                return;
			}
		}
		System.out.println("ERROR Order ID " + orderID + ": Cant be found!");

	}

    public void deleteOrder(int orderID) {
        for (Order o : Orders) {
			if (o.getOrderID() == orderID) {
				Orders.remove(o);
				System.out.println("Order " + orderID + " is removed");
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

    public void additems(int orderID){
        String input, input1;
        double price = 12.50;


        System.out.println("\nEnter the item number: ");
        input = sc.next();
        System.out.println("\nEnter how many servings: ");
        input1 = sc.next();

        // if (input == "end" || input1 == "end"){
        //     return;
        // }

        for (Order o : Orders) {
			if (o.getOrderID() == orderID) {
                for (MenuItem n : itemList) {
                    if(n.getID() == Integer.parseInt(input)){
                        // o.additems(Integer.parseInt(input1), n.getName(), n.getType(), n.getPrice());

                        o.additems(Integer.parseInt(input1), n.getName(), n.getType(), price);
                    }
                }
                
			}
		}
    }

	// private MenuItem[] getOrder() {

	// }

    
    }