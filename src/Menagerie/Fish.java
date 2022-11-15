package Menagerie;

public class Fish extends Pet{
    public Fish(){
        super();
    }
    
    public Fish(String name, int age, double weight){
        super(name, age, weight);
    }
    @Override
    public String getType(){
        return "Fish";
    }
    @Override
    public String act(){
        String activity = "k";
        return String.format("The %s, %s, %s",getType(),getType(),activity);     
    }

}
