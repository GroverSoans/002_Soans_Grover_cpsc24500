package phoneordersystem;
import java.util.Scanner;
public class CellPhoneOrderSystem {
    public static void printHeading(){
        System.out.println("\n****************************************************");
        System.out.println("        CORPORATE CELL PHONE ORDERING SYSTEM");
        System.out.println("****************************************************\n");

        System.out.print("Welcome to the corporate cell phone ordering system.\n"
            +"Here you can order multiple phones of different kinds\n"
            +"with various add-ons for your employees.\n");
        
    }
    public static void printChoices(){
        System.out.println("Let's configure phone ");
        System.out.println("[C]ase ($49)");
        System.out.println("[S]creen protector ($15)");
        System.out.println("[E]ar buds ($99)");
        System.out.println("[W]ireless charger ($59)");
        System.out.println("[F]inish order");
    }
    public static void main(String[] args){
        printHeading();
        Scanner input = new Scanner(System.in);
        int numPhones;
        System.out.print("\nHow many phones will you purchase? ");
        numPhones = input.nextInt();

        String[] phone = new String[numPhones];
        /*
         * Logic: create a string variable and duriong each loop ghe string
         * gets reset to "" String will be placed in array when phone is finished 
         * being configured.
         */

        for (int i = 1; i <= numPhones; i++){
            System.out.println(i);
            printChoices();
            String choice = input.nextLine();

        }




    }
}
