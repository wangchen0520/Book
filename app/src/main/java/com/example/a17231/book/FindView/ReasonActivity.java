package com.example.a17231.book.FindView;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.a17231.book.R;

public class ReasonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reason);
        ActionBar actionbar=getSupportActionBar();
        if(actionbar!=null){
            actionbar.hide();
        }
        Button back2=(Button)findViewById(R.id.back2);
        back2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent  intent = new Intent(ReasonActivity.this,GoodbookActivity.class);
                startActivity(intent);
            }
        });
    }
}
