package com.example.yadin.exercise6;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yadin on 18/04/2018.
 */

public class NotesAdapter extends RecyclerView.Adapter<NoteViewHolder> implements View.OnClickListener{

    List<Note> mNotes;
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
        holder.bindViewHolder(mNotes.get(position),this, position);
    }

    @Override
    public int getItemCount() {
        return mNotes == null ?  0 : mNotes.size();
    }


    @Override
    public void onClick(View view) {
        int position = (int) view.getTag();
        Note note = mNotes.get(position);
        mListener.onDeleteNote(note);
        mNotes.remove(note);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, mNotes.size());
    }

    public void updateList(List<Note> updatedList) {
        mNotes = updatedList;
        notifyDataSetChanged();
    }

    public void updateItem(Note note) {
        mNotes.add(note);
        notifyDataSetChanged();
    }


    public interface NotesAdapterInteraction {
        void onDeleteNote(Note note);
    }
}
