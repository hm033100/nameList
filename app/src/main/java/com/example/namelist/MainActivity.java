package com.example.namelist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    Button b_add;
    EditText et_addName;
    ListView lv_listOfNames;

    //create empty List of type String
    List<String> friends = new ArrayList<String>();
    //create Array of type string holding 4 names in alphabetical order
    String [] startingList = {"Aaron", "Ben", "Collin", "Dan"};


    ArrayAdapter ad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        b_add = findViewById(R.id.b_add);
        et_addName = findViewById(R.id.et_addName);
        lv_listOfNames = findViewById(R.id.lv_listOfNames);
        //convert Array to Array List using asList function. set the empty List of type String to the Array holding the four names
        friends = new ArrayList<String>(Arrays.asList(startingList));

        ad = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1 ,friends);

        lv_listOfNames.setAdapter(ad);


        b_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //create string that holds the new value entered in by the user.
                String newName = et_addName.getText().toString();
                //add the string holding the new name into the List of type String
                friends.add(newName);
                Collections.sort(friends);


                //tell the list adapter we've updated it
                ad.notifyDataSetChanged();

                et_addName.setText("");


            }
        });


        //display position of contact and name when a certain contact is clicked in the running app that's apart of the list.
        lv_listOfNames.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "position = " + position + ", name = "
                        + friends.get(position), Toast.LENGTH_SHORT).show();
            }
        });



    }
}
