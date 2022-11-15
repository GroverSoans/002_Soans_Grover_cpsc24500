package Menagerie;
import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;

public class PetReader {
    public static ArrayList<Pet> fileReader(String fileName){
        ArrayList<Pet> pets = new ArrayList<Pet>();
        ArrayList<String> temp = new ArrayList< String>();
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
            parts = line.split("\t");
            type = parts[0];
            name = parts[1];
            age = Integer.parseInt(parts[2]);
            wieght = Double.parseDouble(parts[3]);

            if (type.equalsIgnoreCase("Dog")){
                pets.add(d = new Dog(name,age,wieght));
            } else if(type.equalsIgnoreCase("Cat")){
                pets.add(c = new Cat(name,age,wieght));
            } else {
                pets.add(f = new Fish(name,age,wieght));
            }     
        }
        return pets;
    }
}
