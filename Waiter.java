import Oven.Pizza;
import Bar.Cocktail;
public class Waiter extends Worker implements Serve, Staff{

    public Waiter (String name, int age, double likeability, int yearsExperience){
        super(name, age, likeability, yearsExperience);
    }

    public void serveFood(Pizza pizza){ 
        Stress.addInteraction(super.getName() + " served " + pizza);
        // System.out.println(super.getName() + " serves " + pizza);
    }

    public void serveDrink(Cocktail cocktail) {
        Stress.addInteraction(getName() + " served " + cocktail);
        // System.out.println(super.getName() + " serves " + cocktail);
    }

    public void attendMeeting(){
        System.out.println(super.getName() + " attends meeting");
    }
}


