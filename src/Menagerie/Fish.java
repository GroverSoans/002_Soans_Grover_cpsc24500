package Menagerie;

public class Fish extends Pet{
    private String name;
    private double age;
    private double weight;

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public double getAge(){
        return age;
    }
    public void setAge(double age){
        if(age < 0){
            age = 0;
        }else {
            this.age = age;
        }
    }
    public double getWeight(){
        return weight;
    }
    public void setWeight(double weight){
        if (weight < 0){
            weight = 0;
        } else {
            this.weight = weight;
        }
    }
    public Fish(){
        name = "";
        age = 0;
        weight = 0;
    }
    public Fish(String name, double age, double weight){
        super(name, age, weight);
    }
    @Override
    public String getType(){
        return "Fish";
    }
    @Override
    public String act(){
        return "";     
    }   
}
