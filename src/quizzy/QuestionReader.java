package quizzy;

import java.util.ArrayList;
import java.util.Scanner;

public class QuestionReader {
    public static ArrayList<Question> readFromText(){
        try {
            ArrayList <Question> questions = new ArrayList<Question>();
            Scanner fsc = new Scanner(System.in);
            while (fsc.hasNextLine()){

            }
            return questions;
        } catch (Exception ex) {
            return null;
        }

        
    }
}
