public class Kitchen extends Stores {

    public String pepperoniPizza(String size){
        int toppingsAmount = size=="small" ? 1 : 2;
        setBread(-toppingsAmount);
        setCheese(-toppingsAmount);
        setTomato(-toppingsAmount);
        setPepperoni(-toppingsAmount);
        System.out.println("Pepperoni pizza ready");
        String food = "Pepperoni pizza";
        return food;
    }

    public String hamPizza(String size){
        int toppingsAmount = size=="small" ? 1 : 2;
        setBread(-toppingsAmount);
        setCheese(-toppingsAmount);
        setTomato(-toppingsAmount);
        setHam(-toppingsAmount);
        setPeppers(-toppingsAmount);
        System.out.println("Ham pizza ready");
        return "Ham pizza";
    }
}
