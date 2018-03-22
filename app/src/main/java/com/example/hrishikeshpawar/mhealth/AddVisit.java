package com.example.hrishikeshpawar.mhealth;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class AddVisit extends AppCompatActivity {

    private LinearLayout mLayout;
    private ImageView mButton;
    int count = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_visit);
        mLayout = (LinearLayout) findViewById(R.id.linearLayout);
        mButton = (ImageView) findViewById(R.id.addButton);
    }

    public void clickAdd(View v) {
       mLayout.addView(createNewTextView());
       mLayout.addView(createNewTextView());

    }

    private TextView createNewTextView() {
        final LinearLayout.LayoutParams lparams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        final TextView textView = new TextView(this);
        textView.setLayoutParams(lparams);
        textView.setText("Medicine "+count++);
        textView.setTextSize(TypedValue.COMPLEX_UNIT_SP,25);
        textView.layout(20, 0, 0, 0);
        textView.setTypeface(null, Typeface.BOLD);
        return textView;
    }
}
