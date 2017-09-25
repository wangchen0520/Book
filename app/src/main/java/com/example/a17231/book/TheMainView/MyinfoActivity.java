package com.example.a17231.book.TheMainView;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.a17231.book.AboutMeActivity;
import com.example.a17231.book.PersonalMessageActivity;
import com.example.a17231.book.R;

public class MyinfoActivity extends AppCompatActivity implements View.OnClickListener{
    Button button_myrelativation;

    private Button myInto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myinfo);
        button_myrelativation = (Button) findViewById(R.id.button_myrelativation);
        myInto=(Button)findViewById(R.id.button_myinfo);
        button_myrelativation.setOnClickListener(this);
        myInto.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent();
        switch (view.getId()) {
            case R.id.button_myrelativation:
                intent.setClass(MyinfoActivity.this, AboutMeActivity.class);
                startActivity(intent);
                break;
            case R.id.button_myinfo:
                intent.setClass(MyinfoActivity.this, PersonalMessageActivity.class);
                startActivity(intent);
                break;
            default:
        }
    }
}
