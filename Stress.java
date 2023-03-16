import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
public class Stress {
    
    private List<String> foodInteractions = new ArrayList<>(); 
    private List<String> drinkInteractions = new ArrayList<>(); 
    private List<String> smileInteractions = new ArrayList<>();

    private static HashMap<String, Integer> staffInteractionsCount = new HashMap<>();
    private static HashMap<String, Integer> foodAndDrinkInteractionsCount = new HashMap<>();
    private static HashMap<String, Integer> daveToStaffPercentages = new HashMap<>();
    private List<Worker> staffList = new ArrayList<>();

    private String workerSick;

    private int score;
    
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

    public void addSmileInteraction(String action){
        smileInteractions.add(action);
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
            int staffInteractionsWithDave = (int)IntStream.range(0, allInteractions.size())
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

        return percentage;
    }

    public void staffPercentages(){
        // Percentage of interactions with staff members compared to the other waiter (Steve)
        
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
    }

    public void assignStaffPoints(){
        // Plus or minus for every point above/below 50 and wether staff member is likeable
       
        for (Worker worker: staffList){
            if (worker.getName().equals("Steve") | worker.getName().equals("Dave")) continue;

            int scoreTemp = 0;
            int percentageHold = daveToStaffPercentages.get(worker.getName());
            
            if (percentageHold != 0 && worker.getLikeable()){
                if (percentageHold > 50){
                    scoreTemp += percentageHold - 50;
                    // Double points for interactions with Sarah
                    if (worker.getName().equals("Sarah")) {
                        scoreTemp *= 2;
                        score += scoreTemp;
                    } else {
                        score += percentageHold - 50;
                    }
                } else {
                    scoreTemp -= 50 - percentageHold;
                    score -= 50 - percentageHold;
                }
            } else if (percentageHold != 0 && !worker.getLikeable()){
                if (percentageHold > 50){
                    scoreTemp -= percentageHold - 50;
                    score -= percentageHold - 50;
                } else {
                    scoreTemp += 50 - percentageHold;
                    score += 50 - percentageHold;
                }
            }
        }
    }

    public void assignFoodLikes(){
        // Plus or minus points based on vodka interactions (like) to anchovy interactions (dislike)

        int foodScore = foodAndDrinkInteractionsCount.get("Vodka")- 
        foodAndDrinkInteractionsCount.get("Anchovies");

        score += foodScore;
    }

    public void logSmileInteractions() {
        // Management in for the session
        // Minus points if Dave has to smile more than the other waiter
        if (!smileInteractions.isEmpty()){
            int count = (int) smileInteractions.stream()
            .filter(x -> x.startsWith("Dave"))
            .count();
            
            int percentage = (int) Math.round(((double) count / smileInteractions.size()) * 100);
            int scoreTemp = (percentage > 50) ? (50 - percentage) : 0;

            score += scoreTemp;
        }
    }

    public void howDidDavesDayGo(){
        System.out.println("Final score: " + score);
        for (Worker worker : staffList){
            if (!worker.getIsHealthy()) System.out.println(worker.getName() + " was off ill today.");
        }
        if (score > 0) System.out.println("Dave had a good day!");
        if (score <= 0) System.out.println("Dave had a bad day!");
    }
}