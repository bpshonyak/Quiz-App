package net.greenrivertech.bdizzle.quizapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //Fields
    public final static String EXTRA_MESSAGE = "net.greenrivertech.bdizzle.MESSAGE";

    Quiz game;
    Button falseBtn;
    Button trueBtn;
    Button nextBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Create questions
        ArrayList<Question> questions = new ArrayList<>();
        questions.add(new Question("America became independent in the year 1776.", true));
        questions.add(new Question("Bogdan is the real boss man.", false));
        questions.add(new Question("Yegor is the real boss man.", true));
        questions.add(new Question("There are 25,423 cities in America.", false));
        questions.add(new Question("Test questions 1.", true));
        questions.add(new Question("Test questions 2.", false));
        questions.add(new Question("Test questions 3.", true));
        questions.add(new Question("Test questions 4.", false));
        questions.add(new Question("Test questions 5.", false));
        questions.add(new Question("Test questions 6.", true));

        //Create quiz game instance
        game = new Quiz(questions);

        //Initialize buttons
        falseBtn = (Button) findViewById(R.id.falseBtn);
        trueBtn = (Button) findViewById(R.id.trueBtn);
        nextBtn = (Button) findViewById(R.id.nextBtn);

        //Set up screen
        enableButtons();
        loadQuestion();
    }

    /**
     * Called when false button is clicked
     * @param view Button View object
     */
    public void falseClicked(View view){

        submitAnswer(false);

    }

    /**
     * Called when true button is clicked
     * @param view Button View object
     */
    public void trueClicked(View view){

        submitAnswer(true);
    }

    /**
     * Handle answer submission
     * @param answer Boolean value of answer
     */
    public void submitAnswer(boolean answer){

        //Necessary variables to create toast
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;
        CharSequence text;

        //Verify answer
        if (game.answerQuestion(answer)){
            text = "Correct!";
        } else {
            text = "Oopps!";
        }

        //Create and show toast
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();

        //Disable answer buttons
        disableButtons();
    }

    /**
     * Handle next button click
     * @param view Next button View object
     */
    public void nextClicked(View view){
        loadQuestion();
        enableButtons();
    }

    /**
     * Disable answer buttons
     */
    public void disableButtons() {
        falseBtn.setEnabled(false);
        trueBtn.setEnabled(false);
        nextBtn.setEnabled(true);
    }

    /**
     * Enable answer buttons
     */
    public void enableButtons() {
        falseBtn.setEnabled(true);
        trueBtn.setEnabled(true);
        nextBtn.setEnabled(false);
    }

    /**
     * Load new question
     */
    public void loadQuestion(){
        Question newQ = game.getNextQuestion();

        if(newQ != null){
            TextView qText = (TextView) findViewById(R.id.questionText);
            qText.setText(newQ.getQuestion());
        } else {

            //Call results activity if there are no more questions

            String message = "You got " + game.getCorrect() +
                             " correct out of " +
                             game.getNumberOfQuestions();

            Intent intent = new Intent(this, ResultsActivity.class);
            intent.putExtra(EXTRA_MESSAGE, message);
            startActivity(intent);
        }

    }




}
