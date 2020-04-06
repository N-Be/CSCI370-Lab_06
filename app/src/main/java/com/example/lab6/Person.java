package com.example.lab6;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Person {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String name;

    public Person(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public void setId(int temp){
        id = temp;
    }

    public int getId(){
        return this.id;
    }

    public String getName() {return this.name;}

    public void setName(String temp) {name = temp;}






}
