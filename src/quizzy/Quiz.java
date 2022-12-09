package quizzy;

import java.util.ArrayList;
import java.util.Random;

public class Quiz {
    private ArrayList <Question> questions;
    public void setQuestions(ArrayList questions){
        this.questions = questions;
    }
    public ArrayList getQuestions(){
        return questions;
    }
    public Quiz(){
        questions = null;
    }
    public Quiz(ArrayList questions){
        setQuestions(questions);
    }
    
    public double quizQs(boolean y){
        Question ques;
        Random rnd = new Random();
        double score = 0;
        String q,a;
        String c;

        do {
            int x = rnd.nextInt(questions.size());
            int counter = 0;
            int sucore = 0;
            q = questions.get(x).getQuestion();
            c = questions.get(x).getChoice();

            

    
        } while ( y == true);
        return score;
    }   
    public String toString(String q, String c){
        return String.format("%s\n%s",q,c);
    }
}
