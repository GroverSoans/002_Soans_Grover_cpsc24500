package starlightcoffee;

import java.util.Scanner;

public class StarlightCoffee {
    public static void printHeading()
    {
        System.out.println("*************************************");
        System.out.println("STARLIGHT COFFEE POINT-OF-SALE SYSTEM");
        System.out.println("*************************************\n");
    }

    public static void printBill(String name,double bev,double dis,double tip,double tax,double total)
    {   



    }

    public static double calcCost(int type,int s,int shots,String mem, int tip)
    {   
        double totalCost=0;
        if (type == 1){
            totalCost = 2.25;
        }   else if (type == 2){
            totalCost = 2.75;
        }   else if (type == 3){
            totalCost = 3.50;
        }   else {
            totalCost = 3.75;
        }

        if (s == 3){
            totalCost = totalCost * 1.4;
        }   else if (s == 2){
            totalCost = totalCost * 1.2;
        }

        totalCost = totalCost + .5 * shots;

        double costOfCoffee = totalCost;
        double discount;
        double tipAm;
        double tax;
        
        if (mem.equalsIgnoreCase("y")){
            discount = totalCost * .1;
            totalCost = totalCost * .9;
        }

        if (tip == 1){
            tipAm = totalCost * .1;
            totalCost = tipAm + totalCost;
        }   else if (tip == 2){
            tipAm = totalCost * .15;
            totalCost = tipAm + totalCost;
        }   else {
            tipAm = totalCost * .20;
            totalCost = tipAm + totalCost;
        }

        tax = totalCost *.0875;
        totalCost= totalCost + tax;
        

        printBill(costOfCoffee,discount,tipAm,tax,totalCost);

        return totalCost;
    }
    public static void main(String[] args)
    {
        printHeading();

        Scanner input = new Scanner(System.in);
        System.out.print("What is your name? ");
        String name = input.nextLine();
        System.out.println("\nWhat kind of coffee do you want?");
        System.out.print("1. Americano\n2. Italiano\n3. Espresso\n4. Cappuccino\n");
        System.out.print("Enter the number of your choice: ");
        int coffee = input.nextInt();

        System.out.println("\nWhat size do you want?");
        System.out.print("1. Tall\n2. Grande\n3. Venti\n");
        System.out.print("Enter the number of your choice: ");
        int size = input.nextInt();

        System.out.print("\nHow many extra shots of expresso would you like? ");
        int extraShots = input.nextInt();
        input.nextLine();

        System.out.print("\nAre you a member of Starlight Stars (y or n)? ");
        String starMem = input.nextLine();

        System.out.print("\nWhat size tip would you like to leave? ");
        System.out.print("\n1. Good service - 10%\n2. Great service - 15%\n3. Outstanding service - 20%\n");
        System.out.print("Enter the number of your choice: ");
        int tip = input.nextInt();

        printBill(name);
        calcCost(coffee,size,extraShots,starMem,tip);



        System.out.printf("%s %d %d %d %s\n", name, coffee, size, extraShots, starMem);
        System.out.printf("%.2f", total);
    }
    
}
