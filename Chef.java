import Kitchen.Pizza;
import Kitchen.PizzaOven;
public class Chef extends Worker implements Staff{
     
    public Chef(String name, int age, double likeability, int yearsExperience, boolean isHealthy){
        super(name, age, likeability, yearsExperience, isHealthy);
    }

    public Pizza cookFood(String flavour){
        PizzaOven oven = PizzaOven.INSTANCE;
        Stress stress = Stress.getInstance();
        stress.addFoodInteraction(super.getName() + " cooked.");
        return oven.getPizza(flavour);
    }

    public void attendMeeting(){
        System.out.println(super.getName() + " attends meeting");
    }
    
}
