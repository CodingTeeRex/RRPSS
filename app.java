import Entity.Restaurant;

public class app {
	public static void main(String[] args) {
		String RESTAURANT_NAME = "McDonalds";
		int totalEmployess = 20;
		int totalTables = 15;

		Restaurant awesomeRestaurant = new Restaurant(RESTAURANT_NAME, totalEmployess, totalTables);
		awesomeRestaurant.run();
	}
}