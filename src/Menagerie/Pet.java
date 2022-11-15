package Menagerie;

import java.util.Random;

public abstract class Pet implements Comparable<Pet>{
    private String name;
    private int age;
    private double weight;
    public int compareTo(){
        return 0;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

    public double getAge(){
        return age;
    }
    public void setAge(int age){
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
    public Pet(String name, int age, double weight){
        setName(name);
        setAge(age);
        setWeight(weight);
    }
       
    public abstract String act();
    public abstract String getType();

    @Override
    public String toString(){
        return String.format("%s\t%s\t%d\t%.2f",getType(),name,age,weight);
    }
}
