package com.example.moviesearcher;

import java.net.URLEncoder;
import java.util.ArrayList;

public class Parser {

    MovieModel mo;
    String myQuery="";

    public ArrayList<MovieModel> connectNaver(  ArrayList<MovieModel> list){
        try {

            myQuery = URLEncoder.encode(MainActivity.search.getText().toString(), "utf8");
            int count =1;
            String urlStr ="https://";
        }catch (Exception e){

        }

    return list;
    }
}
