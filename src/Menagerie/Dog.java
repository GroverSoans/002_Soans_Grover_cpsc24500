package Menagerie;

public class Dog extends Pet{
    public Dog(){
        super();
    }
    
    public Dog(String name, int age, double weight){
        super(name, age, weight);
    }
    
    @Override
    public String getType(){
        return "Dog";
    }
    @Override
    public String act(){
        System.out.println();
        return "";   
    }

}
