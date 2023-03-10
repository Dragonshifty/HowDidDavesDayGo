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
        Stress stress = Stress.getInstance();
        stress.addFoodInteraction(super.getName() + " served " + pizza);
        // System.out.println(super.getName() + " serves " + pizza);
        // callBack.run();
    }

    public void serveDrink(Cocktail cocktail) {
        Stress stress = Stress.getInstance();
        stress.addDrinkInteraction(super.getName() + " served " + cocktail);
        // System.out.println(super.getName() + " serves " + cocktail);
    }

    public void attendMeeting(){
        System.out.println(super.getName() + " attends meeting");
    }
}


