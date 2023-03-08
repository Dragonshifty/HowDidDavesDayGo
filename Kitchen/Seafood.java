package Kitchen;

public class Seafood extends Pizza{
    @Override
    public void cookPizza(){
        System.out.println("Seafood pizza cooked.");
    };
    
    @Override
    public String toString(){
        return "Seafood";
    } 
}
