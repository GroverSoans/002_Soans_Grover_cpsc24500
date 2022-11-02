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
        this.words = words;
    }  
    public LinkedHashMap<String, ArrayList<String>> getWords(){
        return words;
    }
    public void setWords(LinkedHashMap<String, ArrayList<String>> words){
        this.words = words;
    }

    public Author(int adjFreq, int advFreq, int prepFreq, int numSen) {
        setAdjFreq(adjFreq);
        setAdvFreq(advFreq);
        setPrepFreq(prepFreq);
        setNumSen(numSen);
    }
    public int getAdjFreq() {
        return adjFreq;
    }
    public int getAdvFreq() {
        return advFreq;
    }
    public int getPrepFreq() {
        return prepFreq;
    }
    public int getNumSen() {
        return numSen;
    }
    public void setAdjFreq(int adjFreq) {
        if (adjFreq < 0){
            this.adjFreq = 0;
        } else if (adjFreq > 10){
            this.adjFreq = 10;
        }else {
            this.adjFreq = adjFreq;
        }
    }
    public void setAdvFreq(int advFreq) {
        if (advFreq < 0){
            this.advFreq = 0;
        } else if (adjFreq > 10){
            this.advFreq = 10;
        }else {
            this.advFreq = advFreq;
        }
    }
    public void setPrepFreq(int prepFreq) {
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
        Random ran = new Random();
        String word;
        ArrayList<String> hold = new ArrayList<String>();
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
        
        //The{<adjective>} <subject> <predicate> {<adverb>} {<preposition> the <object of preposition>}.
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
        
        switch (freq){
            case 0:
                b = false;
                break;
            case 1:
                x = rando.nextInt(100);
                if(x>90){
                    b = true;
                }else{
                    b = false;
                }
                break;
            case 2:
                x = rando.nextInt(100);
                if(x>80){
                    b = true;
                }else{
                    b = false;
                }
                break;
            case 3:
                x = rando.nextInt(100);
                if(x>70){
                    b = true;
                }else{
                    b = false;
                }
                break;
            case 4:
                x = rando.nextInt(100);
                if(x>60){
                    b = true;
                }else{
                    b = false;
                }
                break; 
            case 5:
                x = rando.nextInt(100);
                if(x>50){
                    b = true;
                }else{
                    b = false;
                }
                break;
            case 6:
                x = rando.nextInt(100);
                if(x>40){
                    b = true;
                }else{
                    b = false;
                }
                break;
            case 7:
                x = rando.nextInt(100);
                if(x>30){
                    b = true;
                }else{
                    b = false;
                }
                break;
            case 8:
                x = rando.nextInt(100);
                if(x>20){
                    b = true;
                }else{
                    b = false;
                }
                break;
            case 9:
                x = rando.nextInt(100);
                if(x>10){
                    b = true;
                }else{
                    b = false;
                }
                break;
            case 10:
                b = true;
                break;                               
        }
        return b;
    }

    public String story(){
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
