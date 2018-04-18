package com.example.yadin.exercise6;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by yadin on 18/04/2018.
 */

public class NotesAdapter extends RecyclerView.Adapter<NoteViewHolder> {

    ArrayList<Note> notes;

    public NotesAdapter(ArrayList<Note> notes) {
        this.notes = notes;
    }


    @Override
    public NoteViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.note_row_item, parent, false);
        TextView titleTV = view.findViewById(R.id.rowTitleTextView);
        TextView bodyTV = view.findViewById(R.id.rowBodyTextView);
        return new NoteViewHolder(view,titleTV,bodyTV);
    }

    @Override
    public void onBindViewHolder(NoteViewHolder holder, int position) {
        holder.bindViewHolder(notes.get(position));
    }

    @Override
    public int getItemCount() {
        return notes == null ?  0 : notes.size();
    }

    public void setNotes(ArrayList<Note> notes) {
        this.notes = notes;
        notifyDataSetChanged();
    }
}
