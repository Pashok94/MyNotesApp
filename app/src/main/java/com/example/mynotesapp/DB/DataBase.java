package com.example.mynotesapp.DB;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DataBase implements DataBaseProcessible{
    private ArrayList<Note> notesDB;
    private static DataBase dataBase;


    private DataBase() {
        notesDB = new ArrayList<>();
        notesDB.add(new Note("Note1", "Desc1", new Date(), 1));
        notesDB.add(new Note("Note2", "Desc2", new Date(), 2));
        notesDB.add(new Note("Note3", "Desc3", new Date(), 3));
        notesDB.add(new Note("Note4", "Desc4", new Date(), 1));
        notesDB.add(new Note("Note5", "Desc5", new Date(), 3));
    }

    public static DataBase getInstance(){
        if (dataBase == null){
            dataBase = new DataBase();
        }
        return dataBase;
    }

    @Override
    public List getNotesList() {
        return notesDB;
    }

    @Override
    public void addNote(Note note) {
        notesDB.add(note);
    }
}
