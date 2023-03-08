import Bar.Cocktail;
import Kitchen.Pizza;
public class Waiter extends Worker implements Serve, Staff{

    public Waiter (String name, int age, double likeability, int yearsExperience){
        super(name, age, likeability, yearsExperience);
    }

    public Waiter (String name, int age, double likeability, int yearsExperience, String likes, String hates){
        super(name, age, likeability, yearsExperience, likes, hates);
    }

    public void serveFood(Pizza pizza){ 
        Stress.addInteraction(super.getName() + " served " + pizza);
        // System.out.println(super.getName() + " serves " + pizza);
    }

    public void serveDrink(Cocktail cocktail) {
        Stress.addInteraction(super.getName() + " served " + cocktail);
        // System.out.println(super.getName() + " serves " + cocktail);
    }

    public void attendMeeting(){
        System.out.println(super.getName() + " attends meeting");
    }


}


