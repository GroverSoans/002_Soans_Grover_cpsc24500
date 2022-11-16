package Menagerie;
import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

public class PetReader {
    public static ArrayList<Pet> fileReader(String fileName){
        ArrayList<Pet> pets = new ArrayList<Pet>(); //arraylist of pet object
        ArrayList<String> temp = new ArrayList< String>(); //arraylist of pet strings 
        String parts[]; 
        String type;
        String name;
        int age;
        double wieght;

        Dog d = new Dog();
        Cat c = new Cat();
        Fish f = new Fish();


        String line = new String();
        try{   
            //reads in file as a string and stores in a temp arraylist
            Scanner fsc = new Scanner(new File(fileName));
            while (fsc.hasNextLine()){
                line = fsc.nextLine().trim();
                temp.add(line);
            }
            fsc.close();
        }catch(Exception ex){
            System.out.println("A problem occured reading the file");
        } 

        for (int i = 0; i < temp.size(); i++){

            //converts temp array list into an object arraylist by determining what each animal is
            // and creating the object.

            line = temp.get(i);
            parts = line.split("\t");
            type = parts[0];
            name = parts[1];
            age = Integer.parseInt(parts[2]);
            wieght = Double.parseDouble(parts[3]);

            if (type.equalsIgnoreCase("Dog")){
                pets.add(d = new Dog(name,age,wieght));
            } else if(type.equalsIgnoreCase("Cat")){
                pets.add(c = new Cat(name,age,wieght));
            } else if(type.equalsIgnoreCase("Fish")){
                pets.add(f = new Fish(name,age,wieght));
            }     
        }
        //sorts the array before being sent back to app
        Collections.sort(pets);
        return pets;
    }
}
