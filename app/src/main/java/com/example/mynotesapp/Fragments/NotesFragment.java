package com.example.mynotesapp.Fragments;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.mynotesapp.DB.DataBase;
import com.example.mynotesapp.DB.Note;
import com.example.mynotesapp.NoteDescActivity;
import com.example.mynotesapp.R;

import java.util.ArrayList;

public class NotesFragment extends Fragment {
    private DataBase db = DataBase.getInstance();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_notes, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
    }

    private void initView(View view) {
        LinearLayout linearLayout = (LinearLayout) view;
        final Note[] array = (Note[]) db.getNotesList().toArray(new Note[db.getNotesList().size()]);
        Log.d("1", String.valueOf(array.length));

        for (int i = 0; i < array.length; i++) {
            String note = String.format("%s, создана: %s", array[i].name, array[i].createDate.toString());
            TextView textView = new TextView(linearLayout.getContext());
            textView.setText(note);
            textView.setTextSize(20f);
            setViewColorByPriority(textView, array[i].priority);
            textView.setPadding(10, 0, 10, 10);
            final int finalI = i;
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startDecsActivity(finalI);
                }
            });
            linearLayout.addView(textView);
        }
    }

    private void startDecsActivity(int noteIndex){
        ArrayList<Note> list = (ArrayList<Note>) db.getNotesList();
        Intent intent = new Intent(getContext(), NoteDescActivity.class);
        intent.putExtra(NoteDescActivity.DESC_EXTRA, list.get(noteIndex).description);
        startActivity(intent);
    }
    @SuppressLint("ResourceAsColor")
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