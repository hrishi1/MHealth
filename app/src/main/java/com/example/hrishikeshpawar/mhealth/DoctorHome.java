package com.example.hrishikeshpawar.mhealth;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class DoctorHome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_home);
    }

    public void clickSearch(View view)
    {
        Intent intent = new Intent(this, PatientHome.class);
        startActivity(intent);
    }

    public void clickAdd(View view)
    {
        Intent intent = new Intent(this, AddPatient.class);
        startActivity(intent);
    }
}
