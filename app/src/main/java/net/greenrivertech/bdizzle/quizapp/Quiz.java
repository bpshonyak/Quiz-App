package net.greenrivertech.bdizzle.quizapp;

import java.util.ArrayList;

/**
 * This class handles the functionality of a quiz game
 */
public class Quiz {

    //Fields
    private ArrayList<Question> questions;
    private int index = 0;
    private int correct = 0;

    /**
     * Default Constructor
     */
    public Quiz(){}

    /**
     * Constructor
     * @param questions Array of questions
     */
    public Quiz(ArrayList<Question> questions){
        this.questions = questions;
    }

    /**
     * Add question to questions array
     * @param q Question to add
     */
    public void addQuestion(Question q){
        questions.add(q);
    }

    /**
     * Get next question in the questions array
     * @return  The next question in the questions array
     */
    public Question getNextQuestion(){
        if(index < questions.size()){
            Question q = questions.get(index);
            index++;
            return q;
        }
        return null;
    }

    /**
     * Answer the current question
     * @param answer Boolean answer value
     * @return True if the correct answer was chosen
     */
    public boolean answerQuestion(Boolean answer){
        if (questions.get(index - 1).getAnswer() == answer){
            correct++;
            return true;
        }
        return false;
    }

    /**
     * Get the number of correctly answered questions
     * @return Number of correctly answered questions
     */
    public int getCorrect(){
        return correct;
    }

    /**
     * Get total number of questions
     * @return Total number of questions
     */
    public int getNumberOfQuestions(){
        return questions.size();
    }

}
