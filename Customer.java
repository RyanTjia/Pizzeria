import pizzaStore.Store;

public class Customer {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        Store one = new Store();
        System.out.println(one.checkIngredient("cheese"));
    }
}