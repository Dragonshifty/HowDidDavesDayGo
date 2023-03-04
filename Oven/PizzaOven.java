package Oven;
public enum PizzaOven {
    INSTANCE;

    public Pizza getPizza(String flavour){
        if (flavour != null){
            switch(flavour){
                case "CheeseAndTomato":
                    return new CheeseAndTomato();
                case "Pepperoni":
                    return new Pepperoni();
            }
        }
        return null;
    }
}
