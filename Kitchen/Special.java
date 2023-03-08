package Kitchen;

public class Special extends Pizza {
    @Override
    public void cookPizza(){
        System.out.println("Special pizza cooked.");
    };
    
    @Override
    public String toString(){
        return "Special";
    }
}
