package hw8_muse;

import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import java.util.ArrayList;


public class WorksWriter{
    public static boolean writeToBinary (ArrayList < ArtisticWork> works, String fileName){
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
        for (int i = 0; i < works.size(); i++){
            System.out.println(works.get(i));
        }

    }

    
}
