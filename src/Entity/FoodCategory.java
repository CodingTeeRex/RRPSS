package src.Entity;


public enum FoodCategory {
    APPETISER("Appetiser"), MAIN_COURSE("Main Course"), DRINKS("Drinks"), DESSERT("Dessert");

    private String name;

    public String getName() {
        return this.name;
    }

    FoodCategory(String name) {
        this.name = name;
    }
}

// public enum FoodCategory1 {
//     APPETISER, MAIN_COURSE, DRINKS, DESSERT;

// }
