import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Customers {
    private List<String> foodMenu = Arrays.asList(
            "Cheese and Tomato",
            "Pepperoni",
            "Hawaiian",
            "Pepperoni",
            "Special", 
            "Seafood"
        );

    private List<String> drinksMenu = Arrays.asList(
        "Mojito",
        "Espresso Martini",
        "Shirley Temple",
        "Long Island Iced Tea",
        "Screwdriver",
        "Singapore Sling",
        "Woo Woo",
        "Strawberry Daiquiri",
        "Dark and Stormy",
        "Negroni",
        "Ginger Appletini"
    );

    int foodMenuSize = foodMenu.size();
    int drinksMenuSize = drinksMenu.size();

    public List<String> getFoodOrder(){
        List<String> foodOrder = new ArrayList<>();
        int partyNumber = ThreadLocalRandom.current().nextInt(0, 11);
        for (int i = 0; i <= partyNumber; i++){
            int menuChoice = ThreadLocalRandom.current().nextInt(0, foodMenuSize);
            foodOrder.add(foodMenu.get(menuChoice));
        }
        return foodOrder;
    }

    public List<String> getDrinksOrder(){
        List<String> drinksOrder = new ArrayList<>();
        int partyNumber = ThreadLocalRandom.current().nextInt(0, 11);
        for (int i = 0; i <= partyNumber; i++){
            int menuChoice = ThreadLocalRandom.current().nextInt(0, drinksMenuSize);
            drinksOrder.add(drinksMenu.get(menuChoice));
        }
        return drinksOrder;
    }
}
