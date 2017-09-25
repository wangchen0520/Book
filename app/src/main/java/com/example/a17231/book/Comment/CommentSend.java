package com.example.a17231.book.Comment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.a17231.book.R;

public class CommentSend extends AppCompatActivity {
    private EditText editText;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment_send);
        editText=(EditText)findViewById(R.id.commentwords);
        button=(Button)findViewById(R.id.wordsToComment);

    }
}
