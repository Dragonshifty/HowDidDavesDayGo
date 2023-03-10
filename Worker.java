
public abstract class Worker {
    private String name;
    private int age;
    private double likeability;
    private int yearsExperience;
    private String likes;
    private String hates;
    private boolean isHealthy;

    public Worker(String name, int age, double likeability, int yearsExperience, boolean isHealthy){
        this.name = name;
        this.age = age;
        this.likeability = likeability;
        this.yearsExperience = yearsExperience;
        this.isHealthy = isHealthy;
    }

    public Worker(String name, int age, double likeability, int yearsExperience, boolean isHealthy, String likes, String hates){
        this.name = name;
        this.age = age;
        this.likeability = likeability;
        this.yearsExperience = yearsExperience;
        this.isHealthy = isHealthy;
        this.likes = likes;
        this.hates = hates;
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

    public int getYearsExperience(){
        return yearsExperience;
    }

    public boolean getIsHealthy(){
        return isHealthy;
    }

    public void setIsHealthy(boolean isHealthy){
        this.isHealthy = isHealthy;
    }

    public String getLikes(){
        return likes;
    }

    public String getHates(){
        return hates;
    }

    public void attendMeeting(){};
}
