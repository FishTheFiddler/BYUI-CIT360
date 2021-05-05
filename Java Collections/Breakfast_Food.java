package WesCollectionTypes;

public class Breakfast_Food {

    private String food;
    private String origin;

    public Breakfast_Food(String food, String origin) {
        this.food = food;
        this.origin = origin;
    }

    public String toString() {
        return "Title: " + food + "\nOrigin: " + origin;
    }
}
