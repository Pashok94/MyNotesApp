package com.example.mynotesapp.DB;

import java.util.List;

public interface DataBaseProcessible {
    List getNotesList();
    void addNote(Note note);
}
