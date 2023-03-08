package Kitchen;
public enum PizzaOven {
    INSTANCE;

    Stores stores = Stores.INSTANCE;

    public Pizza getPizza(String flavour){
        if (flavour != null){
            switch(flavour){
                case "Cheese and Tomato":
                    stores.pizzaBase(-1);
                    return new CheeseAndTomato();
                case "Pepperoni":
                    stores.pizzaBase(1);
                    stores.setPepperoni(-3);
                    return new Pepperoni();
                case "Hawaiian":
                    stores.pizzaBase(-1);
                    stores.setHam(-1);
                    stores.setPineapple(-1);
                    return new Hawaiian();
                case "Vegetarian":
                    stores.pizzaBase(-1);
                    stores.setPeppers(-1);
                    stores.setOlives(-1);
                    stores.setSweetcorn(-1);
                    return new Vegetarian();
                case "Special":
                    stores.pizzaBase(-1);
                    stores.setHam(-1);
                    stores.setOlives(-1);
                    stores.setPepperoni(-1);
                    stores.setPeppers(-1);
                    stores.setPineapple(-1);
                    stores.setSweetcorn(-1);
                    stores.setAnchovies(-1);
                    return new Special();
                case "Seafood":
                    stores.pizzaBase(-1);
                    stores.setAnchovies(-2);
                    stores.setPeppers(-1);
                    stores.setOlives(-1);
                    return new Seafood();
                default:
                    return null;
            }
        }
        return null;
    }
}
