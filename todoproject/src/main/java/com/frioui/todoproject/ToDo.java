package com.frioui.todoproject;

import javax.persistence.Entity;

@Entity
public class ToDo {
    private long id;
    private String text;
    private boolean completed;

    public ToDo(long id, String text, boolean completed) {

        this.id = id;
        this.text = text;
        this.completed = completed;
    }
}
