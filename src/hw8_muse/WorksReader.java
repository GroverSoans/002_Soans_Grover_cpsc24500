package hw8_muse;

import java.beans.XMLDecoder;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class WorksReader {
    
    public static ArrayList <ArtisticWork> readFromBinary(String fileName){//reads objects from binary file and stores it in a arrL
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
    public static ArrayList <ArtisticWork> readFromXML(String fileName){//reads objects from xml file and stores in arrL
        try {
            XMLDecoder dec = new XMLDecoder(new BufferedInputStream(new FileInputStream(new File(fileName))));
            ArrayList<ArtisticWork> works = (ArrayList<ArtisticWork>)dec.readObject();
            dec.close();
            return works;
        } catch (Exception ex) {
            return null;
        }
    }
    public static ArrayList <ArtisticWork> readFromText(String fileName){//reads from text file and store in arrayL
        try {
            ArrayList<ArtisticWork> works = new ArrayList<ArtisticWork>();
            Scanner fsc = new Scanner(new File(fileName));
            String line;
            String[] parts;
            String type,title,name, date,des;
            Song s;
            Movie m;
            ShortStory ss;
            Poem p;
            while (fsc.hasNextLine()){//gathers parts of string 
                line = fsc.nextLine().trim();
                parts = line.split("\t");
                type = parts[0];
                title = parts[1];
                name = parts[2];
                date = parts[3];
                des = parts [4];
                if (type.equalsIgnoreCase("song")){//if type is song creats song obj
                    int duration = Integer.parseInt(parts[5]);
                    String fname = parts[6];
                    double fsize = Double.parseDouble(parts[7]);
                    int bpm = Integer.parseInt(parts[8]);
                    String key = parts[9];
                    s = new Song(name,date,title,des,duration,fname,fsize,bpm,key);
                    works.add(s);
                }else if (type.equalsIgnoreCase("movie")) {//if type == movie creates movie obj
                    int duration = Integer.parseInt(parts[5]);
                    String fname = parts[6];
                    double fsize = Double.parseDouble(parts[7]);
                    int frate = Integer.parseInt(parts[8]);
                    String res = parts[9];
                    m = new Movie(name,date,title,des,duration,fname,fsize,frate,res);
                    works.add(m);        
                }else if (type.equalsIgnoreCase("poem")){//if type == poem creates poem obj
                    String lang = parts[5];
                    String text = parts[6];
                    String meter = parts[7];
                    p = new Poem(name,date,title,des,lang,text,meter);
                    works.add(p);
                }else if (type.equalsIgnoreCase("short story")){//creats short story object
                    String lang = parts[5];
                    String text = parts[6];
                    String set = parts [7];
                    ss = new ShortStory(name,date,title,des,lang,text,set);
                    works.add(ss);
                }
            }
            return works;// returns arrayL of objects read from text file
        } catch (Exception ex) {
            return null;
        }
    }
}
