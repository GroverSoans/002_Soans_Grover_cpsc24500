package Menagerie;
import java.util.Scanner;
import java.util.ArrayList;

public class App {
    public static void heading(){
        System.out.println("************************************************************");
        System.out.println("              Menagerie V1.0: The Pet Simulator");
        System.out.println("************************************************************");
    }
    public static void menu(){
        System.out.println("What would you like to do?");
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
        String animal;
        String name;
        String fileName;
        int age, wieght;
        ArrayList <String> pets = new ArrayList<>();
        heading();
        
        int choiceMenu = 0;
        do{
            menu();
            System.out.print("Enter the number of your choice: ");
            try{
                choiceMenu = sc.nextInt();
                sc.nextLine();
            }catch(Exception ex){
                System.out.println("Invalid Input");
            }
            switch (choiceMenu){
                case 1: 
                    System.out.print("Enter d for dog, c for cat or f for fish: ");
                    animal = sc.nextLine();
                    System.out.print("Enter name, age, and wieght: ");
                    name = sc.next();
                    age = sc.nextInt();
                    wieght = sc.nextInt();
                    //System.out.printf("%s, %d, %d",name, age, wieght);
        
                    break;
                case 2:
                    PetWriter.printPets();
                    break;
                case 3:
                    //save pets to file
                    System.out.print("Enter the name of file to save: ");
                    fileName = sc.nextLine();
                    PetWriter.fileWriter(fileName);
                    System.out.println("The pets were saved to the file");
                    break;
                case 4:
                    //load pets from file 
                    System.out.print("Enter name of file to load: ");
                    fileName = sc.nextLine();
                    pets = PetReader.fileReader(fileName);
                    System.out.println("The pets were read from the file.");
                    break;
                case 5: 
                    //Simulate pets life
                case 6:
                    //clear list of pets
            } 
        }while(choiceMenu != 7);
        sc.close();
        System.out.println("Thank you for using Menagerie. We hope you had fun.");
        
    }
    
}
