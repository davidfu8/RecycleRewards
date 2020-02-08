package com.example.myfirstapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    TextView testTV;
    Button button1;
    Button button2;
    DatabaseReference myRef = FirebaseDatabase.getInstance().getReference();
    DatabaseReference condRef = myRef.child("condition");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get UI elements
        testTV = (TextView)findViewById(R.id.testText);
        button1 = (Button)findViewById(R.id.button1);
        button2 = (Button)findViewById(R.id.button2);

    }



    protected void onStart() {
        super.onStart();

        condRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                //String text = dataSnapshot.getValue(String.class);
                //testTV.setText(text);
            }

            @Override
            public void onCancelled( DatabaseError databaseError) {

            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                condRef.setValue(1);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                condRef.setValue(2);
            }
        });
    }

    @Override
    public <T extends View> T findViewById(int id) {
        return super.findViewById(id);
    }
}
