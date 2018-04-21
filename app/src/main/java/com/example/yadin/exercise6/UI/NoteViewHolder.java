package com.example.yadin.exercise6.UI;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.yadin.exercise6.R;
import com.example.yadin.exercise6.model.Note;

/**
 * Created by yadin on 18/04/2018.
 */

class NoteViewHolder extends RecyclerView.ViewHolder {
    public final View mView;
    public final TextView titleTV;
    public final TextView bodyTV;

    public NoteViewHolder(View itemView) {
        super(itemView);
        this.mView = itemView;
        this.titleTV = itemView.findViewById(R.id.rowTitleTextView);
        this.bodyTV = itemView.findViewById(R.id.rowBodyTextView);
    }

    public void bindViewHolder(Note note, View.OnClickListener listener, int position){
        titleTV.setText(note.getTitle());
        bodyTV.setText(note.getBody());
        mView.setOnClickListener(listener);
        mView.setTag(position);

    }

}
