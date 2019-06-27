package com.pi.birthday.tables;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

@Entity
public class Colleague {
    @Id
    @GeneratedValue
    private int id;
    private long date;
    private String name;
    private String title;

    protected Colleague() {
    }

    public Colleague(long date, String name, String title) {
        this.date = date;
        this.name = name;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return new SimpleDateFormat("dd.MM.yyyy").format(new Date(date));
    }

    public void setDate(long date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
