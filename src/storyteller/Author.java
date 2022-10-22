package storyteller;

import java.util.Random;

import javax.swing.event.SwingPropertyChangeSupport;

public class Author {
    private int adjFreq;
    private int advFreq;
    private int prepFreq;
    WordFileReader f = new WordFileReader();
    public static String getWord(f.dictionary){

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
    




    
}
