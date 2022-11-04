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
        PetReader reader = new PetReader();
        PetWriter writer = new PetWriter();


        int choiceMenu = 0;
        do{
            menu();
            System.out.print("Enter the number of your choice: ");
            try{
                choiceMenu = sc.nextInt();
            }catch(Exception ex){
                System.out.println("Invalid Input");
            }
            switch (choiceMenu){
                case 1: 
                    System.out.print("Enter d for dog, c for cat or f for fish: ");
                    animal = sc.nextLine();
                    System.out.print("Enter name, age, and wieght: ");
                    name = sc.nextLine();
                    age = sc.nextInt();
                    wieght = sc.nextInt();
                    break;
                case 2:
                    //print pets
                case 3:
                    //save pets to file
                case 4: 
                    System.out.print("Enter name of file to load: ");
                    fileName = sc.nextLine();
                    pets = reader.fileReader(fileName);
                    System.out.println("The pets were read from the file.");
                    break;
                    //load pets from file
                case 5: 
                    //Simulate pets life
                case 6:
                    //clear list of pets
                case 7: 
                    //exit


            }
          
        }while(choiceMenu != 7);
        sc.close();
        
    }
    
}
