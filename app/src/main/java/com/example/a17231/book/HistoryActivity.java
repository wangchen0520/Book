package com.example.a17231.book;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class HistoryActivity extends AppCompatActivity {
    TextView text_history;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        text_history = (TextView) findViewById(R.id.text_history);
        getHistory();
    }

    private void getHistory() {

    }
}
