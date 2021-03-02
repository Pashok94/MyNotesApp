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
import com.example.mynotesapp.DB.Note;
import com.example.mynotesapp.R;

public class FragmentNoteDescription extends Fragment {
    public static final String INDEX_DESC_EXTRA = "desc_extra";
    private TextView textView;
    DataBase db;

    public static FragmentNoteDescription newInstance(int index) {
        FragmentNoteDescription fragment = new FragmentNoteDescription();
        Bundle bundle = new Bundle();
        bundle.putInt(INDEX_DESC_EXTRA, index);
        fragment.setArguments(bundle);
        return fragment;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_note_description, null);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        textView = view.findViewById(R.id.text_desc);
        db = DataBase.getInstance();
        int index = getArguments().getInt(INDEX_DESC_EXTRA);
        textView.setText(((Note)db.getNotesList().get(index)).description);
    }

}