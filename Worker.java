
public abstract class Worker {
    private String name;
    private int age;
    private double likeability;
    private int yearsExperience;
    private String likes;
    private String hates;

    public Worker(String name, int age, double likeability, int yearsExperience){
        this.name = name;
        this.age = age;
        this.likeability = likeability;
        this.yearsExperience = yearsExperience;
    }

    public Worker(String name, int age, double likeability, int yearsExperience, String likes, String hates){
        this.name = name;
        this.age = age;
        this.likeability = likeability;
        this.yearsExperience = yearsExperience;
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

    public String getLikes(){
        return likes;
    }

    public String getHates(){
        return hates;
    }

    public void attendMeeting(){};
}
