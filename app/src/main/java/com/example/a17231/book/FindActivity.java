package com.example.a17231.book;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class FindActivity extends AppCompatActivity {

    private ImageButton imageButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find);
        imageButton=(ImageButton)findViewById(R.id.imageButton_devoteBook);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent  = new Intent(FindActivity.this,DemoActivity.class);
                startActivity(intent);
            }
        });
    }
}
