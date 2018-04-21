package com.example.yadin.exercise6;

import android.os.AsyncTask;

import com.example.yadin.exercise6.database.NoteDao;

import java.util.List;

/**
 * Created by yadin on 21/04/2018.
 */

public class GetAllNotesTask extends AsyncTask<Void, Void, List<Note>> {

    private IAsyncTaskEvents mIAsyncTaskEvents;
    private NoteDao mNoteDao;

    public GetAllNotesTask(MainActivity mainActivity, NoteDao mNoteDao) {
        this.mIAsyncTaskEvents = mainActivity;
        this.mNoteDao = mNoteDao;
    }

    @Override
    protected List<Note> doInBackground(Void... voids) {
        return mNoteDao.getAll();
    }

    @Override
    protected void onPostExecute(List<Note> notes) {
        mIAsyncTaskEvents.onPostExecute(notes);
    }
}
