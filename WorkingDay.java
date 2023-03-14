import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class WorkingDay {
    // Set time of day
    LocalDateTime currentTime;
    DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd MMMM yyyy, hh:mm");

    //Check staff roll
    BarKeep jeremy = new BarKeep("Jeremy", 22, true, 4, true);
    BarKeep laura = new BarKeep("Laura", 24, false, 4, true);
    Chef brian = new Chef("Brian", 33, false, 10, true);
    Chef sarah = new Chef("Sarah", 41, true, 6, true);  
    Waiter steve = new Waiter("Steve", 30, true, 4, true);
    Waiter dave = new Waiter("Dave", 45, 0, true, "Sarah", "Anchovies");

    List<Worker> staffList = new ArrayList<>();

    boolean managementIn;

    // Mentally prepare for general public
    Customers customers = new Customers();

    // Fire-up anxiety
    Stress stress = Stress.getInstance();

    public void staffArrive(){
        // Staff clock-in
        currentTime = LocalDateTime.of(1985, 6, 25, 8, 00);

        staffList.add(jeremy);
        staffList.add(laura);
        staffList.add(brian);
        staffList.add(sarah);
        staffList.add(dave);
        staffList.add(steve);

        // Is anyone off sick?
        staffOffSick();

        // Is management in?
        isManagementIn();
        if (managementIn){
            for (Worker worker : staffList){
                worker.attendMeeting();
            }
        } managementIn = false;
    }
    
    public void morningShift(){
        // Doors open, morning shift
        currentTime = currentTime.plusHours(1);

        //Is management in?
        isManagementIn();

        serveCustomers(); 

        managementIn = false;
    }

    public void lunchShift(){
        // Lunch
        currentTime = currentTime.plusHours(3);

        //Is management in?
        isManagementIn();

        serveCustomers();

        managementIn = false;
    }

    public void afternoonShift(){
        // Afternoon
        currentTime = currentTime.plusHours(2);

        //Is management in?
        isManagementIn();

        serveCustomers();
     
        // Run end of day figures
        endOfDay();
    }

    public void serveCustomers(){
        // Get how many groups of customers 
        int groups = ThreadLocalRandom.current().nextInt(5, 11);

        // Serve Customers
        for (int i = 0; i <= groups; i++){
            List<String> foodOrder = customers.getFoodOrder();
            List<String> drinkOrder = customers.getDrinksOrder();

            for (String order : foodOrder){
                Waiter waiter = ThreadLocalRandom.current().nextInt(0, 2) == 0 ? dave : steve;
                Chef chef = ThreadLocalRandom.current().nextInt(0, 2) == 0 ?  brian :  sarah;
                if (!dave.getIsHealthy()) waiter = steve;
                else if (!steve.getIsHealthy()) waiter = dave;
                if(!brian.getIsHealthy()) chef = sarah;
                else if (!sarah.getIsHealthy()) chef = brian;
                waiter.serveFood(chef.cookFood(order));
                if (managementIn) stress.addSmileInteraction(waiter.getName() + Staff.smile());
            }
    
            for (String order : drinkOrder){
                Waiter waiter = ThreadLocalRandom.current().nextInt(0, 2) == 0 ? dave : steve;
                BarKeep barKeep = ThreadLocalRandom.current().nextInt(0, 2) == 0 ? jeremy : laura;
                if (!dave.getIsHealthy()) waiter = steve;
                else if (!steve.getIsHealthy()) waiter = dave;
                if (!jeremy.getIsHealthy()) barKeep = laura;
                else if (!laura.getIsHealthy()) barKeep = jeremy;
                waiter.serveDrink(barKeep.makeDrink(order));
                if (managementIn) stress.addSmileInteraction(waiter.getName() + Staff.smile());
            }
        }
    }

    public void staffOffSick(){
        Worker possibleSickWorker = staffList.get(ThreadLocalRandom.current().nextInt(0, staffList.size() -1));
        int isSick = ThreadLocalRandom.current().nextInt(0, 4);
        if (isSick == 3) {
            possibleSickWorker.setIsHealthy(false);  
            stress.setSickWorker(possibleSickWorker.getName());
        }
    }

    public void isManagementIn(){
        int possible = ThreadLocalRandom.current().nextInt(0, 5);
        if (possible == 4) managementIn = true;
    }

    public void endOfDay(){
        stress.getStaffList(staffList);
        stress.logStaffInteractions();
        stress.logFoodAndDrinkInteractions();
        stress.percentageServed();
        stress.staffPercentages();
        stress.assignStaffPoints();
        stress.assignFoodLikes();
        stress.logSmileInteractions();
        stress.howDidDavesDayGo();
    }
}
