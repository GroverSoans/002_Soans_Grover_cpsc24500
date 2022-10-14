package wnba;
import java.util.Scanner;
import java.io.File;
///Users/groversoans/Downloads/wnba.txt
public class wnba {
    public static void heading(){
        System.out.println("***************************************************");
        System.out.println("               2022 WMBA STANDINGS");
        System.out.println("***************************************************");
    }
    public static void menu(){
        System.out.println("What would you like to see");
        System.out.println("1. Eastern Conference");
        System.out.println("2. Western Conference");
        System.out.println("3. Combined");
        System.out.println("4. Exit");
        System.out.print("Enter the number of your choice: ");
    }
    public static void printResults(){

    } 
    public static void main(String[] args) {
        heading();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the standings filename: ");
        String fileName = sc.nextLine();
        String line;
        String western[] = new String[9];
        String eastern[] = new String[9];
        int counter;
        try{
            Scanner fsc = new Scanner(new File(fileName));
            while (fsc.hasNextLine()){
                counter = 0;
                line = fsc.nextLine();
                if(line.equalsIgnoreCase("conference: western")){ 
                    western[counter] = line;
                }
                
                System.out.println(line);
                counter++;
            }
            fsc.close();
        } catch(Exception ex){
            System.out.println("A problem happened reading from the file");
        }  
        System.out.println("The teams have been read.");
        int choice = 0;
        while(choice != 4){
            menu();
            choice = sc.nextInt();
            if (choice == 1){
                printResults();
            } else if (choice == 2){
                printResults();
            } else if (choice == 3){
                printResults();
            }else{
                break;
            }
        }
        for(int j =0; j<9;j++){
            System.out.println(western[j]);
        }
    }
}
