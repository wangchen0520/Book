package com.example.a17231.book.Comment;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.a17231.book.R;

public class CommentJustOne extends AppCompatActivity {

    private ListView listView;
    private EditText editText;
    private TextView textViewGood;
    private TextView textViewComment;
    private int temp=0;

    //本界面是针对每一个发起的话题里面，点进来呢后用户可以进行自由的评论，点赞

    //本界面的第一个评论是上一层界面(CommentIncludeAll.java),点入任何一个话题就进入的是页面，而第一条信息是上一界面的一个item
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment_just_one);
        listView=(ListView)findViewById(R.id.justOneComments);//listView 添加到这里进行实例化

        textViewGood=(TextView)findViewById(R.id.goodTopic);
        textViewComment=(TextView)findViewById(R.id.wordsToComment);

        //点击评论，进入评论页面
        textViewComment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(CommentJustOne.this,CommentSend.class);
                startActivity(intent);
            }
        });

        //点赞功能
        textViewGood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                temp++;
                if (temp%2!=0)
                {
                    Drawable nav_up=getResources().getDrawable(R.drawable.thumb_selected);
                    nav_up.setBounds(0, 0, nav_up.getMinimumWidth(),nav_up.getMinimumHeight());
                    textViewGood.setCompoundDrawables( null, null, nav_up, null);
                }
                else
                {
                    Drawable nav_up=getResources().getDrawable(R.drawable.thumb_normal);
                    nav_up.setBounds(0, 0, nav_up.getMinimumWidth(),nav_up.getMinimumHeight());
                    textViewGood.setCompoundDrawables( null, null, nav_up, null);
                }
            }
        });




    }

}
