package Kitchen;

public class Ingredient {
    private int quantity = 30;

    private static volatile Ingredient instance;
    public static Ingredient getInstance() {
        if (instance == null){
            synchronized(Ingredient.class){
                if (instance == null){
                instance = new Ingredient();
                }
            }
        }
    return instance;
    }

    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity += quantity;
    }
}
