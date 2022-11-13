package Menagerie;
import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;

public class PetReader {
    public static ArrayList<Pet> fileReader(String fileName){
        ArrayList<Pet> pets = new ArrayList<Pet>();
        ArrayList<String> temp = new ArrayList< String>();

        String line = new String();
        try{   
            Scanner fsc = new Scanner(new File(fileName));
            while (fsc.hasNextLine()){
                line = fsc.nextLine().trim();
                temp.add(line);
            }
            fsc.close();
        }catch(Exception ex){
            System.out.println("A problem occured reading the file");
        }  
        return null;
    }
    
}
