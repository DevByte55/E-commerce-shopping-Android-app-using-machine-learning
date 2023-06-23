package com.app.shoprecommendationsystem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.app.shoprecommendationsystem.Model.Feedback;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class FeedbackActivity extends AppCompatActivity {
    private EditText categoryNameEditText, pedAddressEditText, pNameEditText, feedbackEditText;
    private Button submitButton;
    private DatabaseReference feedbackRef;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        // Initialize Firebase Realtime Database reference
        feedbackRef = FirebaseDatabase.getInstance().getReference("Feedbacks");

        // Initialize UI elements
        categoryNameEditText = findViewById(R.id.category_name_edit_text);
        pedAddressEditText = findViewById(R.id.ped_address_edit_text);
        pNameEditText = findViewById(R.id.pname_edit_text);
        feedbackEditText = findViewById(R.id.feedback_edittext);
        submitButton = findViewById(R.id.submit_button);

        // Set click listener for submit button
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get input values from UI elements
                String categoryName = categoryNameEditText.getText().toString().trim();
                String pedAddress = pedAddressEditText.getText().toString().trim();
                String pName = pNameEditText.getText().toString().trim();
                String feedback = feedbackEditText.getText().toString().trim();

                // Create Feedback object with input values
                Feedback userFeedback = new Feedback(categoryName, pedAddress, pName, feedback);

                // Push the Feedback object to Firebase Realtime Database
                feedbackRef.push().setValue(userFeedback);

                // Show success message to the user
                Toast.makeText(getApplicationContext(), "Feedback submitted!", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}