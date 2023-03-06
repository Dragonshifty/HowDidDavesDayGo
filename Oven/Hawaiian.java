package Oven;

public class Hawaiian extends Pizza {
    @Override
    public void cookPizza(){
        System.out.println("Hawaiian pizza cooked.");
    };
    
    @Override
    public String toString(){
        return "Hawaiian";
    }
}
