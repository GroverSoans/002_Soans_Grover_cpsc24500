package Menagerie;
import java.util.Random;

public abstract class Pet {
    Random brain = new Random();
    
    public abstract void act();
    public abstract void getType();



    @Override
    public String toString(){
        return "";
    }
}
