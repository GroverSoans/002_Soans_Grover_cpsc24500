package Menagerie;
import java.util.Random;
    


public abstract class Pet implements Comparable<Pet>{
    //abstract functions that must be implemeted in all extended classes
    public abstract String act(String name);
    public abstract String getType();
    public abstract String author(String name, String act);

    //random num gen object
    public Random brain = new Random();

    private String name;
    private int age;
    private double weight;

    //gets and sets
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
    //defult constructor
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
       

    //activities that all pets do
    public String sleep(){
        return " took a snooze for a little.";
    }
    public String eat(){
        return " had a heart healthy snack";
    }
    public String attention(){
        return " begged for your attention";
    }

    @Override
    public String toString(){
        //formats the pet object string
        return String.format("%s\t%s\t%d\t%.2f",getType(),name,age,weight);
    }
    @Override
    public int compareTo(Pet pet) {
        //compares pet objects by name and sorts in alphabetical order
        return this.name.compareToIgnoreCase(pet.getName());
    }
}
