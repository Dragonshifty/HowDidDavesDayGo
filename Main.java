import java.util.ArrayList;
import java.util.List;
import java.time.*;
import java.time.format.DateTimeFormatter;

public class Main {

    private List<Worker> staffList = new ArrayList<>();
    private List<Waiter> frontOfHouse = new ArrayList<>();;
    private List<Chef> kitchenStaff = new ArrayList<>();;

    public void callMeeting(List<Worker> staffList){
        for (Worker worker : staffList){
            worker.attendMeeting();
            // System.out.println(worker);
        }
        System.out.println();
    }

    public void serveCustomers(String food){
        for(Waiter worker : frontOfHouse){
            worker.serveFood(food);
        }
        System.out.println();
    } 
    public static void main(String[] args){

        Main main = new Main();
        Stores kitchen = new Kitchen();

        Waiter james = new Waiter("James", 45, 1.0, 1);
        Waiter bob = new Waiter("Bob", 33, 1.3, 2);

        Chef steve = new Chef("Steve", 42, 1.8, 4);
        Chef jane = new Chef("Jane", 38, 1.9, 2);
        
        main.staffList.add(james);
        main.staffList.add(bob);
        main.staffList.add(steve);
        main.staffList.add(jane);

        main.frontOfHouse.add(james);
        main.frontOfHouse.add(bob);

        main.kitchenStaff.add(steve);
        main.kitchenStaff.add(jane);

        main.callMeeting(main.staffList);
        main.serveCustomers(kitchen.pepperoniPizza("small"));

    }
}