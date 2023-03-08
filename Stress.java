import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
public class Stress {
    
    private static List<String> interactions = new ArrayList<>(); 
    private static List<Worker> staffList = new ArrayList<>();

    public static void addInteraction(String action){
        interactions.add(action);
    }

    public static void getStaffList(List<Worker> staff){
        staffList = staff;
    }

    public static void listInteractions(){
        for (int i = 0; i < interactions.size(); i++){
            System.out.println(interactions.get(i));
        }
    }

    public static void checkStress(){
        for (String interaction : interactions){
            System.out.println(interaction);
        }
    }

    public static void checkDislikes(){
        long count = IntStream.range(0, interactions.size() -1)
        .filter(x -> interactions.get(x).startsWith("Brian") &&
        Arrays.stream(interactions.get(x + 1).split(":")[1].split(","))
        .map(String::trim)
        .anyMatch("Special"::equals))
        .count();

        long count2 = IntStream.range(0, interactions.size() -1)
        .filter(x -> interactions.get(x).startsWith("Dave"))
        .count();

        System.out.println(count);
    }
}
