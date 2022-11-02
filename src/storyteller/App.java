package storyteller;
import java.util.ArrayList;
import java.util.LinkedHashMap;

import java.util.Scanner;
///Users/groversoans/Downloads/wordlist.txt
public class App {
    private static void printHeading(){System.out.println("****************************************************");
        System.out.println("                  STORYTELLER V1.0");
        System.out.println("****************************************************\n");

        System.out.println("Welcome to StoryTeller, a sophisticated electronic");
        System.out.println("author. This program reads from a list of words of");
        System.out.println("various parts of speech and creates a story from");
        System.out.println("them. You can tune the richness of the writing by");
        System.out.println("changing how frequently adjectives, adverbs, and");
        System.out.println("prepositions should be included.\n");
    }
        
    public static void main(String[] args) {
        int advFreq;
        int adjFreq;
        int prepFreq;

        int numSen;
        String doAgain;

        printHeading();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the name of the file: ");
        String fileName = sc.nextLine();
        LinkedHashMap <String, ArrayList<String>> words= WordFileReader.fileReader(fileName); 
        Author authObj;
        
        authObj = new Author(words); 
        
        do{
            System.out.print("\nHow many sentences would you like in your story? ");
            numSen = sc.nextInt();
            System.out.println("On a scale of 0 to 10 ...");
            System.out.print("  How frequently should adjectives be used? ");
            adjFreq = sc.nextInt();
            System.out.print("  How frequently should adverbs be used? ");
            advFreq = sc.nextInt();
            System.out.print("  How frequently should prepositions be used? ");
            prepFreq = sc.nextInt();
            sc.nextLine();
            authObj = new Author(adjFreq,advFreq,prepFreq,numSen);
            System.out.println("Here it is:");
            
            System.out.println(authObj.toString());

            System.out.print("Would you like another story (y or n)? ");
            doAgain = sc.nextLine();

        }while (doAgain.equalsIgnoreCase("y"));
        sc.close();
        System.out.println("\nThank you for using StoryTeller!");
    }
    
}
