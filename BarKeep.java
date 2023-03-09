import Bar.Cocktail;
import Bar.DrinkList;

public class BarKeep extends Worker implements Staff {

    public BarKeep (String name, int age, double likeability, int yearsExperience){
        super(name, age, likeability, yearsExperience);
    }

    public Cocktail makeDrink(String cocktail){
        DrinkList drinkList = DrinkList.INSTANCE;
        Stress.addDrinkInteraction(super.getName() + " prepared.");
        return drinkList.getCocktail(cocktail);
    }

    public void attendMeeting(){
        System.out.println(super.getName() + " attends meeting");
    }
}
