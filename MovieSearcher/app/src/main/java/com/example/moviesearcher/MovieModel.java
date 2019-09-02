package com.example.moviesearcher;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Date;

public class MovieModel  {

    private  String m_title, m_image;
    private int m_userRating;
    private Date m_pubDate;

    public String getM_title() {
        return m_title;
    }

    public void setM_title(String m_title) {
        this.m_title = m_title;
    }

    public String getM_image() {
        return m_image;
    }

    public void setM_image(String m_image) {
        this.m_image = m_image;
    }

    public int getM_userRating() {
        return m_userRating;
    }

    public void setM_userRating(int m_userRating) {
        this.m_userRating = m_userRating;
    }

    public Date getM_pubDate() {
        return m_pubDate;
    }

    public void setM_pubDate(Date m_pubDate) {
        this.m_pubDate = m_pubDate;
    }
}
