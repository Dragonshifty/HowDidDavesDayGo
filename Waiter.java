public class Waiter extends Worker implements Serve, Staff{

    public Waiter (String name, int age, double skill, int yearsExperience){
        super(name, age, skill, yearsExperience);
    }

    public void serveFood(String food){ 
        System.out.println(super.getName() + " serves " + food);
    }
    
    public void attendMeeting(){
        System.out.println(super.getName() + " attends meeting");
    }
}


