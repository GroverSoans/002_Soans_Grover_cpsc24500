package Menagerie;

public class Fish extends Pet{
    private int sleep = 14;
    private int eat = 3;
    private int attention = 7;


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
        return "";     
    }

}
