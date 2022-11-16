package Menagerie;


public class Dog extends Pet{
    private int sleep = 13;
    private int eat = 17;
    private int attention = 24;

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
    public String act(String name){
        int times = brain.nextInt(8);
        String act= "";
        String hour = "";
        if (times == 0){
            return "";
        }else {
            times = 1+brain.nextInt(2);
            for (int i = 0; i<times;i++){
                int sim = brain.nextInt(24);
                if (i == 0){
                    if (sim <= sleep){
                        act = " took a nap.";
                    } else if (sim > sleep && sim <= eat){
                        act =  " had a quick bite to eat.";
                    } else if (sim > eat && sim <= attention){
                        act = " sought your attention.";
                    }
                }else if (i == 1){
                    int x = brain.nextInt(3);                        
                    if(x==0){
                        act = ball();
                    }else if(x==1){
                        act = stick();
                    }else{
                    act = bark();
                    }
                }
                hour = hour + author(name, act);
            }
            return hour;
        }
    }
    public String ball(){
        return "played fetch with himself.";
    }
    public String stick(){
        return "found a stick in the backyard.";
    }
    public String bark(){
        return "barked at the bird outside.";
    }


    @Override
    public String author(String name, String act) {
        return "The " + getType()+", "+ name + act + "\n";
    }


}
