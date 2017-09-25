package com.example.a17231.book;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.a17231.book.Comment.CommentIncludeAll;

public class EnterDiscussActivity extends AppCompatActivity implements View.OnClickListener{
    Button button_return;
    Button button_haveQuestion;
    Button button_checkPeople;
    TextView text_Name;
    TextView text_Book;
    TextView text_PeopleNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_discuss);

//        System.out.println("OnCreate");
        //为各个控件定义对应的变量
        button_return = (Button) findViewById(R.id.button_return);
        button_haveQuestion = (Button) findViewById(R.id.button_haveQuestion);

        //跳转到这一本书的被发起讨论的一个listview的界面，里面有所有的每一个用户针对这一本书所发起的所有的讨论
//
//        button_haveQuestion.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent=new Intent(EnterDiscussActivity.this, CommentIncludeAll.class);
//                startActivity(intent);
//            }
//        });

        button_checkPeople = (Button) findViewById(R.id.button_checkPeople);
        text_Name = (TextView) findViewById(R.id.text_Name);
        text_Book = (TextView) findViewById(R.id.text_Book);
        text_PeopleNumber = (TextView) findViewById(R.id.text_PeopleNumber);
        //设置点击监听
        button_return.setOnClickListener(this);
        button_haveQuestion.setOnClickListener(this);
        button_checkPeople.setOnClickListener(this);
        //将传入的书的信息显示到TextView中
        text_Name.setText(getIntent().getStringExtra("name"));
        text_Book.setText(getIntent().getStringExtra("txt"));
        //将实时人数显示出来
        String string = "实时人数为："+getPeopleNumber();
        text_PeopleNumber.setText(string);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_return:
                finish();
                break;
            case R.id.button_haveQuestion:
                Intent intent=new Intent(EnterDiscussActivity.this, CommentIncludeAll.class);
                startActivity(intent);
                break;
            case R.id.button_checkPeople:
                findPeoples();
                break;
        }
    }

    private int getPeopleNumber() {
        return 1;
    }
    private void findPeoples() {
        new AlertDialog.Builder(EnterDiscussActivity.this)
                .setTitle("现在没有人！")
                .setMessage("关了吧")
                .setPositiveButton("确定", null)
                .show();
    };
}
