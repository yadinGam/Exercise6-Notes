package com.example.yadin.exercise6;

import android.support.annotation.NonNull;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.yadin.exercise6.database.AppDatabase;

import java.util.List;

public class MainActivity extends AppCompatActivity implements NotesAdapter.NotesAdapterInteraction, View.OnClickListener, IAsyncTaskEvents {

    private RecyclerView notesRecyclerView;
    private TextInputEditText titleIET;
    private TextInputEditText bodyIET;
    private Button addNoteBtn;

    private LinearLayoutManager mLayoutManager;
    private NotesAdapter mNotesAdapter;
    private AppDatabase db;
    private Note note;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = AppDatabase.getAppDatabase(this);
        initViews();
    }

    @Override
    protected void onDestroy() {
        AppDatabase.destroyInstance();
        super.onDestroy();
    }

    private void initViews() {

        titleIET = findViewById(R.id.etTitle);
        bodyIET = findViewById(R.id.etBody);
        addNoteBtn = findViewById(R.id.addButton);
        addNoteBtn.setOnClickListener(this);

        initRecyclerView();
    }

    private void initRecyclerView() {
        notesRecyclerView = findViewById(R.id.notes_recycler_view);
        mLayoutManager = new LinearLayoutManager(this);
        mNotesAdapter = new NotesAdapter(null, this);

        getNoteList();

        notesRecyclerView.setLayoutManager(mLayoutManager);
        notesRecyclerView.setAdapter(mNotesAdapter);
    }


    @Override
    public void onDeleteNote(Note note) {
        Log.d("deleted note", note.getTitle());
        Toast.makeText(this, "item clicked", Toast.LENGTH_LONG).show();

        new DeleteNoteTask(this,db.noteDao()).execute(note);

//        new AsyncTask<Note, Void, Void>() {
//
//            @Override
//            protected Void doInBackground(Note... notes) {
//                db.noteDao().delete(notes[0]);
//                mNotesAdapter.notifyDataSetChanged();
//                return null;
//            }
//        }.execute(note);


    }


    @Override
    public void onClick(View view) {
        onAddNoteBtnClick();
    }

    private void onAddNoteBtnClick() {

        String title = titleIET.getText().toString();
        String body = bodyIET.getText().toString();

        if (TextUtils.isEmpty(title)) {
            titleIET.setError("empty title");
            return;
        }

        if (TextUtils.isEmpty(body)) {
            bodyIET.setError("empty body");
            return;
        }

        note = createNote(title, body);

        new InsertNoteTask(db.noteDao(),this).execute(note);

//        new AsyncTask<Note,Void,Void>() {
//
//            @Override
//            protected Void doInBackground(Note... notes) {
//                db.noteDao().insert(notes[0]);
//                return null;
//            }
//        }.execute(note);

  //      getNoteList();

        titleIET.getText().clear();
        titleIET.requestFocus();
        bodyIET.getText().clear();

    }

    private void getNoteList() {

//        new AsyncTask<Void,Void,List<Note>>() {
//
//            @Override
//            protected List<Note> doInBackground(Void... voids) {
//                return db.noteDao().getAll();
//            }
//
//            @Override
//            protected void onPostExecute(List<Note> notes) {
//                List<Note> updatedList = notes;
//                mNotesAdapter.updateList(updatedList);
//            }
//        }.execute();
        new GetAllNotesTask(this, db.noteDao()).execute();
    }

    @NonNull
    private Note createNote(String title, String body) {
        Note note = new Note();
        note.setTitle(title);
        note.setBody(body);
        return note;
    }


    @Override
    public void onPostExecute(List<Note> notes) {
        mNotesAdapter.updateList(notes);
        Toast.makeText(this, "Got All From DB", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPostExecute(Note note) {
        Toast.makeText(this, "1 note added", Toast.LENGTH_LONG).show();
        mNotesAdapter.updateItem(note);
    }

    @Override
    public void onPostExecute() {
        Toast.makeText(this, "1 note deleted", Toast.LENGTH_LONG).show();
    }
}
