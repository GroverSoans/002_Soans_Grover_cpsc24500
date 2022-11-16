package Menagerie;

public class Cat extends Pet{
    private int sleep = 12;
    private int eat = 19;
    private int attention = 24;

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
    public String act(String name){
        int times = brain.nextInt(6);
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
                        act = yarn();
                    }else if(x==1){
                        act = tail();
                    }else{
                    act = jump();
                    }
                }
                hour = hour + author(name, act);
            }
            return hour;
        } 
    }
    public String yarn(){
        return "played with a ball of yarn";
    }
    public String tail(){
        return "chased its tail.";
    }
    public String jump(){
        return "jumped onto a bookshelf.";
    }
    
    @Override
    public String author(String name,String act) {
        return "The " + getType()+", "+ name + act + "\n";
    }


}
