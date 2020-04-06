package com.example.lab6;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText entry;
    Button submit;
    Button show;
    LabDatabase database;
    int id = 1;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        submit = this.findViewById(R.id.submit);
        show = this.findViewById(R.id.show);
        entry = this.findViewById(R.id.entry);


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Person temp = new Person(entry.getText().toString(),id);
                id++;

                Insert insert = new Insert();
                insert.InsertAsync(database);

                Toast submitToast = Toast.makeText(getApplicationContext(),entry.getText() + " submitted", Toast.LENGTH_SHORT);
                submitToast.show();
            }
        });

        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Retrieve retrieve = new Retrieve();
                retrieve.retrieveAsync(getApplicationContext());


                Toast showToast = Toast.makeText(getApplicationContext(),"show",Toast.LENGTH_SHORT);
                showToast.show();
            }
        });




        database = Room.databaseBuilder(this, LabDatabase.class, "Database")
                .build();

    }
}
