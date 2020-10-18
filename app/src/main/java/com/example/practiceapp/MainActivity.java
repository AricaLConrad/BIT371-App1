package com.example.practiceapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

// ------------------------------------------------

// The following section contains notes from some of the slides.
// It is useful to me to leave them here so I can see what everything means next to the actual code.

// Notes from the RecyclerView & Adapter slide:
// - RecyclerView manages the overall list.
// - LayoutManager arranges the list; use existing or create your own.
// - ViewHolder objects represent list views; you create from RecyclerView.ViewHolder;
// - Adapter manages ViewHolder objects; you create from RecyclerView.Adapter.

// Notes from the Step-by-Step RecyclerView slide (essentially what this exercise is about):
// 1. Add the support library.
// 2. Define model class for the data.
// 3. Add RecyclerView to your layout via XML.
// 4. Create layout XML file to visualize an item.
// 5. Create a RecyclerView.Adapter containing a ViewHolder to render an item.
// 6. Bind the adapter to the data source to populate the RecyclerView.
// 7. Assign the adapter a Layout Manager.

// ------------------------------------------------

public class MainActivity extends AppCompatActivity {

    // Create a list of contacts.
    ArrayList<Contact> contacts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Look up the recyclerview in activity layout
        // In other words, reference the RecyclerView located in the activity_main.xml file.
        RecyclerView rvContacts = (RecyclerView) findViewById(R.id.rvContacts);

        // Initialize contacts
        // In other words, this passes in the value 20 to the method createContactsList, which will
        // create 20 new contacts.
        contacts = Contact.createContactsList(20);
        // Create adapter passing in the sample user data
        // In other words, create a new adapter, passing in the list of contacts that were created.
        ContactAdapter adapter = new ContactAdapter(contacts);
        // Attach the adapter to the recyclerview to populate items
        // In other words, connect the adapter to the RecyclerView layout to fill with records.
        rvContacts.setAdapter(adapter);
        // Set layout manager to position the items
        // In other words, the list is being displayed in a linear vertical layout.
        rvContacts.setLayoutManager(new LinearLayoutManager(this));
    }
}