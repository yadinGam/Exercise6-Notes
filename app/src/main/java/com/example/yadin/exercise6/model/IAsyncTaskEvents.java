package com.example.yadin.exercise6.model;

import com.example.yadin.exercise6.model.Note;

import java.util.List;

/**
 * Created by yadin on 21/04/2018.
 */

public interface IAsyncTaskEvents {

    //this is when the task ended
    void onPostExecute(List<Note> notes);

    void onPostExecute(Note note);

    void onPostExecute();

}
