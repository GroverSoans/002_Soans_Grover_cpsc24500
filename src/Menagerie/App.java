package Menagerie;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
///Users/groversoans/Downloads/animal.txt

public class App {
    public static void heading(){
        System.out.println("************************************************************");
        System.out.println("              Menagerie V1.0: The Pet Simulator");
        System.out.println("************************************************************");
    }
    public static void menu(){
        System.out.println("\nWhat would you like to do?");
        System.out.println("1. Add a new pet.");
        System.out.println("2. Print list of pets.");
        System.out.println("3. Save pets to a file.");
        System.out.println("4. Load pets from a file.");
        System.out.println("5. Simulate a day in the life of your pets.");
        System.out.println("6. Clear your list of pets.");
        System.out.println("7. Exit");

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String type;
        String name;
        String fileName;
        int age;
        double wieght;
        ArrayList <Pet> pets = new ArrayList<Pet>();
        heading();
        //animal objects
        Dog d = new Dog();
        Cat c = new Cat();
        Fish f = new Fish();
        int choiceMenu = 0;
        do{
            menu();
            System.out.print("Enter the number of your choice: ");
            //try catch to insure valid input
            try{
                choiceMenu = sc.nextInt();
                sc.nextLine();
            }catch(Exception ex){
                sc.next();
                System.out.println("Invalid Input");
            }
            switch (choiceMenu){
                case 1: 
                    //case 1 = adding a pet pet object to array list
                    System.out.print("Enter d for dog, c for cat or f for fish: ");
                    type = sc.nextLine();
                    System.out.print("Enter name, age, and wieght: ");
                    name = sc.next();
                    age = sc.nextInt();
                    wieght = sc.nextInt();
                    //determines what class needs to be called and passes needed info
                    if(type.equalsIgnoreCase("d")){
                        d = new Dog(name,age,wieght);
                        pets.add(d);
                    } else if(type.equalsIgnoreCase("c")){
                        c = new Cat(name,age,wieght);
                        pets.add(c);
                    } else if (type.equalsIgnoreCase("f")){
                        f = new Fish(name, age, wieght);
                        pets.add(f);
                    }
                    break;
                case 2:
                //case 2 = sort and print array list of pet objects
                Collections.sort(pets);
                System.out.println("Here is your list of pets:");
                    PetWriter.printPets(pets);
                    break;
                case 3:
                    //case 3 = sort and save pets to file
                    Collections.sort(pets);
                    System.out.print("\nEnter the name of file to save: ");
                    fileName = sc.nextLine();
                    boolean x = PetWriter.fileWriter(fileName,pets);
                    if(x == true){
                        System.out.println("The pets were saved to the file");
                    } else {
                        System.out.println("An error occured writing to file");
                    }
                    break;
                case 4:
                    //case 4 = load pets from file 
                    System.out.print("\nEnter name of file to load: ");
                    fileName = sc.nextLine();
                    pets = PetReader.fileReader(fileName);
                    System.out.println("The pets were read from the file.");
                    break;
                case 5: 
                    //case 5 = Simulate pets life
                    String sim;
                    System.out.println("Here is a simulation of a day in the life of your pets: ");
                    for (int i=0;i<24;i++){
                        System.out.printf("\nHour %d\n",i+1);
                        System.out.println("-------");
                        for(int j = 0;j < pets.size(); j++){
                            pets.get(j);
                            if (pets.get(j).getType().equalsIgnoreCase("dog")){
                                sim = d.act(pets.get(j).getName());
                                System.out.print(sim);
                            } else if (pets.get(j).getType().equalsIgnoreCase("cat")){
                                sim = c.act(pets.get(j).getName());
                                System.out.print(sim);
                            } else if (pets.get(j).getType().equalsIgnoreCase("fish")){
                                sim = f.act(pets.get(j).getName());
                                System.out.print(sim);
                            }
                        }
                    }
                    break;

                case 6:
                    //case 6 = clears arraylist of pet objects
                    pets.clear();
                    break;
            } 
        }while(choiceMenu != 7);
        sc.close();
        System.out.println("Thank you for using Menagerie. We hope you had fun.");
        
    }
    
}
