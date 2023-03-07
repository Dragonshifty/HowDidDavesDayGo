import Oven.PizzaOven;
import Oven.Pizza;
import Bar.CocktailBuilder;
import Bar.Cocktail;
import Bar.DrinkList;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
public class App {
    public static void main(String[] args) throws Exception {

        BarKeep jeremy = new BarKeep("Jeremy", 22, 5.3, 4);
        Waiter dave = new Waiter("Dave", 45, 5, 0);
        Chef brian = new Chef("Brian", 33, 2.3, 10);

        List<String> foodMenu = Arrays.asList(
            "Cheese and Tomato",
            "Pepperoni",
            "Hawaiian",
            "Pepperoni"
        );

        List<String> drinksMenu = Arrays.asList(
            "Mojito",
            "Espresso Martini"
        );

        dave.serveDrink(jeremy.makeDrink("Mojito"));
        dave.serveFood(brian.cookFood("Cheese And Tomato"));

        Stress.listInteractions();
    }
}
