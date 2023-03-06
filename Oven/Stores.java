package Oven;
import java.util.ArrayList;
import java.util.List;

public enum Stores {
    INSTANCE;

    private Ingredient bread = new Ingredient();
    private Ingredient tomato = new Ingredient();
    private Ingredient cheese = new Ingredient();
    private Ingredient ham = new Ingredient();
    private Ingredient peppers = new Ingredient();
    private Ingredient pepperoni = new Ingredient();
    private Ingredient olives = new Ingredient();
    private Ingredient sweetcorn = new Ingredient();
    private Ingredient pineapple = new Ingredient();

    private List<Ingredient> allStores = new ArrayList<>();

    private Stores() {
        allStores.add(bread);
        allStores.add(tomato);
        allStores.add(cheese);
        allStores.add(ham);
        allStores.add(peppers);
        allStores.add(pepperoni);
        allStores.add(olives);
        allStores.add(sweetcorn);
        allStores.add(pineapple);
    }

    public void replenishAll(){
        for (Ingredient ingredient : allStores){
            ingredient.setQuantity(30);
        }
    }

    public int getBread() {
        return bread.getQuantity();
    }
    public void setBread(int amount) {
        bread.setQuantity(amount);
    }
    public int getTomato() {
        return tomato.getQuantity();
    }
    public void setTomato(int amount) {
        tomato.setQuantity(amount);
    }
    public int getCheese() {
        return cheese.getQuantity();
    }
    public void setCheese(int amount) {
        cheese.setQuantity(amount);
    }
    public int getHam() {
        return ham.getQuantity();
    }
    public void setHam(int amount) {
        ham.setQuantity(amount);
    }
    public int getPeppers() {
        return peppers.getQuantity();
    }
    public void setPeppers(int amount) {
        peppers.setQuantity(amount);
    }
    public int getPepperoni() {
        return pepperoni.getQuantity();
    }
    public void setPepperoni(int amount) {
        pepperoni.setQuantity(amount);
    }
    public int getOlives() {
        return olives.getQuantity();
    }
    public void setOlives(int amount) {
        olives.setQuantity(amount);
    }
    public int getSweetcorn() {
        return sweetcorn.getQuantity();
    }
    public void setSweetcorn(int amount) {
        sweetcorn.setQuantity(amount);
    }

    public int getPineapple(){
        return pineapple.getQuantity();
    }

    public void setPineapple(int amount){
        pineapple.setQuantity(amount);
    }

    public void pizzaBase(int amount){
        bread.setQuantity(amount);
        cheese.setQuantity(amount);
        tomato.setQuantity(amount);
    }

    public void checkStoresLevel(){
        List<Integer> indexes = new ArrayList<>();
        int indexCount = 0;
        boolean fullRestock = false;
        for (Ingredient ingredient : allStores){
            if (ingredient.getQuantity() < 5){
                indexes.add(indexCount);
                indexCount++;
            }
        }

    }
}
