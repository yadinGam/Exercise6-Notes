package com.example.yadin.exercise6;

import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView notesRecyclerView;
    private TextInputEditText titleIET;
    private TextInputEditText bodyIET;

    private LinearLayoutManager mLayoutManager;
    private NotesAdapter mNotesAdapter;
    private ArrayList<Note> mNotes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();


    }

    private void initViews() {

        titleIET = findViewById(R.id.etTitle);
        bodyIET = findViewById(R.id.etBody);
        initRecyclerView();
    }

    private void initRecyclerView() {

        generatNewNotesList();

        notesRecyclerView = findViewById(R.id.notes_recycler_view);
        mLayoutManager = new LinearLayoutManager(this);
        mNotesAdapter = new NotesAdapter(mNotes);
        notesRecyclerView.setLayoutManager(mLayoutManager);
        notesRecyclerView.setAdapter(mNotesAdapter);
    }

    private void generatNewNotesList() {
        mNotes = new ArrayList<Note>();
        mNotes.add(new Note("yadin", "you are the best"));
        mNotes.add(new Note("yadin", "you are the best"));
        mNotes.add(new Note("yadin", "you are the best"));
        mNotes.add(new Note("yadin", "you are the best"));
        mNotes.add(new Note("yadin", "you are the best"));
        mNotes.add(new Note("yadin", "you are the best"));
        mNotes.add(new Note("yadin", "you are the best"));
        mNotes.add(new Note("yadin", "you are the best"));
        mNotes.add(new Note("yadin", "you are the best"));
        mNotes.add(new Note("yadin", "you are the best"));
    }
}
