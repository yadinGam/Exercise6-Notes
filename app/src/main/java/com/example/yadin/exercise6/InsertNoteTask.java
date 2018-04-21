package com.example.yadin.exercise6;

import android.os.AsyncTask;

import com.example.yadin.exercise6.database.NoteDao;

import java.util.List;

/**
 * Created by yadin on 21/04/2018.
 */

public class InsertNoteTask extends AsyncTask<Note, Void, Note> {

    private NoteDao mNoteDao;
    private IAsyncTaskEvents mIAsyncTaskEvents;

    public InsertNoteTask(NoteDao noteDao, MainActivity mainActivity) {
        this.mNoteDao = noteDao;
        this.mIAsyncTaskEvents = mainActivity;
    }

    @Override
    protected Note doInBackground(Note... notes) {
        mNoteDao.insert(notes[0]);
        return notes[0];
    }

    @Override
    protected void onPostExecute(Note note) {
        mIAsyncTaskEvents.onPostExecute(note);
    }
}
