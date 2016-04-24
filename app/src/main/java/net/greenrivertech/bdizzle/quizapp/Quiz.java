package net.greenrivertech.bdizzle.quizapp;

import java.util.ArrayList;

/**
 * Created by Bogdan on 4/15/16.
 */
public class Quiz {

    //10 Questions

    private ArrayList<Question> questions;
    private int index = 0;
    private int correct = 0;

    public Quiz(){}

    public Quiz(ArrayList<Question> questions){
        this.questions = questions;
    }

    public void addQuestion(Question q){
        questions.add(q);
    }

    public Question getNextQuestion(){
        if(index < questions.size()){
            Question q = questions.get(index);
            index++;
            return q;
        }
        return null;
    };

    public boolean answerQuestion(Boolean answer){
        if (questions.get(index - 1).getAnswer() == answer){
            correct++;
            return true;
        }
        return false;
    }

    public int getCorrect(){
        return correct;
    }

    public int getNumberOfQuestions(){
        return questions.size();
    }

}
