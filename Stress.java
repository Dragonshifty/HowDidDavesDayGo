import java.util.ArrayList;
import java.util.List;
public class Stress {
    
    private static List<String> interactions = new ArrayList<>(); 

    public static void addInteraction(String action){
        interactions.add(action);
    }

    public static void listInteractions(){
        for (int i = 0; i < interactions.size(); i++){
            System.out.println(interactions.get(i));
        }
    }
}
