import Bar.CocktailBuilder;
import Bar.Cocktail;
import Bar.DrinkList;
import Kitchen.Pizza;
import Kitchen.PizzaOven;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
public class App {


    public static void main(String[] args) throws Exception {

        BarKeep jeremy = new BarKeep("Jeremy", 22, 5.3, 4);
        BarKeep laura = new BarKeep("Laura", 24, 4, 4);
        Chef brian = new Chef("Brian", 33, 2.3, 10);
        Chef sarah = new Chef("Sarah", 41, 7.3, 6);
        Waiter dave = new Waiter("Dave", 45, 5, 0, "Sarah", "Anchovies");

        List<Worker> staffList = new ArrayList<>();
        staffList.add(jeremy);
        staffList.add(laura);
        staffList.add(brian);
        staffList.add(sarah);
        staffList.add(dave);
    
        Stress.getStaffList(staffList);

        Customers customers = new Customers();

        List<String> foodOrder = customers.getFoodOrder();
        List<String> drinkOrder = customers.getDrinksOrder();

        for (String order : foodOrder){
            dave.serveFood(brian.cookFood(order));
        }

        for (String order : drinkOrder){
            dave.serveDrink(jeremy.makeDrink(order));
        }


        // dave.serveDrink(jeremy.makeDrink("Mojito"));
        // dave.serveFood(brian.cookFood("Cheese And Tomato"));

        Stress.listInteractions();
        Stress.checkDislikes();
    }
}
