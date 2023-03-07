package Bar;

public class CocktailBuilder {
    private String name;
    private String[] alcohol;
    private String[] mixers;
    private String[] extras;

    public CocktailBuilder setName (String name){
        this.name = name != null ? name : new String("Unnamed");
        return this;
    }

    public CocktailBuilder setAlcohol (String[] alcohol){
        this.alcohol = alcohol != null ? alcohol : new String[]{"No alcohol"};
        return this;
    }

    public CocktailBuilder setMixers (String[] mixers){
        this.mixers = mixers != null ? mixers : new String[]{"No mixers"};
        return this;
    }

    public CocktailBuilder setExtras (String[] extras){
        this.extras = extras != null ? extras : new String[]{"No extras"};
        return this;
    }

    public Cocktail build() {
        return new Cocktail(name, alcohol, mixers, extras);
    }
}
