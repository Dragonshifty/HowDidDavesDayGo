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

    public Cocktail getLongIslandIcedTea(){
        Cocktail longIslandIcedTea = new CocktailBuilder()
        .setName("Long Island Iced Tea")
        .setAlcohol(new String[] {"Vodka", "Gin", "Tequila", "Rum", "Triple Sec"})
        .setMixers(new String[] {"Cola", "Lime Juice"})
        .setExtras(new String[] {"Limes"})
        .build();
        return longIslandIcedTea;
    }

    public Cocktail getScrewdriver(){
        Cocktail screwdriver = new CocktailBuilder()
        .setName("Screwdriver")
        .setAlcohol(new String[] {"Vodka"})
        .setMixers(new String[] {"Angostura Bitters"})
        .setExtras(new String[] {"Orange", "Clementine"})
        .build();
        return screwdriver;
    }

    public Cocktail getSingaporeSling() {
        Cocktail singaporeSling = new CocktailBuilder()
        .setName("Singapore Sling")
        .setAlcohol(new String[] {"Gin", "Cherry Brandy", "Benedictine"})
        .setMixers(new String[] {"Angostura Bitters", "Pinaeapple Juice", "Lime Juice"})
        .setExtras(new String[] {"Pineapple", "Cocktail Cherry"})
        .build();
        return singaporeSling;
    }

    public Cocktail getWooWoo(){
        Cocktail wooWoo = new CocktailBuilder()
        .setName("Woo Woo")
        .setAlcohol(new String[] {"Vodka", "Peach Schnapps"})
        .setMixers(new String[] {"Cranberry Juice", "Lime Juice"})
        .setExtras(new String[] {"Lime"})
        .build();
        return wooWoo;
    }

    public Cocktail getStrawberryDaiquiri(){
        Cocktail strawberryDaiquiri = new CocktailBuilder()
        .setName("Strawberry Daiquiri")
        .setAlcohol(new String[] {"Rum"})
        .setMixers(new String[] {"Blended Strawberries", "Lime Juice", "Sugar Syrup"})
        .setExtras(new String[] {"Lime", "Strawberry"})
        .build();
        return strawberryDaiquiri;
    }

    public Cocktail getDarkandStormy(){
        Cocktail darkAndStormy = new CocktailBuilder()
        .setName("Dark and Stormy")
        .setAlcohol(new String[] {"Rum"})
        .setMixers(new String[] {"Ginger Beer"})
        .setExtras(null)
        .build();
        return darkAndStormy;
    }

    public Cocktail getNegroni(){
        Cocktail negroni = new CocktailBuilder()
        .setName("Negroni")
        .setAlcohol(new String[] {"Gin", "Vermouth", "Campari"})
        .setMixers(null)
        .setExtras(new String[] {"Orange"})
        .build();
        return negroni;
    }

    public Cocktail getGingerAppletini(){
        Cocktail gingerAppletini = new CocktailBuilder()
        .setName("Ginger Appletini")
        .setAlcohol(null)
        .setMixers(new String[] {"Apple Juice", "Ginger Beer"})
        .setExtras(new String[] {"Apple"})
        .build();
        return gingerAppletini;
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
                case "Long Island Iced Tea":
                    return getLongIslandIcedTea();
                case "Screwdriver":
                    return getScrewdriver();
                case "Singapore Sling":
                    return getSingaporeSling();
                case "Woo Woo":
                    return getWooWoo();
                case "Strawberry Daiquiri":
                    return getStrawberryDaiquiri();
                case "Dark and Stormy":
                    return getDarkandStormy();
                case "Negroni":
                    return getNegroni();
                case "Ginger Appletini":
                    return getGingerAppletini();
                default:
                    return null;
            }
        }
        return null;
    }
}
