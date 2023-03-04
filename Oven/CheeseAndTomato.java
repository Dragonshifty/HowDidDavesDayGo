package Oven;

public class CheeseAndTomato extends Pizza {
    @Override
    public void cookPizza(){
        System.out.println("Cheese and Tomato pizza cooked.");
    };
    
    @Override
    public String toString(){
        return "Cheese and Tomato";
    }
}
