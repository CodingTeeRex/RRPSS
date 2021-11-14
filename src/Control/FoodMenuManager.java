package src.Control;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import src.Entity.MenuItem;
import src.Entity.Promotion;
import src.Database.Database;

public class FoodMenuManager{
    public static List<MenuItem> menuItems= Database.menuItemsDB;
    public static ArrayList<Promotion> promoSet= new ArrayList<Promotion>();

    public static void addFoodItem(String name, String description, double price, String type) {
        MenuItem newMenu = new MenuItem(name, description, type, price);
        menuItems.add(newMenu);
        System.out.println(" New Food Item Successfully Added!");
        newMenu.print();
    }
    public static MenuItem addFoodItemPromo(String name, String description, double price, String type) {
        MenuItem newMenu = new MenuItem(name, description, type, price);
        System.out.println("Food Item Successfully Added!");
        newMenu.print();
        return newMenu;
    }

    public static void removeFoodItem(String name) {
        for (MenuItem m : menuItems) {
            if (m.getName().equals(name)) {
                menuItems.remove(m);
                System.out.println(name + " removed successfully");
                return;
            }
        }
        System.out.println(name + " cannot be found!");
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
            
        }
        System.out.println(name + " cannot be found");

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
            
        }
        System.out.println(name + " cannot be found!");
    }

}
