package com.example.practiceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    // Create a string array filled with city names.
    private final String[] cities = {"Seattle", "Bothell", "Kirkland", "Bellevue", "Lynnwood", "Renton",
            "Redmond", "Spokane", "Vancouver", "Tacoma", "Olympia", "Bellingham", "Arlington",
            "Everett", "Woodinville", "Monroe", "New Castle", "Ballard", "Lacey"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create an array adapter with the information of the context of the current layout,
        // the layout we are actually using to create the list, the ID of the TextView in the layout
        // the list will be generated in, and the data, which in this case is a string array.
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.listview_layout, R.id.city, cities);

        // Reference the list.
        ListView lv = findViewById(R.id.city_list);

        // Set the adapter to the list.
        lv.setAdapter(adapter);

        // Create an on-click listener, just for practice.
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.i("INFO", "The index is: " + i);
            }
        });
    }
}