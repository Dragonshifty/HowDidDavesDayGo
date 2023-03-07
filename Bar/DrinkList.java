package Bar;

public enum DrinkList {
    INSTANCE;

    public Cocktail getMojito(){
        Cocktail mojito = new CocktailBuilder()
        .setName("Mojito")
        .setAlcohol(new String[]{"Rum"})
        .setMixers(new String[]{"Soda"})
        .setExtras(new String[]{"sugar", "mint", "lime"})
        .build();
        return mojito;
    }

    public Cocktail getEspressoMartini(){
        Cocktail espressoMartini = new CocktailBuilder()
        .setName("Espresso Martini")
        .setAlcohol(new String[]{"Vodka", "Coffee liqueur"})
        .setMixers(new String[]{"Espresso Coffee"})
        .setExtras(new String[]{"Coffee Beans"})
        .build();
        return espressoMartini;
    }

    public Cocktail getShirleyTemple(){
        Cocktail shirleyTemple = new CocktailBuilder()
        .setName("Shirley Temple")
        .setAlcohol(null)
        .setMixers(new String[] {"Ginger Ale", "Grenadine"})
        .setExtras(new String[] {"Maraschino Cherry"})
        .build();
        return shirleyTemple;
    }

    public Cocktail getCocktail(String cocktail){
        if (cocktail != null){
            switch (cocktail){
                case "Mojito":
                    return getMojito();
                case "Espresso Martini":
                    return getEspressoMartini();
                case "Shirley Temple":
                    return getShirleyTemple();
            }
        }
        return null;
    }
}
