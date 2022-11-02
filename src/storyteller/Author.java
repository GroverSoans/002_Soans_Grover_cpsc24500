package storyteller;
import java.util.ArrayList;
import java.util.Random;
import java.util.LinkedHashMap;

// the
public class Author {
    private int adjFreq;
    private int advFreq;
    private int prepFreq;
    private int numSen;
    private LinkedHashMap<String, ArrayList<String>> words;
    

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
        } else if (adjFreq > 11){
            this.adjFreq = 10;
        }else {
            this.adjFreq = adjFreq;
        }
    }
    public void setAdvFreq(int advFreq) {
        if (advFreq < 0){
            this.advFreq = 0;
        } else if (adjFreq > 11){
            this.advFreq = 10;
        }else {
            this.advFreq = advFreq;
        }
    }
    public void setPrepFreq(int prepFreq) {
        if (prepFreq < 0){
            this.prepFreq = 0;
        } else if (prepFreq > 11){
            this.prepFreq = 10;
        } else {
            this.prepFreq = prepFreq;
        }  
        //System.out.println(prepFreq);
        
    }
    public void setNumSen(int numSen){
        this.numSen = numSen;
    }
    public String getWord(String type){
        Random ranAd = new Random();
        String word;
        ArrayList<String> hold = new ArrayList<String>();
        if(type.equalsIgnoreCase("n")){
            hold = (words.get("n"));
            word = hold.get(ranAd.nextInt(hold.size()));
            return word;
        }else if(type.equalsIgnoreCase("adj")){
            hold = (words.get("adj"));
            word = hold.get(ranAd.nextInt(hold.size()));
            return word;
        }else if(type.equalsIgnoreCase("adv")){
            hold = (words.get("adv"));
            word = hold.get(ranAd.nextInt(hold.size()));
            return word;
        }else if(type.equalsIgnoreCase("v")){
            hold = (words.get("v"));
            word = hold.get(ranAd.nextInt(hold.size()));
            return word;
        }else if(type.equalsIgnoreCase("prep")){
            hold = (words.get("prep"));
            word = hold.get(ranAd.nextInt(hold.size()));
            return word;
        }else{
            return "";
        }
    }
    public String sentence(){
        
        //The{<adjective>} <subject> <predicate> {<adverb>} {<preposition> the <object of preposition>}.
        String sentence = "";
        int freq;
        freq = prepFreq+adjFreq+advFreq;
        if (freq == 0){
            sentence = "The "+ getWord("n")+" "+getWord("v")+"\n";
        }else if (freq == 30){
            sentence = "The "+getWord("adj")+" "+ getWord("n")+" "+getWord("v")+
            " "+getWord("adv")+" "+getWord("prep")+" the "+getWord("n")+"\n";
        }
    
        //System.out.println(sentence);
        System.out.println(prepFreq);
        return sentence;

    }
    public String story(){
        String story;
        story = "";
        for(int i = 0; i == numSen+1; i++){
            story = story + sentence();
        }
        System.out.println(story);
        return story;

    }
    @Override
    public String toString(){
        
        return story();
    }

    
}
