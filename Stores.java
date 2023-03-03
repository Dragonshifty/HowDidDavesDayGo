import java.util.ArrayList;
import java.util.List;

public abstract class Stores {
    private Integer bread = 30;
    private Integer tomato = 30;
    private Integer cheese = 30;
    private Integer ham = 30;
    private Integer peppers = 30;
    private Integer pepperoni = 30;
    private Integer olives = 30;
    private Integer sweetcorn = 30;

    public Stores() {
        List<Integer> allStores = new ArrayList<>();
        allStores.add(bread);
        allStores.add(tomato);
        allStores.add(cheese);
        allStores.add(ham);
        allStores.add(peppers);
        allStores.add(pepperoni);
        allStores.add(olives);
        allStores.add(sweetcorn);
    }

    public void replenishAll(){
        bread = 30;
        tomato = 30;
        cheese = 30;
        ham = 30;
        peppers = 30;
        pepperoni = 30;
        olives = 30;
        sweetcorn = 30;
    }

    public Integer getBread() {
        return bread;
    }
    public void setBread(int amount) {
        bread += amount;
    }
    public Integer getTomato() {
        return tomato;
    }
    public void setTomato(int amount) {
        tomato += amount;
    }
    public Integer getCheese() {
        return cheese;
    }
    public void setCheese(int amount) {
        cheese += amount;
    }
    public Integer getHam() {
        return ham;
    }
    public void setHam(int amount) {
        ham += amount;
    }
    public Integer getPeppers() {
        return peppers;
    }
    public void setPeppers(int amount) {
        peppers += amount;
    }
    public Integer getPepperoni() {
        return pepperoni;
    }
    public void setPepperoni(int amount) {
        pepperoni += amount;
    }
    public Integer getOlives() {
        return olives;
    }
    public void setOlives(int amount) {
        olives += amount;
    }
    public Integer getSweetcorn() {
        return sweetcorn;
    }
    public void setSweetcorn(int amount) {
        sweetcorn += amount;
    }

    public abstract String pepperoniPizza(String size);
    public abstract String hamPizza(String size);
}
