package com.example.hrishikeshpawar.mhealth;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class PatientHome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_home);
    }

    public void clickAdd(View view)
    {
        Intent intent = new Intent(this, AddVisit.class);
        startActivity(intent);
    }
}
