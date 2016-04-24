package net.greenrivertech.bdizzle.quizapp;

/**
 * Created by bogdan on 4/15/16.
 */
public class Question {

    private String q;
    private Boolean answer;

    public Question(String q, Boolean answer){
        this.q = q;
        this. answer = answer;
    }

    public String getQuestion(){
        return q;
    };

    public Boolean getAnswer(){
        return answer;
    };

}
