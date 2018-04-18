package com.example.yadin.exercise6;

import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity  implements NotesAdapter.NotesAdapterInteraction {

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
        mNotesAdapter = new NotesAdapter(mNotes,this);
        notesRecyclerView.setLayoutManager(mLayoutManager);
        notesRecyclerView.setAdapter(mNotesAdapter);
    }

    private void generatNewNotesList() {
        mNotes = new ArrayList<Note>();

        for(int i = 0 ; i< 10; i++){
            mNotes.add(new Note("yadin", "you are the best",i));
        }
    }

    @Override
    public void onDeleteNote(Note note) {
        Log.d("xxx", note.getTitle() );
        Toast.makeText(this,"item clickd",Toast.LENGTH_LONG).show();
    }
}
