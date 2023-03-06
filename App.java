import Oven.PizzaOven;
import Oven.Pizza;
import java.util.List;
import java.util.ArrayList;
public class App {
    public static void main(String[] args) throws Exception {
        // PizzaOven po = new PizzaOven();
        // System.out.println(po.getPizza());
        PizzaOven pizzaOven = PizzaOven.INSTANCE;

        List<Pizza> pizzaList = new ArrayList<>();
        pizzaList.add(pizzaOven.getPizza("CheeseAndTomato"));
        pizzaList.add(pizzaOven.getPizza("Pepperoni"));

        for (Pizza pizza : pizzaList){
            pizza.cookPizza();
        }

    }
}
