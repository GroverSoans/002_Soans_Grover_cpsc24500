package Menagerie;
import java.io.File;
import java.io.BufferedWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.io.FileWriter;

public class PetWriter {
    public static void printPets(ArrayList<Pet> pets){
        //function to print the list of pets when called to do so
        for (int i = 0; i < pets.size(); i++){
            System.out.println(pets.get(i));
        } 
    } 
    public static boolean fileWriter(String fileName, ArrayList<Pet> pets){
        //function takes the arraylist of pet objects and writes it to a txt file

        try {
            PrintWriter pw = new PrintWriter(new BufferedWriter(
                new FileWriter(new File(fileName))));
                for (int i = 0; i < pets.size(); i++){
                    pw.write(pets.get(i) + "\n");
                } 
                pw.close();
                return true;
        } catch (Exception ex) {
            return false;
        }
        // return true if succesful; false if failed
    }
}
