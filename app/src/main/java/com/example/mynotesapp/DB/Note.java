package com.example.mynotesapp.DB;

import java.util.Date;

public class Note {
    public String name;
    public String description;
    public Date createDate;
    public int priority;

    public Note(String name, String description, Date createDate, int priority) {
        this.name = name;
        this.description = description;
        this.createDate = createDate;
        this.priority = priority;
    }


}
