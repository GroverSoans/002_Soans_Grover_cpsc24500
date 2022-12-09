package quizzy;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class QuestionReader {
    public static boolean readFromText(File f){
        try {
            //reads from text file and creates question objects
            Quiz quiz;
            String question, ans = "";
            ArrayList <Question> questions = new ArrayList<Question>();
            Scanner fsc = new Scanner(f);
            String[] parts;
            String choices = "";
            String line;
            Question q;
            quiz = null;
            while (fsc.hasNextLine()){
                line = fsc.nextLine().trim();
                parts = line.split("\t");
                question = parts[0];
                if (parts.length == 5){
                    //if question only has 3 chouces
                    for (int i = 0; i<2; i++){
                        choices = parts[i+1] + "\n"; 
                    }
                    ans = parts[4];
                } else if (parts.length == 6){
                    for (int i = 0; i<3; i++){
                        choices = parts[i+1] + "\n";
                    }
                    ans = parts[5];
                }
                q = new Question(question,choices,ans);
                //all question objects are store in a array list
                questions.add(q);     
            }
            quiz = new Quiz(questions);
            return true;
        } catch (Exception ex) {
            return false;
        }

        
    }
}
