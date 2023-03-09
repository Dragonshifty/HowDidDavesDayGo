import Bar.CocktailBuilder;
import Bar.Cocktail;
import Bar.DrinkList;
import Kitchen.Pizza;
import Kitchen.PizzaOven;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.ArrayList;
import java.util.Arrays;
public class App {


    public static void main(String[] args) throws Exception {

        BarKeep jeremy = new BarKeep("Jeremy", 22, 5.3, 4);
        BarKeep laura = new BarKeep("Laura", 24, 4, 4);
        Chef brian = new Chef("Brian", 33, 2.3, 10);
        Chef sarah = new Chef("Sarah", 41, 7.3, 6);
        Waiter dave = new Waiter("Dave", 45, 5, 0, "Sarah", "Anchovies");
        Waiter steve = new Waiter("Steve", 30, 6, 4);

        List<Worker> staffList = new ArrayList<>();
        staffList.add(jeremy);
        staffList.add(laura);
        staffList.add(brian);
        staffList.add(sarah);
        staffList.add(dave);
        staffList.add(steve);
    
        Stress stress = new Stress();

        stress.getStaffList(staffList);

        Customers customers = new Customers();

        List<String> foodOrder = customers.getFoodOrder();
        List<String> drinkOrder = customers.getDrinksOrder();

        // ExecutorService executor = Executors.newFixedThreadPool(4);

        // for (int i = 0; i < foodOrder.size(); i++){
        //     Waiter waiter = ThreadLocalRandom.current().nextInt(0, 2) == 0 ? dave : steve;
        //     Chef chef = ThreadLocalRandom.current().nextInt(0, 2) == 0 ?  brian :  sarah;
        //     String pizza = foodOrder.get(i);
        //     executor.submit(() -> waiter.serveFood(chef.cookFood(pizza)));
        // }

        // for (int i = 0; i < foodOrder.size(); i++){
        //     Waiter waiter = ThreadLocalRandom.current().nextInt(0, 2) == 0 ? dave : steve;
        //     Chef chef = ThreadLocalRandom.current().nextInt(0, 2) == 0 ?  brian :  sarah;
        //     executor.submit(() -> {
        //         Pizza pizza = chef.cookFood(foodOrder.get(i));
        //         waiter.serveFood(pizza, () ->
        //         Stress.addFoodInteraction(waiter.getName() + " served " + pizza));
        //     }
        //     );
        // }

        // executor.shutdown();

        for (String order : foodOrder){
            Waiter waiter = ThreadLocalRandom.current().nextInt(0, 2) == 0 ? dave : steve;
            Chef chef = ThreadLocalRandom.current().nextInt(0, 2) == 0 ?  brian :  sarah;
            waiter.serveFood(chef.cookFood(order));
        }

        for (String order : drinkOrder){
            Waiter waiter = ThreadLocalRandom.current().nextInt(0, 2) == 0 ? dave : steve;
            BarKeep barKeep = ThreadLocalRandom.current().nextInt(0, 2) == 0 ? jeremy : laura;
            waiter.serveDrink(barKeep.makeDrink(order));
        }

        stress.checkStress();
        // Stress.checkFoodDislikes();
        stress.staffInteractions();
        stress.checkDrinkInteractions();
    }
}
