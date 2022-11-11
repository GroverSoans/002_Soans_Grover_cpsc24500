package Menagerie;
import java.io.File;
import java.io.BufferedWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.io.FileWriter;

public class PetWriter {
    public static void printPets(ArrayList<Pet> pets){
        for (int i = 0; i < pets.size(); i++){
            System.out.println(pets.get(i));
        } 
    } 
    public static boolean fileWriter(String fileName, ArrayList<Pet> pets){

        try {
            PrintWriter pw = new PrintWriter(new BufferedWriter(
                new FileWriter(new File(fileName))));
                for (int i = 0; i < pets.size(); i++){
                    pw.write(pets.get(i) + "\n");
                } 
                pw.close();
                return true;
        } catch (Exception ex) {
            System.out.println("An Error occurred writing the file");
            ex.printStackTrace();
            return false;
        }
        

    }
}
