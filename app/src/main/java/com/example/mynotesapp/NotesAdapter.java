package com.example.mynotesapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mynotesapp.DB.Note;
import com.google.android.material.textview.MaterialTextView;

import java.util.ArrayList;
import java.util.List;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.NotesViewHolder>{
    private final List<Note> notes = new ArrayList<>();

    public void setItems(List<Note> notes){
        this.notes.clear();
        this.notes.addAll(notes);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public NotesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_note, parent, false);
        return new NotesViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull NotesViewHolder holder, int position) {
        holder.onBind(notes.get(position), position);
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    class NotesViewHolder extends RecyclerView.ViewHolder{
        private MaterialTextView tv;
        public NotesViewHolder(@NonNull View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.tw_item_name);
        }

        public void onBind(Note note, int position){
            tv.setText(note.name);
            setViewColorByPriority(tv, note.priority);
        }

        private void setViewColorByPriority(View v, int priority){
            switch (priority){
                case 1:
                    v.setBackgroundResource(R.color.colorPriority1);
                    break;
                case 2:
                    v.setBackgroundResource(R.color.colorPriority2);
                    break;
                case 3:
                    v.setBackgroundResource(R.color.colorPriority3);
                    break;
            }
        }
    }
}
