package storyteller;
import java.util.ArrayList;
import java.util.Random;
import java.util.LinkedHashMap;
//The{<adjective>} <subject> <predicate> {<adverb>} {<preposition> the <object of preposition>}.

public class Author {
    private int adjFreq;
    private int advFreq;
    private int prepFreq;
    private LinkedHashMap<String, ArrayList<String>> words;

    public Author(LinkedHashMap<String, ArrayList<String>> words) {
        this.words = words;
        
        System.out.println(words);
    }

    //public static String getWord(){

    //}
    

    public Author(int numSen, int adjFreq, int advFreq, int prepFreq) {
        setAdjFreq(adjFreq);

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
    @Override
    public String toString(){
        return "";

    }

    




    
}
