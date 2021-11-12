package Control;
import java.util.ArrayList;
import java.util.Scanner;
import Entity.MenuItem;
import Entity.Promotion;

public class FoodMenuManager1{
     public static ArrayList<MenuItem> menuItems=new ArrayList<MenuItem>();
    public static ArrayList<Promotion> promoSet= new ArrayList<Promotion>();
    public static  ArrayList<MenuItem> promoMenuItems = new ArrayList<MenuItem>();

    public static void addFoodItem(String name, String description, double price, String type) {
        MenuItem newMenu = new MenuItem(name, description, type, price);
        menuItems.add(newMenu);
        System.out.println(" New Food Item Successfully Added!");
        newMenu.print();
    }
    public static void addFoodItemPromo(String name, String description, double price, String type) {
        MenuItem newMenu = new MenuItem(name, description, type, price);
        promoMenuItems.add(newMenu);
        System.out.println("Food Item Successfully Added!");
        newMenu.print();
    }

    public static void removeFoodItem(String name) {
        for (MenuItem m : menuItems) {
            if (m.getName().equals(name)) {
                menuItems.remove(m);
                System.out.println(name + " removed successfully");
                return;
            }
            System.out.println(name + " cannot be found!");
        }
    }

    public static void editFoodItem(String name, String description, double price, String type,String newName) {
        for (MenuItem m : menuItems) {
            if (m.getName().equals(name)) {
                if (price != -1)
                    m.setPrice(price);

                if (!name.equals(""))
                    m.setName(newName);
                if (!description.equals(""))
                    m.setDescription(description);
                if (!type.equals(""))
                    m.setType(type);
                System.out.println("Food Item information updated successfully");
                m.print();
                return;
            }
            System.out.println(name + " cannot be found");
        }

    }

    public static void addPromotion(String name, double price, ArrayList<MenuItem> set, String description) {
        Promotion newPromo = new Promotion(name, price, set, description);
        promoSet.add(newPromo);
        System.out.println(" New Promotional Package Successfully Added!");
        newPromo.print();
    }

    public static void removePromotion(String name) {
        for (Promotion p : promoSet) {
            if (p.getName().equals(name)) {
                promoSet.remove(p);
                System.out.println(name + " removed successfully");
                return;
            }
        }
        System.out.println(name + " cannot be found!");
    }

    public static void editPromotion(String name, double price, ArrayList<MenuItem> set, String description, String updName) {
        for (Promotion p : promoSet) {
            if (p.getName().equals(name)) {

                if (price != -1)
                    p.setPrice(price);

                if (!name.equals(""))
                    p.setName(updName);
                if (!description.equals(""))
                    p.setDescription(description);
                p.setSet(set);
                System.out.println("Promotional package information updated successfully!");
                p.print();
                return;
            }
            System.out.println(name + " cannot be found!");
        }
    }
        public static void main(String[] args) {
        int choice,c;
        String n,d,t,n1,d1,t1,n2;
        double p,p1;

        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("------FOOD MENU MANAGER-----------");
            System.out.println("(1). Add a food item to the menu");
            System.out.println("(2). Delete a food item from the menu");
            System.out.println("(3). Update a food item in the menu");
            System.out.println("(4). Add a promotional package to the menu");
            System.out.println("(5). Delete a promotional package from the menu");
            System.out.println("(6). Update a promotional package in the menu");
            System.out.println("(7). Display the menu");
            System.out.println("(8). Exit");
            System.out.println("Enter your choice:");
            choice = sc.nextInt();
            System.out.println("");
            switch (choice) {
                case 1 -> {
                    System.out.println(" Please enter the name:");
                    sc.nextLine();
                    n = sc.nextLine();
                    System.out.println(" Please enter the description:");
                    d = sc.nextLine();
                    System.out.print(" Please enter the price:");
                    p = sc.nextDouble();
                    sc.nextLine();
                    System.out.println(" Please enter the type:");
                    t = sc.nextLine();
                    addFoodItem(n, d, p, t);
                }
                case 2 -> {
                    System.out.println(" Please enter the name of the food item to be removed:");
                    sc.nextLine();
                    n = sc.nextLine();
                    removeFoodItem(n);
                }
                case 3 -> {
                    System.out.println(" Please enter the name of the food item to be updated:");
                    sc.nextLine();
                    n = sc.nextLine();
                    System.out.println(" Please enter the new name:");
                    n2 = sc.nextLine();
                    System.out.println(" Please enter the new description:");
                    d = sc.nextLine();
                    System.out.println(" Please enter the new price:");
                    p = sc.nextDouble();
                    System.out.println(" Please enter the new type:");
                    sc.nextLine();
                    t = sc.nextLine();
                    editFoodItem(n, d, p, t,n2);
                }
                case 4 -> {
                    System.out.println(" Please enter the name:");
                    sc.nextLine();
                    n = sc.nextLine();
                    System.out.println(" Please enter the description:");
                    d = sc.nextLine();
                    System.out.print(" Please enter the price:");
                    p = sc.nextDouble();
                    sc.nextLine();
                    System.out.println(" Please enter the no.of.items in the promotion:");
                    c = sc.nextInt();
                    for (int i = 0; i < c; i++) {
                        System.out.println(" Please enter the name:");
                        sc.nextLine();
                        n1 = sc.nextLine();
                        System.out.println(" Please enter the description:");
                        d1 = sc.nextLine();
                        System.out.println(" Please enter the price:");
                        p1 = sc.nextDouble();
                        sc.nextLine();
                        System.out.println(" Please enter the type:");
                        t1 = sc.nextLine();
                        addFoodItemPromo(n1, d1, p1, t1);
                    }
                    addPromotion(n, p, promoMenuItems, d);
                }
                case 5 -> {
                    System.out.println(" Please enter the name:");
                    n = sc.next();
                    removePromotion(n);
                }
                case 6 -> {
                    System.out.println(" Please enter the name of the promotional package to be updated:");
                    sc.nextLine();
                    n = sc.next();
                    System.out.println(" Please enter the new name:");
                    n2 = sc.next();
                    System.out.println(" Please enter the new description:");
                    d = sc.next();
                    System.out.println(" Please enter the new price:");
                    p = sc.nextDouble();
                    System.out.println(" Please enter the new no.of food items:");
                    c = sc.nextInt();
                    for (int i = 0; i < c; i++) {
                        System.out.println(" Please enter the name:");
                        sc.nextLine();
                        n1 = sc.nextLine();
                        System.out.println(" Please enter the description:");
                        d1 = sc.nextLine();
                        System.out.println(" Please enter the price:");
                        p1 = sc.nextDouble();
                        sc.nextLine();
                        System.out.println(" Please enter the type:");
                        sc.nextLine();
                        t1 = sc.nextLine();
                        addFoodItemPromo(n1, d1, p1, t1);
                    }
                    editPromotion(n, p, promoMenuItems, d,n2);
                }
                case 7 -> {
                    System.out.println("---------FOOD MENU------------");
                    System.out.println("------------ ALA CARTE--------------------");
                    for(MenuItem m:menuItems)
                    { System.out.println("Name: " + m.getName() );
                    System.out.println(" Type: " + m.getType());
                    System.out.println("Description: " + m.getDescription());
                    System.out.println("Price:" + m.getPrice());
                    System.out.println("-----------------------------------------------------------------");}
                    System.out.println("------------------PROMOTIONAL PACKAGES-----------------------");
                    for(Promotion i:promoSet)
                    {
                        System.out.println("Name: " + i.getName() );
                        System.out.println("Description: " + i.getDescription());
                        System.out.println("Price:" + i.getPrice());
                    System.out.println("Set: ");
                    for(MenuItem m: promoMenuItems)
                    {
                        System.out.println("Name: " + m.getName() );
                        System.out.println(" Type: " + m.getType());
                        System.out.println("Description: " + m.getDescription());
                        System.out.println("Price:" + m.getPrice());
                        System.out.println("-----------------------------------------------------------------");}
                    System.out.println("*****************************************************");
                    }}
                case 8 -> System.out.println(" Exiting....");
                }
        } while (choice != 8);

    }
}
