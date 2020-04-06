package com.example.lab6;

import android.content.Context;
import android.content.Intent;

import java.util.ArrayList;

public class Retrieve {

    private LabDatabase database;


    public void retrieveAsync(Context context){
        ArrayList<String> personNames = new ArrayList<>();

        ArrayList<Person> persons = (ArrayList)database.personDao().getAllPersons();

        for(Person p: persons) {
            personNames.add(p.getName());
        }

        Intent i = new Intent(context, PersonsActivity.class);
        i.putExtra("Persons", personNames);
        context.startActivity(i);

    }
}
