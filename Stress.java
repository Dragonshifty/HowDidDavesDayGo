import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.IntStream;
public class Stress {
    
    private static List<String> foodInteractions = new ArrayList<>(); 
    private static List<String> drinkInteractions = new ArrayList<>(); 
    private List<Worker> staffList = new ArrayList<>();

    private HashMap<String, Integer> staffInteractionsCount = new HashMap<>();
    
    public Stress(){
        staffInteractionsCount.put("Brian", 0);
        staffInteractionsCount.put("Sarah", 0);
        staffInteractionsCount.put("Jeremy", 0);
        staffInteractionsCount.put("Laura", 0);
        staffInteractionsCount.put("Steve", 0);
    }
    
    public static void addFoodInteraction(String action){
        foodInteractions.add(action);
    }

    public static void addDrinkInteraction(String action){
        drinkInteractions.add(action);
    }

    public void getStaffList(List<Worker> staff){
        staffList = staff;
    }


    public void checkStress(){
        for (String interaction : foodInteractions){
            System.out.println(interaction);
        }
        for (String interaction : drinkInteractions){
            System.out.println(interaction);
        }
    }

    // public static void checkFoodDislikes(){
    //     long count = IntStream.range(0, foodInteractions.size() -1)
    //     .filter(x -> foodInteractions.get(x).startsWith("Dave") &&
    //     Arrays.stream(foodInteractions.get(x + 1).split(":")[1].split(","))
    //     .map(String::trim)
    //     .anyMatch("Special"::equals))
    //     .count();

        // long count = IntStream.range(0, foodInteractions.size() -1)
        // .filter(x -> foodInteractions.get(x).startsWith("Dave") ) &&
        // Arrays.stream(foodInteractions.get(x + 1)).split(" ")
        // .map(String::trim)
        // .anyMatch("Seafood")
        // .count();

        // int count = (int)IntStream.range(0, foodInteractions.size() - 1)
        // .filter(x -> foodInteractions.get(x).startsWith("Brian") &&
        // foodInteractions.get(x + 1).startsWith("Dave"))
        // .count();

        // System.out.println(count);
    // }

    public void checkDrinkInteractions(){
        // long count = drinkInteractions.stream()
        // .flatMap(drinkeInterations -> Arrays.stream(drinkInterations.split("\\s+")))
        // .filter(x -> x.startsWith("Dave"))
        // .filter(x -> x.substring(x.indexOf(":") +1))
        // .replaceAll(",", "")
        // .contains("Vodka")
        // .count();
        long count = drinkInteractions.stream()
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
        System.out.println(count);

        int count1 = (int)foodInteractions.stream()
        .filter(x -> x.startsWith("Dave"))
        .filter(x -> x.endsWith("Special"))
        .count();
        System.out.println(count1);
    }
    

    public void staffInteractions(){
        for (String worker : staffInteractionsCount.keySet()){
            int countFood = (int)IntStream.range(0, foodInteractions.size() - 1)
            .filter(x -> foodInteractions.get(x).startsWith(worker) &&
            foodInteractions.get(x + 1).startsWith("Dave"))
            .count();
            if (countFood > staffInteractionsCount.get(worker))
            staffInteractionsCount.replace(worker, countFood);

            int countDrink = (int)IntStream.range(0, drinkInteractions.size() - 1)
            .filter(x -> drinkInteractions.get(x).startsWith(worker) &&
            drinkInteractions.get(x + 1).startsWith("Dave"))
            .count();
            if (countDrink > staffInteractionsCount.get(worker))
            staffInteractionsCount.replace(worker, countDrink);
        }

        staffInteractionsCount.forEach((k, v) -> System.out.println(k + " : " + v));

        

        // interactionWithBrian = (int)IntStream.range(0, foodInteractions.size() - 1)
        // .filter(x -> foodInteractions.get(x).startsWith("Brian") &&
        // foodInteractions.get(x + 1).startsWith("Dave"))
        // .count();

        // interactionWithSarah = (int)IntStream.range(0, foodInteractions.size() - 1)
        // .filter(x -> foodInteractions.get(x).startsWith("Sarah") &&
        // foodInteractions.get(x + 1).startsWith("Dave"))
        // .count();

        // interactionWithJeremy = (int)IntStream.range(0, drinkInteractions.size() - 1)
        // .filter(x -> drinkInteractions.get(x).startsWith("Jeremy") &&
        // foodInteractions.get(x + 1).startsWith("Dave"))
        // .count();

        // interactionWithLaura = (int)IntStream.range(0, drinkInteractions.size() - 1)
        // .filter(x -> drinkInteractions.get(x).startsWith("Laura") &&
        // foodInteractions.get(x + 1).startsWith("Dave"))
        // .count();
    }


}
