package Bar;

public final class Cocktail {
    private String[] alcohol;
    private String[] mixers;
    private String[] extras;
    private String name;

    public Cocktail(String name, String[] alcohol, String[] mixers, String[] extras){  
        this.name = name;
        this.alcohol = alcohol;
        this.mixers = mixers;
        this.extras = extras;  
    }

    public String getName(){
        return name;
    }

    public String[] getAlcohol() {
        return alcohol;
    }

    public String[] getMixers() {
        return mixers;
    }

    public String[] getExtras() {
        return extras;
    }

    @Override
    public String toString(){
        StringBuilder contents = new StringBuilder();
        String comma = ", ";
        String space = " ";
        String and = "and ";
        String with = "with ";
        contents.append(name + ": ");
        for (int i = 0; i < alcohol.length; i++){
            contents.append(alcohol[i]);
            if (i != alcohol.length - 1) contents.append(comma);
            else contents.append(space);  
        }
        contents.append(with);
        for (int j = 0; j < mixers.length; j++){
            contents.append(mixers[j]);
            if (j != mixers.length - 1) contents.append(comma);
            else contents.append(space); 
        }
        contents.append(and);
        for (int k = 0; k < extras.length; k++){
            contents.append(extras[k]);
            if (k != extras.length - 1) contents.append(comma);
            else contents.append(space);
        }
        return contents.toString().trim();
    }
}
