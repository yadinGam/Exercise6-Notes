package com.example.yadin.exercise6;

/**
 * Created by yadin on 18/04/2018.
 */

//this is the view model!!!!!!!!!!!!
public class Note {
    private String title;
    private String body;

    public Note(String title, String body) {
        this.title = title;
        this.body = body;
    }

    public Note(String title) {
        this.title = title;
        this.body = "";
    }

//    public Note(String body) {
//        this.title = "";
//        this.body = body;
//    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
