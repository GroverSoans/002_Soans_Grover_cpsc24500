package phoneordersystem;
import java.util.Scanner;
public class CellPhoneOrderSystem {
    public static void printHeading(){ //heading function
        System.out.println("\n****************************************************");
        System.out.println("        CORPORATE CELL PHONE ORDERING SYSTEM");
        System.out.println("****************************************************\n");

        System.out.print("Welcome to the corporate cell phone ordering system.\n"
            +"Here you can order multiple phones of different kinds\n"
            +"with various add-ons for your employees.\n");
        
    }
    public static void printChoices(){ //choice function
        System.out.println("Let's configure phone ");
        System.out.println("  [C]ase ($49)");
        System.out.println("  [S]creen protector ($15)");
        System.out.println("  [E]ar buds ($99)");
        System.out.println("  [W]ireless charger ($59)");
        System.out.println("  [F]inish order");
        System.out.print("Enter the letter of your choice: ");
    }
    public static void printTotal(String[] phone, double total, int max){ 
        //gets the number of phone in order the string array and the grand total passed in
        //prints each element of array usuing a for loop
        System.out.println("\n\nHere is a summary of your order: ");
        for (int i = 0; i < max; i++){
            System.out.println(phone[i]);
        }
        System.out.printf("\nYour total is $%.2f.\n",total);
        System.out.println("\nThank you for your order.\n");
    }
    public static void main(String[] args){
        printHeading(); 
        Scanner input = new Scanner(System.in);
        int numPhones;
        System.out.print("\nHow many phones will you purchase? ");
        numPhones = input.nextInt();
        input.nextLine();

        String[] phoneOrder = new String[numPhones]; // saves each phone order under an element of an array

        String phoneType; // android or apple
        int screenSize, ram;
        String phone; //adds all uses phone choices to a string
        String doAgain = "y";
        String choice;

        double phoneTotal; //total of an individual phone
        double grandTotal = 0; //total of the entire phone order

        for (int i = 0; i < numPhones;i++){
            phoneTotal = 0;
            phone = "";
            System.out.printf("\nLet's Configure Phone #%d",i+1);
            System.out.print("\nEnter A for Android or I for IPhone: ");
            phoneType = input.nextLine();
            System.out.print("\nWhat size screen? Enter 1 for 5.6\", 2 for 6.2\", or 3 for 6.7\": ");
            screenSize = input.nextInt();
            System.out.print("\nHow much RAM? Enter 64, 128, or 256: ");
            ram = input.nextInt();
            input.nextLine();
            
            if(phoneType.equalsIgnoreCase("A")){//andoid or apple
                phone = "Android ";
                phoneTotal = 799.00;
            } else {
                phone= "IPhone "; 
                phoneTotal = 849.00;          
            }
            
            if(screenSize == 1){//screen size
                phone = phone + "5.6\" ";
            }else if(screenSize == 2){
                phone = phone + "6.2\" ";
                phoneTotal = phoneTotal * 1.2;
            }else if(screenSize == 3){
                phone = phone + "6.7\" ";
                phoneTotal = phoneTotal * 1.4;
            }

            if(ram == 64){//memory size
                phone = phone + "64GB "; 
            }else if(ram == 128){
                phone = phone + "128GB ";
                phoneTotal = phoneTotal + 100;
            }else if(ram == 256){
                phone = phone + "256GB ";
                phoneTotal = phoneTotal + 250;
            }

            do{// do while loop to add accessories to phone order
                printChoices();
                choice = input.nextLine();
                if (choice.equalsIgnoreCase("c")){
                    phone = phone + "/ case ";
                    phoneTotal = phoneTotal + 49;
                    doAgain = "y";

                } else if (choice.equalsIgnoreCase("s")){
                    phone = phone + "/ screen protector ";
                    phoneTotal = phoneTotal + 15;
                    doAgain = "y";
                } else if (choice.equalsIgnoreCase("e")){
                    phone = phone + "/ ear buds ";
                    phoneTotal = phoneTotal + 99;
                    doAgain = "y";
                } else if (choice.equalsIgnoreCase("w")){
                    phone = phone + "/ wireless charger ";
                    phoneTotal = phoneTotal + 59;
                    doAgain = "y";
                } else if (choice.equalsIgnoreCase("f")){
                    doAgain = "n";
                }               

            }while(doAgain.equalsIgnoreCase("y"));

            phone = phone + String.format("($%.2f)", phoneTotal);//formats double into a string and adds it to the string order
            grandTotal = grandTotal + phoneTotal;
            phoneOrder[i] = phone;//adds each phone order in element of array
            
        }
        printTotal(phoneOrder, grandTotal, numPhones);
        input.close();
    }
}
