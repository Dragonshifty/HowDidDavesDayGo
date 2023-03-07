import Oven.Pizza;
import Oven.PizzaOven;
public class Chef extends Worker implements Staff{
     
    public Chef(String name, int age, double likeability, int yearsExperience){
        super(name, age, likeability, yearsExperience);
    }

    public Pizza cookFood(String flavour){
        PizzaOven oven = PizzaOven.INSTANCE;
        Stress.addInteraction(super.getName() + " cooked.");
        return oven.getPizza(flavour);
    }

    public void attendMeeting(){
        System.out.println(super.getName() + " attends meeting");
    }
    
}
