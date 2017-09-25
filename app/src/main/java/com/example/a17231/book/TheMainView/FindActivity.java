package com.example.a17231.book.TheMainView;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

import com.example.a17231.book.FindView.BookDevoteActivity;
import com.example.a17231.book.FindView.BooktripActivity;
import com.example.a17231.book.FindView.GoodbookActivity;
import com.example.a17231.book.R;

public class FindActivity extends AppCompatActivity {

    private ImageButton imageButton1;
    private ImageButton imageButton2;
    private ImageButton imageButton3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find);
        imageButton1=(ImageButton)findViewById(R.id.imageButton_sencondHand);
        imageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent  = new Intent(FindActivity.this,BooktripActivity.class);
                startActivity(intent);
            }
        });

        imageButton2=(ImageButton)findViewById(R.id.imageButton_devoteBook);
        imageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FindActivity.this, BookDevoteActivity.class);
                startActivity(intent);
            }
        });

        imageButton3=(ImageButton)findViewById(R.id.imageButton_recommandBook);
        imageButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FindActivity.this, GoodbookActivity.class);
                startActivity(intent);
            }
        });
    }
}
