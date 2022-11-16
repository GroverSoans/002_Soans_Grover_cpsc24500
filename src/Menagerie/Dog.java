package Menagerie;


public class Dog extends Pet{
    //cut off values for each defult activity
    private int sleep = 13;
    private int eat = 17;
    private int attention = 24;

    //constructor to form dog objects
    public Dog(){
        super();
    }
    public Dog(String name, int age, double weight){
        super(name, age, weight);
    }
    
    @Override
    public String getType(){
        //returns what type of object it is
        return "Dog";
    }
    @Override
    public String act(String name){
        //function to determine how pet will act
        int times = brain.nextInt(8); //random number obj contained in the pet class
        String act= "";
        String hour = "";
        if (times == 0){
            //does nothing for the hour
            return "";
        }else {
            //does something for the hour
            times = 1+brain.nextInt(2);
            //random number to determine if pet will do one or two activities
            for (int i = 0; i<times;i++){
                int sim = brain.nextInt(24);
                //defult activities 
                if (i == 0){
                    if (sim <= sleep){
                        act = sleep();
                    } else if (sim > sleep && sim <= eat){
                        act =  eat();
                    } else if (sim > eat && sim <= attention){
                        act = attention();
                    }
                }else if (i == 1){
                    //pets will perform these actions ontop of defult actions
                    int x = brain.nextInt(3);                        
                    if(x==0){
                        act = ball();
                    }else if(x==1){
                        act = stick();
                    }else{
                    act = bark();
                    }
                }
                //creates a string for what that pet did in that hour
                hour = hour + author(name, act);
            }
            return hour;
        }
    }
    //activites specific to dogs
    public String ball(){
        return " played fetch with himself.";
    }
    public String stick(){
        return " found a stick in the backyard.";
    }
    public String bark(){
        return " barked at the bird outside.";
    }

    //creats string for pet activities
    @Override
    public String author(String name, String act) {
        return "The " + getType()+ ", " + name + "," + act + "\n";
    }


}
