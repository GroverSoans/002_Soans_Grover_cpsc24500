package wnba;
import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;
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
    public static void printResults(String[] conference){
        String[] parts = new String[2];
        String team;
        int wins,loss,leaderW,leaderL;
        double gb,pct;

        parts = conference[0].split("\t");
        leaderW = Integer.parseInt(parts[1]);
        leaderL = Integer.parseInt(parts[2]);

        System.out.printf("%-20s %16s %8s %8s  %6s\n","Team Name", "Wins", "Losses", "PCT", "GB");

        for (int i = 0; i < conference.length;i++){
            parts = conference[i].split("\t");
            team = parts[0];
            wins = Integer.parseInt(parts[1]);
            loss = Integer.parseInt(parts[2]);
            pct = (double)wins/(wins+loss);
            gb = ((leaderW - wins)+(loss - leaderL))/2;
            if(gb == 0){
                System.out.printf("%-20s %16d %8d %8.3f %7s\n", team, wins, loss, pct, "-");
            }else{
                System.out.printf("%-20s %16d %8d %8.3f %8.1f\n", team, wins, loss, pct, gb);  
            }
        }
        System.out.println("\n");
    }
    
    public static void main(String[] args) {
        heading();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the standings filename: ");
        String fileName = sc.nextLine();

        String line;
        String[] western = new String[6];
        String[] eastern = new String[6];
        ArrayList<String> league = new ArrayList<String>();
        int ctr;

        try{
            Scanner fsc = new Scanner(new File(fileName));    
            while (fsc.hasNextLine()){
                line = fsc.nextLine();
                league.add(line);
                //System.out.println(line);   
            }    
        } catch (Exception ex){
            System.out.println("A problem happened reading from the file");
        }  

        for (int i =0; i < league.size(); i++){
            if (league.get(i).equalsIgnoreCase("Conference: Eastern")){
                ctr = 0;
                for(int j = i; j < i+6; j++){
                    eastern[ctr] = league.get(j+1);
                    ctr++;
                }
            }else if (league.get(i).equalsIgnoreCase("Conference: Western")){
                ctr = 0;
                for(int j = i; j < i+6; j++){
                    western[ctr] = league.get(j+1);
                    ctr++;
                }
            }
        }

        System.out.println("The teams have been read.");
        int choice = 0;
        while(choice != 4){
            menu();
            choice = sc.nextInt();
            if (choice == 1){
                System.out.println("\nStandings for the Eastern Conference");
                printResults(eastern);
            } else if (choice == 2){
                System.out.println("\nStandings for the Western Conference");
                printResults(western);
            } else if (choice == 3){
                System.out.println("Combined Conference Standings");
                //printResults();
            }else{
                break;
            }
        }
   
        
        //System.out.println(league);
      

        /*for (int num=0; num < eastern.length; num++){
            System.out.println(eastern[num]);  
        }
        for (int num=0; num < western.length; num++){
            System.out.println(western[num]);
        }*/

    }
}