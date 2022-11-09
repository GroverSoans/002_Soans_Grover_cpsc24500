package Menagerie;

import java.util.Random;

public abstract class Pet {
    Random brain = new Random();
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
    public Pet(){
        name = "";
        age = 0;
        weight = 0;
    }
    public Pet(String name, double age, double weight){
        setName(name);
        setAge(age);
        setWeight(weight);
    }
       
    public abstract String act();
    public abstract String getType();

    @Override
    public String toString(){
        return String.format("%s\t%s\t%f\t%.2f",getType(),name,age,weight);
    }
}
