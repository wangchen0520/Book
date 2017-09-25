package com.example.a17231.book;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class MyDiscussActivity extends AppCompatActivity {
    TextView text_myDiscuss;
    String line;
    String[] strings = new String[2];
    String string = "";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_discuss);

        text_myDiscuss = (TextView) findViewById(R.id.text_myDiscuss);
        getMyDiscuss();
    }

    private void getMyDiscuss() {
        File readFile = new File(this.getExternalFilesDir("discuss"), "discuss.txt");
        try {
            FileReader reader = new FileReader(readFile.getCanonicalPath());
            BufferedReader bf= new BufferedReader(reader);
            while((line = bf.readLine())!=null) {
                strings = line.split("_");
                string = strings[0]+"    "+strings[1]+"\n";
            }
            text_myDiscuss.setText(string);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
