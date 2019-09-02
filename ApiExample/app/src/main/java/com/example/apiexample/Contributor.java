package com.example.apiexample;

public class Contributor {
    public final String title;
    public final String reservation_rate;
    public final String grade;

    public Contributor(String title, String reservation_rate, String grade){
        this.title=title;
        this.grade=grade;
        this.reservation_rate=reservation_rate;
    }
}
