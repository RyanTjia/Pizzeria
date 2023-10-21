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
    //Each store may have different variety of ingredients
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

    //Making a pizza
    public Pizza createPizza() {
        Pizza order = new Pizza();
        Scanner input = new Scanner(System.in);
        String choice = "";

        while (true) {
            System.out.println("========================================");
            System.out.print("What do you want on your pizza? We have: ");
            System.out.println(this.ingredients.keySet().toString());

            System.out.print("Your pizza have: ");
            System.out.println(order.checkPizza());

            System.out.println("Type 'exit' to complete order");

            choice = input.nextLine().toLowerCase();
            if (choice.equalsIgnoreCase("exit")) {
                break;
            }
            else if (checkIngredient(choice) == 0) {
                System.out.println("We don't have " + choice + " in stock!");
            }
            else if (order.containTopping(choice)) {
                System.out.println("Your pizza already have it!");
            }
            else {
                int prevAmount = this.ingredients.get(choice);
                this.ingredients.put(choice, prevAmount - 1);
                order.addToppings(choice);
            }
        }
        input.close();

        return order;
    }
}
