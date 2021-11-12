import src.Entity.Restaurant;
import src.Database.Database;

public class app {
	public static void main(String[] args) {
		String RESTAURANT_NAME = "McDonalds"; // TODO: think of a restaurant name
		Database.restaurantName = RESTAURANT_NAME;
		Restaurant awesomeRestaurant = new Restaurant(RESTAURANT_NAME);
		
		initDB(); // initialize the database with items from csv files

		awesomeRestaurant.run();
	}

	private static void initDB() {
		Database.parseCSV("src/Database/csv");
		Database.printDatabase();
	}
}