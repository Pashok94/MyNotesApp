package com.example.mynotesapp.Fragments;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.mynotesapp.DB.DataBase;
import com.example.mynotesapp.NoteDescActivity;
import com.example.mynotesapp.R;

public class FragmentNoteDescription extends Fragment {
    DataBase db;

    public static FragmentNoteDescription newInstance(int index) {
        FragmentNoteDescription fragment = new FragmentNoteDescription();
        Bundle bundle = new Bundle();
        bundle.putInt(NoteDescActivity.DESC_EXTRA, index);
        fragment.setArguments(bundle);
        return fragment;
    }

    private TextView textView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_note_desc, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        textView = view.findViewById(R.id.note_desc);
        db = DataBase.getInstance();
    }

}