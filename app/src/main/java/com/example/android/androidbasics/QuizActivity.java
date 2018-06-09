package com.example.android.androidbasics;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {
    Button mTrue_Button;
    Button mFalse_Button;
    Button mNext_Button;
    TextView mQuestion_Textview;
    ProgressBar mProgressBar;
    TextView mScoreTextView;

    private int mCurrentIndex =0;
    private int mScore = 0;




    private questionBank[] mQuestionBank = new questionBank[]{

            new questionBank(R.string.Question_1,true),
            new questionBank(R.string.Question_2,true),
            new questionBank(R.string.Question_3,true),
            new questionBank(R.string.Question_4,true),
            new questionBank(R.string.Question_5,true)

    };
    final int PROGRESS_BAR_INCREMENT =(int) Math.ceil(100.0/mQuestionBank.length);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);





        mTrue_Button = (Button) findViewById(R.id.true_button);
        mFalse_Button= (Button) findViewById(R.id.false_button);
        mNext_Button= (Button) findViewById(R.id.next_Button);
        mQuestion_Textview = (TextView) findViewById(R.id.question_textView);
        mScoreTextView = (TextView) findViewById(R.id.score_textView);
        mProgressBar = (ProgressBar) findViewById(R.id.progressBar);



        int question = mQuestionBank[mCurrentIndex].getQuestionID();
        mQuestion_Textview.setText(question);





        mTrue_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(true);
            }
        });


        mFalse_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(false);
            }
        });
        mNext_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentIndex = (mCurrentIndex + 1) % mQuestionBank.length;

                if (mCurrentIndex ==0){
                    AlertDialog.Builder alert = new AlertDialog.Builder(getApplicationContext());
                    alert.setTitle("Game Over");
                    alert.setMessage("Happy");

                    alert.show();
                }
                updateQuestion();

            }
        });

    }

    public void checkAnswer(boolean myAnswer){
        boolean correctAnswer = mQuestionBank[mCurrentIndex].isAnswerID();

        int  mCurrentAnswerIndex =0;

        if (myAnswer == correctAnswer ){
            mCurrentAnswerIndex = R.string.correct_Toast;
            mScore = mScore +1;


        }else {
            mCurrentAnswerIndex = R.string.inCorrect_Toast;

        }
        Toast.makeText(this, mCurrentAnswerIndex,Toast.LENGTH_SHORT).show();

    }

    public void updateQuestion(){
        int question = mQuestionBank[mCurrentIndex].getQuestionID();
        mQuestion_Textview.setText(question);
        mScoreTextView.setText((String.valueOf(mScore)));
        mProgressBar.incrementProgressBy(PROGRESS_BAR_INCREMENT);

    }
}

