package quizzy;

public class Question {
    private String question;
    private String choice;
    private String answer;

    public Question(){
        question = "";
        choice = "";
        answer = "";
    }
    public Question(String question, String choice, String answer){
        setQuestion(question);
        setChoice(choice);
        setAnswer(answer);
    }
    public void setQuestion(String Question){
        this.question = question;
    }
    public String getQuestion (){
        return question;
    }
    public void setChoice(String choice){
        this.choice = choice;
    }
    public String getChoice(){
        return choice;
    }
    public void setAnswer(String answer){
        this.answer = answer;
    }
    public String getAnswewr(){
        return answer;
    }
    public String toString(){
        return String.format("%s\n%s\n", question, choice);
    }

}
