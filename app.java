import src.Entity.Restaurant;

public class app {
	public static void main(String[] args) {
		String RESTAURANT_NAME = "McDonalds"; // TODO: think of a restaurant name

		Restaurant awesomeRestaurant = new Restaurant(RESTAURANT_NAME);
		awesomeRestaurant.run();
	}
}