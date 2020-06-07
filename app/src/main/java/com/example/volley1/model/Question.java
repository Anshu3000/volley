package com.example.volley1.model;

public class Question {
    private String Ques;
    private boolean ans;

    public Question() {
    }

    public Question(String ques, boolean ans) {
        this.Ques = ques;
        this.ans = ans;
    }

    public String getQues() {
        return Ques;
    }

    public void setQues(String ques) {
        Ques = ques;
    }

    public boolean isAns() {
        return ans;
    }

    public void setAns(boolean ans) {
        this.ans = ans;
    }
}
