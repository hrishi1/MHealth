package com.example.hrishikeshpawar.mhealth;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddPatient extends AppCompatActivity {

    private EditText pName, pAge, pContact, pGender, pAddress;
    private FirebaseDatabase mDatabase;
    private DatabaseReference mReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_patient);

        mDatabase = FirebaseDatabase.getInstance();
        mReference = mDatabase.getReference().child("patient");

        pName = (EditText) findViewById(R.id.pName);
        pAge = (EditText) findViewById(R.id.pAge);
        pContact = (EditText) findViewById(R.id.pContact);
        pGender = (EditText) findViewById(R.id.pGender);
        pAddress = (EditText) findViewById(R.id.pAddress);
    }

    public void clickSubmit(View v)
    {
        Patient p = new Patient(pName.getText().toString(), pAddress.getText().toString(), pGender.getText().toString(), Integer.parseInt(pAge.getText().toString()), pContact.getText().toString(), null);

        mReference.push().setValue(p);
    }
}
