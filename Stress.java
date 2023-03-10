import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.IntStream;
public class Stress {
    
    private List<String> foodInteractions = new ArrayList<>(); 
    private List<String> drinkInteractions = new ArrayList<>(); 

    private static HashMap<String, Integer> staffInteractionsCount = new HashMap<>();
    private static HashMap<String, Integer> foodAndDrinkInteractionsCount = new HashMap<>();
    
    private Stress(){};

    private static volatile Stress instance;
    public static Stress getInstance() {
        if (instance == null){
            synchronized(Stress.class){
                if (instance == null){
                instance = new Stress();
                }
            }
        }
    return instance;
    }

    static{
        staffInteractionsCount.put("Brian", 0);
        staffInteractionsCount.put("Sarah", 0);
        staffInteractionsCount.put("Jeremy", 0);
        staffInteractionsCount.put("Laura", 0);
        // staffInteractionsCount.put("Steve", 0);

        foodAndDrinkInteractionsCount.put("Anchovies", 0);
        foodAndDrinkInteractionsCount.put("Vodka", 0);
    }
    
    public void addFoodInteraction(String action){
        foodInteractions.add(action);
    }

    public void addDrinkInteraction(String action){
        drinkInteractions.add(action);
    }

    public void checkStress(){
        for (String interaction : foodInteractions){
            System.out.println(interaction);
        }
        for (String interaction : drinkInteractions){
            System.out.println(interaction);
        }
    }

    public void showStaffInteractions(){
        staffInteractionsCount.entrySet().stream()
        .map(entry -> entry.getKey() + " : " + entry.getValue())
        .forEach(System.out::println);
    }

    public void showFoodAndDrinkInteractions(){
        foodAndDrinkInteractionsCount.entrySet().stream()
        .map(entry -> entry.getKey() + " : " + entry.getValue())
        .forEach(System.out::println);
    }

    public void logFoodAndDrinkInteractions(){
        int count = (int)drinkInteractions.stream()
        .filter(input -> input.startsWith("Dave"))
        .filter(input -> {
            int colonIndex = input.indexOf(":");
            if (colonIndex >= 0 && colonIndex < input.length() - 1) {
                String afterColon = input.substring(colonIndex + 1);
                return afterColon.contains("Vodka");
            }
            return false;
        })
        .count();
        count += foodAndDrinkInteractionsCount.get("Vodka");
        foodAndDrinkInteractionsCount.put("Vodka", count);

        int count2 = (int)foodInteractions.stream()
        .filter(x -> x.startsWith("Dave"))
        .filter(x -> x.endsWith("Special") | x.endsWith("Seafood"))
        .count();
        count2 += foodAndDrinkInteractionsCount.get("Anchovies");
        foodAndDrinkInteractionsCount.put("Anchovies", count2);
    }
    
    public void logStaffInteractions(){
        for (String worker : staffInteractionsCount.keySet()){
            int countFood = (int)IntStream.range(0, foodInteractions.size() - 1)
            .filter(x -> foodInteractions.get(x).startsWith(worker) &&
            foodInteractions.get(x + 1).startsWith("Dave"))
            .count();
            int previousFoodCount = staffInteractionsCount.getOrDefault(worker, 0);
            staffInteractionsCount.replace(worker, previousFoodCount + countFood);

            int countDrink = (int)IntStream.range(0, drinkInteractions.size() - 1)
            .filter(x -> drinkInteractions.get(x).startsWith(worker) &&
            drinkInteractions.get(x + 1).startsWith("Dave"))
            .count();

            int previousDrinkCount = staffInteractionsCount.getOrDefault(worker, 0);
            staffInteractionsCount.replace(worker, previousDrinkCount + countDrink);
        }
    }
}
