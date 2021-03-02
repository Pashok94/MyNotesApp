package com.example.mynotesapp.Fragments;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.mynotesapp.DB.DataBase;
import com.example.mynotesapp.DB.Note;
import com.example.mynotesapp.NotesAdapter;
import com.example.mynotesapp.R;

public class NotesFragment extends Fragment {
    private DataBase db = DataBase.getInstance();
    private final NotesAdapter adapter = new NotesAdapter();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_notes, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        adapter.setItems(db.getNotesList());
    }

    private void initView(View view) {
        RecyclerView rv = view.findViewById(R.id.rv_notes);
        rv.setLayoutManager(new LinearLayoutManager(rv.getContext()));
        rv.setAdapter(adapter);

    }
//    private void showFragmentDesc(int noteIndex){
//        //проверка ориентации
//        FragmentNoteDescription fragment = FragmentNoteDescription.newInstance(noteIndex);
//        getFragmentManager().beginTransaction().replace(R.id.drawer_layout, fragment).addToBackStack(null).commit();
//    }
}