import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class WorkingDay {
    // Set time of day
    LocalDateTime workDayStart;
    DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd MMMM yyyy, hh:mm");

    //Check staff roll
    BarKeep jeremy = new BarKeep("Jeremy", 22, 5.3, 4);
    BarKeep laura = new BarKeep("Laura", 24, 4, 4);
    Chef brian = new Chef("Brian", 33, 2.3, 10);
    Chef sarah = new Chef("Sarah", 41, 7.3, 6);
    Waiter dave = new Waiter("Dave", 45, 5, 0, "Sarah", "Anchovies");
    Waiter steve = new Waiter("Steve", 30, 6, 4);

    boolean jeremyOffSick;
    boolean lauraOffSick;
    boolean brianOffSick;
    boolean sarahOffSick;
    boolean steveOffSick;

    List<Worker> staffList = new ArrayList<>();

    // Mentally prepare for general public
    Customers customers = new Customers();

    // Fire-up anxiety
    Stress stress = Stress.getInstance();

    public void staffArrive(){
        // Staff clock-in
        workDayStart = LocalDateTime.of(1985, 6, 25, 8, 00);

        staffList.add(jeremy);
        staffList.add(laura);
        staffList.add(brian);
        staffList.add(sarah);
        staffList.add(dave);
        staffList.add(steve);
    }
    
    public void morningShift(){
        // Doors open
        LocalDateTime openingTime = workDayStart.plusHours(1);

        // Get how many groups of customers 
        int groups = ThreadLocalRandom.current().nextInt(5, 11);

        // Serve Customers
        for (int i = 0; i <= groups; i++){
            List<String> foodOrder = customers.getFoodOrder();
            List<String> drinkOrder = customers.getDrinksOrder();

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
        }
        stress.logStaffInteractions();
        stress.logFoodAndDrinkInteractions();
        stress.showFoodAndDrinkInteractions();
        stress.showStaffInteractions();
    }

    public void lunchShift(){
        // Lunch
        LocalDateTime lunchTime = workDayStart.plusHours(3);

        // Get how many groups of customers 
        int groups = ThreadLocalRandom.current().nextInt(5, 11);

        // Serve Customers
        for (int i = 0; i <= groups; i++){
            List<String> foodOrder = customers.getFoodOrder();
            List<String> drinkOrder = customers.getDrinksOrder();

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
        }
        stress.logStaffInteractions();
        stress.logFoodAndDrinkInteractions();
        stress.showFoodAndDrinkInteractions();
        stress.showStaffInteractions();
    }

    public void afternoonShift(){

    }
}
