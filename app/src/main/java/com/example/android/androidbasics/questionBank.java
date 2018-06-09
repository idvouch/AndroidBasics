package com.example.android.androidbasics;

/**
 * Created by Obinna on 6/8/2018.
 */

public class questionBank {

    public int questionID;
    public boolean answerID;

    public questionBank(int questionID, boolean answerID) {
        this.questionID = questionID;
        this.answerID = answerID;
    }

    public int getQuestionID() {
        return questionID;
    }

    public void setQuestionID(int questionID) {
        this.questionID = questionID;
    }

    public boolean isAnswerID() {
        return answerID;
    }

    public void setAnswerID(boolean answerID) {
        this.answerID = answerID;
    }
}
