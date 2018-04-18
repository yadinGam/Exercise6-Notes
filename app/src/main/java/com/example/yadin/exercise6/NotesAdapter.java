package com.example.yadin.exercise6;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by yadin on 18/04/2018.
 */

public class NotesAdapter extends RecyclerView.Adapter<NoteViewHolder> implements View.OnClickListener{

    ArrayList<Note> mNotes;
    private final NotesAdapterInteraction mListener;

    public NotesAdapter(ArrayList<Note> notes,NotesAdapterInteraction notesAdapterInteraction) {
        this.mNotes = notes;
        this.mListener = notesAdapterInteraction;
    }


    @Override
    public NoteViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {


        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        View view = inflater.inflate(R.layout.note_row_item, parent, false);

        return new NoteViewHolder(view);

    }

    @Override
    public void onBindViewHolder(NoteViewHolder holder, int position) {
        holder.bindViewHolder(mNotes.get(position),this,position);



    }

    @Override
    public int getItemCount() {
        return mNotes == null ?  0 : mNotes.size();
    }

    public void setNotes(ArrayList<Note> notes) {
        this.mNotes = notes;
        notifyDataSetChanged();
    }

    @Override
    public void onClick(View view) {
        Log.d("xxx", String.valueOf((int) view.getTag()));
        mListener.onDeleteNote(mNotes.get((int) view.getTag()));
    }

    public interface NotesAdapterInteraction {
        void onDeleteNote(Note note);
    }
}
