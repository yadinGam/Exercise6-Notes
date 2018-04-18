package com.example.yadin.exercise6;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by yadin on 18/04/2018.
 */

class NoteViewHolder extends RecyclerView.ViewHolder {

    private TextView titleTV;
    private TextView bodyTV;

    public NoteViewHolder(View itemView, TextView titleTV, TextView bodyTV) {
        super(itemView);
        this.titleTV = titleTV;
        this.bodyTV = bodyTV;
    }

    public void bindViewHolder(Note note){
        titleTV.setText(note.getTitle());
        bodyTV.setText(note.getBody());
    }

}
