package pizzaStore;
import java.util.*;

public class Store {

    //Location
    private int buildingNo;
    private String street;
    private String city;
    private String state;
    private int zip;

    //Ingredients
    private HashMap<String, Integer> ingredients;
    
    //Initialize the store
    public Store() {
        this.ingredients = new HashMap<String, Integer>();
    }

    public Store(int buildingNo, String street, String city, String state, int zip) {
        this.buildingNo = buildingNo;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
        
        this.ingredients = new HashMap<String, Integer>();
    }

    public void checkLocation() {
        System.out.println(this.buildingNo + " " + this.street + ", " + this.city + ", " + this.state + " " + this.zip);
    }

    //Setter and Getter for ingredients
    public int checkIngredient(String ingredient) {
        if (!this.ingredients.containsKey(ingredient) || this.ingredients.get(ingredient) == 0) {
            System.out.println("There are no more " + ingredient + " in stock!");
            return 0;
        }
        else {
            return this.ingredients.get(ingredient);
        }
    }

    public HashMap<String, Integer> checkStock() {
        return this.ingredients;
    }

    public void restock(String ingredient, int amount) {
        int stock = amount;

        if (this.ingredients.containsKey(ingredient)) {
            stock += this.ingredients.get(ingredient);
        }

        this.ingredients.put(ingredient, stock);
    }
}
