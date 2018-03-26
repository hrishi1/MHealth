package com.example.hrishikeshpawar.mhealth;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.MultiAutoCompleteTextView;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class AddVisit extends AppCompatActivity {

    private LinearLayout mLayout;
    private LinearLayout mLayout1;
    private ImageView mButton;
    private TextView sTime;
    private MultiAutoCompleteTextView mDiagnosis;
    private EditText mName1,mName2,mName3;
    private EditText mDays1,mDays2,mDays3;
    private EditText mPer1, mPer2,mPer3;
    private Date c;
    public String mN1,mN2,mN3,mP1,mP2,mP3,mDiag, mDate;
    public int mD1,mD2,mD3;
    int count = 1;

    private FirebaseDatabase mDatabase;
    private DatabaseReference mReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_visit);
        mLayout = (LinearLayout) findViewById(R.id.linearLayout2);
        mLayout1 = (LinearLayout) findViewById(R.id.linearLayout3);
        mButton = (ImageView) findViewById(R.id.addButton);
        sTime = (TextView) findViewById(R.id.sTime);
        mDatabase = FirebaseDatabase.getInstance();
        mReference = mDatabase.getReference().child("visit");
        mName1 = (EditText) findViewById(R.id.mName1);
        mName2 = (EditText) findViewById(R.id.mName2);
        mName3 = (EditText) findViewById(R.id.mName3);
        mDays1 = (EditText) findViewById(R.id.mDays1);
        mDays2 = (EditText) findViewById(R.id.mDays2);
        mDays3 = (EditText) findViewById(R.id.mDays3);
        mPer1 = (EditText) findViewById(R.id.mPer1);
        mPer2 = (EditText) findViewById(R.id.mPer2);
        mPer3 = (EditText) findViewById(R.id.mPer3);
        mDiagnosis =(MultiAutoCompleteTextView) findViewById(R.id.sDiagnosis);

        c = Calendar.getInstance().getTime();
        sTime.setText(c.toString().substring(0,20));
    }

    public void clickAdd(View v) {
        count++;

        if(count==2)
        {
            mLayout.setVisibility(View.VISIBLE);
        }

        else if(count==3)
        {
            mLayout1.setVisibility(View.VISIBLE);
        }
        /*LinearLayout layout1 = new LinearLayout(this);
        layout1.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        layout1.setOrientation(LinearLayout.HORIZONTAL);
        //layout.setId(R.id.layout1);


        layout1.addView(createNewTextView());
        layout1.addView(createNewTextView());

        Log.i("Test", "HERE");
       //mLayout.addView(createNewTextView());*/
    }

    public void clickSubmit(View v)
    {
        mN1 = mName1.getText().toString();
        mN2 = mName2.getText().toString();
        mN3 = mName3.getText().toString();

        mP1 = mPer1.getText().toString();
        mP2 = mPer2.getText().toString();
        mP3 = mPer3.getText().toString();

        mDiag = mDiagnosis.getText().toString();
        mDate = c.toString().substring(0,20) + c.toString().substring(c.toString().length() -4 , c.toString().length());

        Visit visit = new Visit();

        if(count==1)
        {
            mD1 = Integer.parseInt(mDays1.getText().toString());
            visit = new Visit(mDiag, mDate, mN1, mD1, mP1, null, 0, null, null, 0, null);
        }

        else if(count==2)
        {
            mD1 = Integer.parseInt(mDays1.getText().toString());
            mD2 = Integer.parseInt(mDays2.getText().toString());

            visit = new Visit(mDiag, mDate, mN1, mD1, mP1, mN2, mD2, mP2, null, 0, null);
        }

        else if(count==3)
        {
            mD1 = Integer.parseInt(mDays1.getText().toString());
            mD2 = Integer.parseInt(mDays2.getText().toString());
            mD3 = Integer.parseInt(mDays3.getText().toString());

            visit = new Visit(mDiag, mDate, mN1, mD1, mP1, mN2, mD2, mP2, mN3, mD3, mP3);
        }

        mReference.push().setValue(visit);
    }

    private TextView createNewTextView() {
        final LinearLayout.LayoutParams lparams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        final TextView textView = new TextView(this);
        textView.setLayoutParams(lparams);
        textView.setText("Medicine "+count++);
        textView.setTextSize(TypedValue.COMPLEX_UNIT_SP,25);
        textView.layout(20, 0, 0, 0);
        textView.setTypeface(null, Typeface.BOLD);
        Log.i("Test", "HERE1");
        return textView;
    }
}
