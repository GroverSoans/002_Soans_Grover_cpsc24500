package storyteller;
import java.util.LinkedHashMap;
import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;

public class WordFileReader {
    public static LinkedHashMap<String,ArrayList<String>> fileReader(String fileName){
        LinkedHashMap<String, ArrayList<String>> dictionary = new LinkedHashMap<String, ArrayList<String>>();
        ArrayList<String> noun = new ArrayList<String>();
        ArrayList<String> adj = new ArrayList<String>();
        ArrayList<String> adv = new ArrayList<String>();
        ArrayList<String> verb = new ArrayList<String>();
        
        String line = new String();

        String word, des;
        String[] parts;

        try{   
            Scanner fsc = new Scanner(new File(fileName));
            while (fsc.hasNextLine()){
                line = fsc.nextLine().trim();
                parts = line.split(" ");
                word = parts[0];
                des = parts[1];
                System.out.printf("%s,    %s\n",word,des);
                
                if (des.equalsIgnoreCase("adj")){
                    adj.add(word);
                } else if (des.equalsIgnoreCase("n")){
                    noun.add(word);
                } else if (des.equalsIgnoreCase("adv")){
                    adv.add(word);
                } else if (des.equalsIgnoreCase("v")){
                    verb.add(word);
                }  
            }
        }catch(Exception ex){
            System.out.println("A problem occured reading the file");
        } 
        
        dictionary.put("noun", noun);
        dictionary.put("adjetive",adj);
        dictionary.put("adverb",adv);
        dictionary.put("verb", verb);

        return dictionary;
    }   
}
