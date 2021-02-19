package com.example.mynotesapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.TextView;

import com.example.mynotesapp.Fragments.FragmentNoteDescription;

public class NoteDescActivity extends AppCompatActivity {
    public static final String DESC_EXTRA = "note_desc";
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_desc);
        textView = findViewById(R.id.note_desc);
        textView.setText(getIntent().getStringExtra(DESC_EXTRA));

        if (savedInstanceState == null) {
            int index = getIntent().getIntExtra(DESC_EXTRA, 0);
            FragmentNoteDescription fragment = FragmentNoteDescription.newInstance(index);

            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.descriptioin_layout, fragment);
            fragmentTransaction.commit();
        }
    }
}