
public abstract class Worker {
    private String name;
    private int age;
    private double likeability;
    private int yearsExperience;

    public Worker(String name, int age, double likeability, int yearsExperience){
        this.name = name;
        this.age = age;
        this.likeability = likeability;
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

    public double getLikeability(){
        return likeability;
    }

    public void setlikeability(double likeability){
        this.likeability = likeability;
    }

    public int getYearsExperience(){
        return yearsExperience;
    }

    public void setYearsExperience(int years){
        yearsExperience = years;
    }

    public void attendMeeting(){};
}
