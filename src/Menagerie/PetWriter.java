package Menagerie;
import java.io.File;
import java.io.BufferedWriter;
import java.io.PrintWriter;
import java.io.FileWriter;

public class PetWriter {
    public static void printPets(){
        
    } 
    public static void fileWriter(String fileName){

        try {
            PrintWriter pw = new PrintWriter(new BufferedWriter(
                new FileWriter(new File(fileName))));
                pw.close();
        } catch (Exception ex) {
            System.out.println("An Error occurred writing the file");
            ex.printStackTrace();
        }
        

    }
}
