import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
public class Stress {
    
    private List<String> foodInteractions = new ArrayList<>(); 
    private List<String> drinkInteractions = new ArrayList<>(); 

    private static HashMap<String, Integer> staffInteractionsCount = new HashMap<>();
    private static HashMap<String, Integer> foodAndDrinkInteractionsCount = new HashMap<>();
    private static HashMap<String, Integer> daveToStaffPercentages = new HashMap<>();
    private List<Worker> staffList = new ArrayList<>();

    private String workerSick;
    
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
        
        daveToStaffPercentages.put("Brian", 0);
        daveToStaffPercentages.put("Sarah", 0);
        daveToStaffPercentages.put("Jeremy", 0);
        daveToStaffPercentages.put("Laura", 0);

        foodAndDrinkInteractionsCount.put("Anchovies", 0);
        foodAndDrinkInteractionsCount.put("Vodka", 0);
    }

    public String getSickWorker(){
        return workerSick;
    }

    public void setSickWorker(String worker){
        this.workerSick = worker;
    }

    public void getStaffList(List<Worker> staffList){
        this.staffList = staffList;
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
        .filter(x -> x.startsWith("Dave"))
        .filter(x -> x.contains("Vodka"))
        .count();
        count += foodAndDrinkInteractionsCount.get("Vodka");
        foodAndDrinkInteractionsCount.put("Vodka", count);

        // drinkInteractions.stream()
        // .filter(x -> x.startsWith("Dave"))
        // .filter(x -> x.contains("Vodka"))
        // .forEach(System.out::println);

        int count2 = (int)foodInteractions.stream()
        .filter(x -> x.startsWith("Dave"))
        .filter(x -> x.endsWith("Special") | x.endsWith("Seafood"))
        .count();
        count2 += foodAndDrinkInteractionsCount.get("Anchovies");
        foodAndDrinkInteractionsCount.put("Anchovies", count2);
    }
    
    public void logStaffInteractions(){
        List<String> allInteractions = Stream.concat(foodInteractions.stream(), 
        drinkInteractions.stream())
        .collect(Collectors.toList());

        for (String worker : staffInteractionsCount.keySet()){
            int staffInteractionsWithDave = (int)IntStream.range(0, allInteractions.size() -1)
            .filter(x -> allInteractions.get(x)
            .startsWith(worker) && allInteractions.get(x + 1)
            .startsWith("Dave"))
            .count();

            int previousFoodAndDrinksCount = staffInteractionsCount.getOrDefault(worker, 0);
            staffInteractionsCount.replace(worker, previousFoodAndDrinksCount + staffInteractionsWithDave);
        }
    }

    public long percentageServed(){
        List<String> allInteractions = Stream.concat(foodInteractions.stream(), drinkInteractions.stream())
        .collect(Collectors.toList());

        int totalInteractions = allInteractions.size() / 2;

        long daveServed = allInteractions.stream()
        .filter(x -> x.startsWith("Dave"))
        .count();
        long percentage = Math.round(((double)daveServed / totalInteractions) * 100);

        // System.out.println("Total order: " + totalInteractions + "\nDave served: " + daveServed 
        // + "\nPercentage: " + percentage);
        return percentage;
    }

    public void sarahInteractions(){
        long totalFoodServed = foodInteractions.size() / 2;

        long sarahCooked = foodInteractions.stream()
        .filter(x -> x.contains("Sarah"))
        .count();

        long sarahCookedDaveServed = staffInteractionsCount.get("Sarah");

        long percentageOfSarahInteractions = Math.round(((double)sarahCookedDaveServed / sarahCooked) * 100);

        System.out.println("Order size: " + totalFoodServed + "\nSarah cooked: " + sarahCooked
        + "\nPercentage with Dave: " + percentageOfSarahInteractions);
        System.out.println(workerSick);
    }

    public void staffPercentages(){
        long totalFoodServed = foodInteractions.size() / 2;
        long totalDrinkServed = drinkInteractions.size() / 2;
        
        for (String worker : daveToStaffPercentages.keySet()){
            int totalFoodWorked = (int) foodInteractions.stream()
            .filter(x -> x.startsWith(worker))
            .count();
            int totalDrinkWorked = (int) drinkInteractions.stream()
            .filter(x -> x.startsWith(worker))
            .count();

            if (totalFoodWorked != 0){
                int percentage = (int) Math.round(((double) staffInteractionsCount.get(worker) / totalFoodWorked) * 100);
                daveToStaffPercentages.replace(worker, percentage);
            }
            if (totalDrinkWorked != 0){
                int percentage = (int) Math.round(((double) staffInteractionsCount.get(worker) / totalDrinkWorked) * 100);
                daveToStaffPercentages.replace(worker, percentage);
            }
            totalFoodWorked = 0;
            totalDrinkWorked = 0;
        }
        daveToStaffPercentages.entrySet().stream()
        .map(x -> x.getKey() + " " + x.getValue())
        .forEach(System.out::println);
    }

    public void runNumbers(){
        for (Worker worker : staffList){
            if ("Steve".equals(worker.getName()) | "Dave".equals(worker.getName())) continue;
            System.out.println(worker.getName() + " " + daveToStaffPercentages.get(worker.getName()) * worker.getLikeability());
        }
    }
}
