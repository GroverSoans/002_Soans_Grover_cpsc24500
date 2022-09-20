package webpagebuilder;

import java.util.Scanner;

public class WebPageBuilder 
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        /*Theses print statements prints the heading of the program
         * and guides uses what the program does and how to use it.
         */

        System.out.println("*****************************************************");
        System.out.printf("                WEBPAGE BUILDER V1.0\n");
        System.out.println("*****************************************************\n");
        System.out.println("This application helps you build a basic web page");
        System.out.println("by asking you a series of questions. Just answer ");
        System.out.println("each question, and I'll populate your new webpage");
        System.out.println("with your responses.\n");

        //Statements prompts user then scans and stores input into variables

        System.out.println("What is your name? ");
        String name = sc.nextLine();
        System.out.println("How old are you? ");
        int age = sc.nextInt();
        sc.nextLine();
        System.out.println("Where do you live? ");
        String location = sc.nextLine();
        System.out.println("When you grow up, you want to be ... ");
        String future = sc.nextLine();
        System.out.println("What are your two favorite integers ");
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();

        double quotient = (double)num1 / num2;

        /*Once user has answered all the prompts the html code will print
         * based on the users answers and what is stored in the variables
         */
        
        System.out.println("Here is the code for your web page: ");
        System.out.printf("<html>\n<head><title>%s's Web Page</title></head>\n", name);
        System.out.printf("<body>\n<h1>Welcome to %s's Web Page</h1>\n",name);
        System.out.printf("<p>I am %d years (or %d months!) old and live in %s.</p>\n",
                age,age*12,location);
        System.out.printf("<p>When I grow up, I want to be %s.</p>\n",future);
        System.out.printf("<p>My two favorite integers are %d and %d. Their quotient is %.3f.</p>\n",
                num1,num2,quotient);
        System.out.println("<p>Thank you for visiting my page!</p>");
        System.out.println("</body>\n</html>");
    }    
}
