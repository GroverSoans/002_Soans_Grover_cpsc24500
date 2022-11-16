package Menagerie;

public class Cat extends Pet{
    //cut off values for each defult activity
    private int sleep = 12;
    private int eat = 19;
    private int attention = 24;
    
    //constructor to form cat objects
    public Cat(){
        super();
    }
    
    public Cat(String name, int age, double weight){
        super(name, age, weight);
    }
    @Override
    public String getType(){
        //returns what type of object it is
        return "Cat";    
    }
    @Override
    public String act(String name){
        //function to determine how pet will act
        int times = brain.nextInt(6); //random number obj contained in the pet class
        String act = "";
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
                if (i == 0){
                    //defult actions that come first
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
                        act = yarn();
                    }else if(x==1){
                        act = tail();
                    }else{
                    act = jump();
                    }
                }
                //creates a string for what that pet did in that hour
                hour = hour + author(name, act);
            }
            return hour;
        } 
    }
    //list of activities specfic to the pet
    public String yarn(){
        return " played with a ball of yarn";
    }
    public String tail(){
        return " chased its tail.";
    }
    public String jump(){
        return " jumped onto a bookshelf.";
    }
    
    // forms each string for activities
    @Override
    public String author(String name,String act) {
        return "The " + getType()+ ", " + name + "," + act + "\n";
    }


}
