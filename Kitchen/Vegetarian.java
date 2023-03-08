package Kitchen;

public class Vegetarian extends Pizza {
    @Override
    public void cookPizza(){
        System.out.println("Vegetarian pizza cooked.");
    };
    
    @Override
    public String toString(){
        return "Vegetarian";
    }
}
