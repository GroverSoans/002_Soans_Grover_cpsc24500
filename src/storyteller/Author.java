package storyteller;
import java.util.ArrayList;
import java.util.Random;
import java.util.LinkedHashMap;


public class Author {
    private int adjFreq;
    private int advFreq;
    private int prepFreq;
    private int numSen;
    private static LinkedHashMap<String, ArrayList<String>> words;
    

    public Author(LinkedHashMap<String, ArrayList<String>> words) {
        // constructor for linked hash map
        this.words = words;
    }  
    public LinkedHashMap<String, ArrayList<String>> getWords(){
        //getter
        return words;
    }
    public void setWords(LinkedHashMap<String, ArrayList<String>> words){
        //setter
        this.words = words;
    }

    public Author(int adjFreq, int advFreq, int prepFreq, int numSen) {
        //constructor
        setAdjFreq(adjFreq);
        setAdvFreq(advFreq);
        setPrepFreq(prepFreq);
        setNumSen(numSen);
    }
    public int getAdjFreq() {
        //getter
        return adjFreq;
    }
    public int getAdvFreq() {
        //getter
        return advFreq;
    }
    public int getPrepFreq() {
        //getter
        return prepFreq;
    }
    public int getNumSen() {
        //getter
        return numSen;
    }
    public void setAdjFreq(int adjFreq) {
        //setter w checks
        if (adjFreq < 0){
            this.adjFreq = 0;
        } else if (adjFreq > 10){
            this.adjFreq = 10;
        }else {
            this.adjFreq = adjFreq;
        }
    }
    public void setAdvFreq(int advFreq) {
        //setter w checks
        if (advFreq < 0){
            this.advFreq = 0;
        } else if (adjFreq > 10){
            this.advFreq = 10;
        }else {
            this.advFreq = advFreq;
        }
    }
    public void setPrepFreq(int prepFreq) {
        //setter w checks
        if (prepFreq < 0){
            this.prepFreq = 0;
        } else if (prepFreq > 10){
            this.prepFreq = 10;
        } else {
            this.prepFreq = prepFreq;
        }   
    }
    public void setNumSen(int numSen){
        this.numSen = numSen;
    }
    public String getWord(String type){
        //function retrieves needed word from hash map
        Random ran = new Random();
        String word;

        //temp array list to hold and sort through values
        ArrayList<String> hold = new ArrayList<String>();

        //selects what kind of word and randomly chooses from array list
        if(type.equalsIgnoreCase("n")){
            hold = (words.get("n"));
            word = hold.get(ran.nextInt(hold.size()));
            return word;
        }else if(type.equalsIgnoreCase("adj")){
            hold = (words.get("adj"));
            word = hold.get(ran.nextInt(hold.size()));
            return word;
        }else if(type.equalsIgnoreCase("adv")){
            hold = (words.get("adv"));
            word = hold.get(ran.nextInt(hold.size()));
            return word;
        }else if(type.equalsIgnoreCase("v")){
            hold = (words.get("v"));
            word = hold.get(ran.nextInt(hold.size()));
            return word;
        }else if(type.equalsIgnoreCase("prep")){
            hold = (words.get("prep"));
            word = hold.get(ran.nextInt(hold.size()));
            return word;
        }else{
            return "";
        }
    }
    public String sentence(){
        //function creates the sentence using the freqGen function
        String sentence = "";
        
        if(freqGen(adjFreq)== true){
            sentence = "The "+ getWord("adj")+" "+ getWord("n")+" "+ getWord("v");
        }else {
            sentence = "The "+ getWord("n")+" "+ getWord("v");
        }
        if(freqGen(advFreq)== true){
            sentence = sentence + " " + getWord("adv");
        }
        if (freqGen(prepFreq)==true){
            sentence = sentence + " " + getWord("prep") + " the " + getWord("n")+".\n";
        }else{
            sentence = sentence + ".\n";
        }
        return sentence;
    }
    public boolean freqGen(int freq){
        boolean b = false;
        Random rando = new Random();
        int x;

        //switch case block to controle probability of an event
        
        switch (freq){
            case 0:
            //0%
                b = false;
                break;
            case 1:
            //10%
                x = rando.nextInt(100);
                if(x>90){
                    b = true;
                }else{
                    b = false;
                }
                break;
            case 2:
            //20%

                x = rando.nextInt(100);
                if(x>80){
                    b = true;
                }else{
                    b = false;
                }
                break;
            case 3:
            //30%

                x = rando.nextInt(100);
                if(x>70){
                    b = true;
                }else{
                    b = false;
                }
                break;
            case 4:
            //40%

                x = rando.nextInt(100);
                if(x>60){
                    b = true;
                }else{
                    b = false;
                }
                break; 
            case 5:
            //50%
                x = rando.nextInt(100);
                if(x>50){
                    b = true;
                }else{
                    b = false;
                }
                break;
            case 6:
            //60%
                x = rando.nextInt(100);
                if(x>40){
                    b = true;
                }else{
                    b = false;
                }
                break;
            case 7:
            //70%
                x = rando.nextInt(100);
                if(x>30){
                    b = true;
                }else{
                    b = false;
                }
                break;
            case 8:
            //80%
                x = rando.nextInt(100);
                if(x>20){
                    b = true;
                }else{
                    b = false;
                }
                break;
            case 9:
            //90%
                x = rando.nextInt(100);
                if(x>10){
                    b = true;
                }else{
                    b = false;
                }
                break;
            case 10:
            //100%
                b = true;
                break;                               
        }
        return b;
    }

    public String story(){
        //function creates the story by linking sentences under one string
        String story;
        story = "";
        for(int i = 1; i <= numSen; i++){
            story = story + sentence();
        }
        return story;
    }
    @Override
    public String toString(){     
        return story();
    }    
}
