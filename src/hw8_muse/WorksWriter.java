package hw8_muse;

import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;


public class WorksWriter{//writes tab del. text file using toTabString method
    public static boolean writeToText (ArrayList <ArtisticWork> works, String fileName){
        try {
            PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(new File(fileName))));
            for (int i = 0; i < works.size(); i++){
                pw.write(works.get(i).toTabString()+"\n");
            } 
            pw.close();
            return true;
        } catch (Exception ex) {
            return false;
        }

    }
    public static boolean writeToBinary (ArrayList < ArtisticWork> works, String fileName){
        //writes to binary file
        try {
            FileOutputStream fos = new FileOutputStream(new File(fileName));
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(works);
            oos.close();
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
    public static boolean writeToXML (ArrayList <ArtisticWork> works, String fileName){
        //writes to xml file
        try {
            XMLEncoder enc = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(new File(fileName))));
            enc.writeObject(works);
            enc.close();
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
    public static void writeToScreen(ArrayList<ArtisticWork> works){
        //prints objects stored in arrayL
        for (int i = 0; i < works.size(); i++){
            System.out.println(works.get(i));
        }
    }    
}
