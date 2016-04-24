package net.greenrivertech.bdizzle.quizapp;

/**
 * This class represents a single question
 */
public class Question {

    //Fields
    private String q;
    private Boolean answer;

    /**
     * Constructor
     * @param q Question string
     * @param answer Boolean answer value
     */
    public Question(String q, Boolean answer){
        this.q = q;
        this. answer = answer;
    }

    /**
     * Get the question string
     * @return Question string
     */
    public String getQuestion(){
        return q;
    }

    /**
     * Get the answer value
     * @return Boolean answer value
     */
    public Boolean getAnswer(){
        return answer;
    }

}
