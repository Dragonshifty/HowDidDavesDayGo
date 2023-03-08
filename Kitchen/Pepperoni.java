package Kitchen;

public class Pepperoni extends Pizza {
    @Override
    public void cookPizza(){
        System.out.println("Pepperoni pizza cooked.");
    };
    
    @Override
    public String toString(){
        return "Pepperoni";
    }
}
