
public abstract class Worker {
    private String name;
    private int age;
    private double skill;
    private int yearsExperience;

    public Worker(String name, int age, double skill, int yearsExperience){
        this.name = name;
        this.age = age;
        this.skill = skill;
        this.yearsExperience = yearsExperience;
    }

    public String getName(){
        return name;
    }

    public int getAge(){
        return age;
    }

    public void setAge(int age){
        this.age = age;
    }

    public double getSkill(){
        return skill;
    }

    public void setSkill(double skill){
        this.skill = skill;
    }

    public int getYearsExperience(){
        return yearsExperience;
    }

    public void setYearsExperience(int years){
        yearsExperience = years;
    }

    public void attendMeeting(){};
}
