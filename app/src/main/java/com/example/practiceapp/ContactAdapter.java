package com.example.practiceapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

// ------------------------------------------------

// The following section contains notes from some of the slides.
// It is useful to me to leave them here so I can see what everything means next to the actual code.

// Notes from the RecyclerView & Adapter slide:
// - RecyclerView manages the overall list.
// - LayoutManager arranges the list; use existing or create your own.
// - ViewHolder objects represent list views; you create from RecyclerView.ViewHolder;
// - Adapter manages ViewHolder objects; you create from RecyclerView.Adapter.

// Notes from the RecyclerView.Adapter slide:
// - Created as its own class extending RecyclerView.Adapter<ViewHolder>.
// - Constructor receives the data-set as a parameter.
// - Contains the ViewHolder as public class.
// - Overrides three methods:
//      1. getItemCount() - from data.
//      2. onCreateViewHolder() - creates a view from XML, returns a ViewHolder.
//      3. onBindViewHolder() - replaces the contents of the view with data.
// - Contains the Listener Interface to handle selection events.

// ------------------------------------------------

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactRow>
{
    // List of contacts.
    private List<Contact> mContacts;

    @NonNull
    @Override
    public ContactRow onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflaters can treat a collection of objects and widgets as one View object.
        // The last part of this line means the parent's layout.
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        // Inflate the custom layout
        // In other words, create a new combined layout with all of the other layouts we have.
        // Or, as the professor says, this turns the layout into a contactView.
        View contactView = inflater.inflate(R.layout.item_contact, parent, false);

        // Return a new holder instance
        ContactRow viewHolder = new ContactRow(contactView);
        return viewHolder;
    }

    // This binds the data to the TextView (the contact name) and the button and puts it into order
    // based on the index of the record.
    @Override
    public void onBindViewHolder(@NonNull ContactRow holder, int position) {
        // Get the data model based on position
        Contact contact = mContacts.get(position);

        // Set item views based on your views and data model
        TextView textView = holder.nameTextView;
        textView.setText(contact.getName());
        Button button = holder.messageButton;
        // The last part means if true, set the text to "Message," otherwise set the text to "Offline."
        button.setText(contact.isOnline() ? "Message" : "Offline");
        button.setEnabled(contact.isOnline());
    }

    // Returns the number of contacts.
    @Override
    public int getItemCount() {
        return mContacts.size();
    }

    // This is the constructor, where the list of contacts is set equal to list variable created earlier.
    public ContactAdapter(List<Contact> contacts) {
        mContacts = contacts;
    }

    // =======================================================
    // The ViewHolder:
    // Provide a direct reference to each of the views within a data item
    // Used to cache the views within the item layout for fast access

    // In other words, for each record, this will access the name of the contact (the TextView)
    // and the online/offline button and store those references for future use.

    public class ContactRow extends RecyclerView.ViewHolder {
        // Your holder should contain a member variable
        // for any view that will be set as you render a row
        public TextView nameTextView;
        public Button messageButton;

        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each subview
        public ContactRow(View itemView) {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance
            super(itemView);

            // Accesses the contact name and button.
            nameTextView = (TextView) itemView.findViewById(R.id.contact_name);
            messageButton = (Button) itemView.findViewById(R.id.message_button);
        }
    }
}
