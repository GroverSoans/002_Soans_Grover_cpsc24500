package hw8_muse;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class WorksReader {
    public static ArrayList <ArtisticWork> readFromBinary(String fileName){
        try {
            FileInputStream fis = new FileInputStream(new File(fileName));
            ObjectInputStream ois = new ObjectInputStream(fis);
            ArrayList<ArtisticWork> works = (ArrayList<ArtisticWork>)ois.readObject();
            ois.close();
            return works;
        } catch (Exception ex) {
            return null;
        }
    }
    public static ArrayList <ArtisticWork> readFromXML(String fileName){
        try {
            XMLDecoder dec = new XMLDecoder(new BufferedInputStream(new FileInputStream(new File(fileName))));
            ArrayList<ArtisticWork> works = (ArrayList<ArtisticWork>)dec.readObject();
            dec.close();
            return works;
        } catch (Exception ex) {
            return null;
        }
    }
}
