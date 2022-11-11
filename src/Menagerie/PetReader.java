package Menagerie;
import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;

public class PetReader {
    public static ArrayList<String> fileReader(String fileName){
        ArrayList<Pet> pets = new ArrayList<Pet>();

        String line = new String();
        try{   
            Scanner fsc = new Scanner(new File(fileName));
            while (fsc.hasNextLine()){
                line = fsc.nextLine().trim();
                pets.add(line);
            }
            fsc.close();
        }catch(Exception ex){
            System.out.println("A problem occured reading the file");
        }  
        return null;
    }
}
