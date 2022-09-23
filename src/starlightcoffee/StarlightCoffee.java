package starlightcoffee;

import java.util.Scanner;

public class StarlightCoffee {
    public static void printHeading()
    {
        System.out.println("*************************************");
        System.out.println("STARLIGHT COFFEE POINT-OF-SALE SYSTEM");
        System.out.println("*************************************\n");
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

        System.out.print("\nHow many extra shots of expresso would you like?");
        int extraShots = input.nextInt();
        input.nextLine();

        System.out.print("\nAre you a member of Starlight Stars (y or n)? ");
        String starMem = input.nextLine();

        System.out.printf("%s %d %d %d %s", name, coffee, size, extraShots, starMem);

    }
    
}
