package com.example.practiceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class UserConfirmationActivity extends AppCompatActivity {

    // Hard code the correct values for the username and password.
    private String username = "AricaC";
    private String password = "12345";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_confirmation);

        // Find the text box.
        TextView messageText = findViewById(R.id.messageTextView);

        // Save the strings that were passed from the intent.
        String sentUsername = getIntent().getStringExtra("Username");
        String sentPassword = getIntent().getStringExtra("Password");

        // If the username and password are both correct, display a welcome message.
        if (username.equals(sentUsername) && password.equals(sentPassword))
        {
            messageText.setText("Hello " + username + "!");
        }
        // Otherwise, display a message saying the username and password combination is incorrect.
        else
        {
            messageText.setText("Username/Password combination is incorrect.");
        }
    }

}