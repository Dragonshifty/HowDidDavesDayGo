public class Chef extends Worker implements Staff{
     
    public Chef(String name, int age, double skill, int yearsExperience){
        super(name, age, skill, yearsExperience);
    }

    public void attendMeeting(){
        System.out.println(super.getName() + " attends meeting");
    }
    
}
