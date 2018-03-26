package com.example.hrishikeshpawar.mhealth;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class SearchPatient extends AppCompatActivity {

    private FirebaseDatabase mDatabase;
    private DatabaseReference mReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_patient);

        mDatabase = FirebaseDatabase.getInstance();
        mReference = mDatabase.getReference().child("patient");
    }

    public void clickSearch(View v)
    {
        mReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Patient p = dataSnapshot.getValue(Patient.class);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }

}
