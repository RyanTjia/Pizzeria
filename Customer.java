import pizzaStore.Store;
import pizzaStore.Pizza;

public class Customer {
    public static void main(String[] args) {

        Store one = new Store();
        one.restock("pepperoni", 10);
        one.restock("olive", 10);

        Pizza order = one.createPizza();
        System.out.println("Your pizza have " + order.checkPizza() + ". Enjoy!");
    }
}