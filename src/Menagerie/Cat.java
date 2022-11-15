package Menagerie;

import java.util.Random;

public class Cat extends Pet{
    public Cat(){
        super();
    }
    
    public Cat(String name, int age, double weight){
        super(name, age, weight);
    }
    @Override
    public String getType(){
        return "Cat";    
    }
    @Override
    public String act(){
        return "";    
    }

}
