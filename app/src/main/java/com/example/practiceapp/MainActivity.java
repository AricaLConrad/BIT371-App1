package com.example.practiceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // Go to the second activity when the button is pressed.
    public void goToUserConfirmationActivity(View view) {

        // Save whatever the user types into the username and password fields.
        EditText username = findViewById(R.id.username);
        Log.i("INFO", "Username: " + username.getText().toString());
        EditText password = findViewById(R.id.password);
        Log.i("INFO", "Password: " + password.getText().toString());

        // Convert both username and password to a string.
        String myUsername = username.getText().toString();
        String myPassword = password.getText().toString();

        // Start the intent, passing the two strings to the second activity.
        Log.i("INFO", "Transitioning to " + UserConfirmationActivity.class.getName());
        Intent intent = new Intent(getApplicationContext(), UserConfirmationActivity.class);
        intent.putExtra("Username", myUsername);
        intent.putExtra("Password", myPassword);
        startActivity(intent);
    }
}