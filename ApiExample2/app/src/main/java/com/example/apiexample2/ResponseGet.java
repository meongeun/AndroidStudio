package com.example.apiexample2;

import java.util.HashMap;

public class ResponseGet {

    public final int userId;
    public final int id;
    public final String title;
    public final String body;

    public ResponseGet(int id, String body, String title, int userId){
        this.id=id;
        this.userId=userId;
        this.body=body;
        this.title=title;
    }
}
