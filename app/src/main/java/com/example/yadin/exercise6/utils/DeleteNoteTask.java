package com.example.yadin.exercise6.utils;

import android.os.AsyncTask;

import com.example.yadin.exercise6.UI.MainActivity;
import com.example.yadin.exercise6.database.NoteDao;
import com.example.yadin.exercise6.model.IAsyncTaskEvents;
import com.example.yadin.exercise6.model.Note;

/**
 * Created by yadin on 21/04/2018.
 */

public class DeleteNoteTask extends AsyncTask<Note, Void, Note> {

    private NoteDao mNoteDao;
    private IAsyncTaskEvents mIAsyncTaskEvents;

    public DeleteNoteTask(MainActivity mainActivity, NoteDao noteDao) {
        this.mNoteDao = noteDao;
        this.mIAsyncTaskEvents = mainActivity;
    }


    @Override
    protected Note doInBackground(Note... notes) {
        mNoteDao.delete(notes[0]);
        return notes[0];
    }

    @Override
    protected void onPostExecute(Note note) {
        mIAsyncTaskEvents.onPostExecute();
    }
}
