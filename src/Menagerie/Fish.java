package Menagerie;

public class Fish extends Pet{
    private int sleep = 10;
    private int eat = 20;
    private int attention = 24;
    


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
    public String act(String name){
        int times = brain.nextInt(4);
        String act = "";
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
                        act = swam();
                    }else if(x==1){
                        act = chill();
                    }else{
                    act = search();
                    }
                }
                hour = hour + author(name, act);
            }
            return hour;            
        }
    }
    public String swam(){
        return "swam up to the light.";
    }
    public String chill(){
        return "chilled out by the reef.";
    }
    public String search(){
        return "started to search for Nemo.";
    }


    @Override
    public String author(String name, String act) {
        return "The " + getType()+", "+ name + act+ "\n";
    }

}
