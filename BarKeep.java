import Bar.Cocktail;
import Bar.DrinkList;

public class BarKeep extends Worker implements Staff {

    public BarKeep (String name, int age, boolean likeable, int yearsExperience, boolean isHealthy){
        super(name, age, likeable, yearsExperience, isHealthy);
    }

    public Cocktail makeDrink(String cocktail){
        DrinkList drinkList = DrinkList.INSTANCE;
        Stress stress = Stress.getInstance();
        stress.addDrinkInteraction(super.getName() + " prepared.");
        return drinkList.getCocktail(cocktail);
    }

    public void attendMeeting(){
        // System.out.println(super.getName() + " attends meeting");
    }
}
