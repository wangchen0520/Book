package com.example.a17231.book;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class StartDiscussActivity extends AppCompatActivity implements View.OnClickListener{
    private Button button_return;
    private Button button_startDiscuss;
    private TextView text_Book;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_discuss);

//        System.out.println("OnCreate");
        //为各个控件定义对应的变量
        button_return  = (Button)findViewById(R.id.button_return);
        button_startDiscuss = (Button)findViewById(R.id.button_startDiscuss);
        text_Book = (TextView) findViewById(R.id.text_Book);
        editText = (EditText) findViewById(R.id.text_Discuss);
        //设置点击监听
        button_return.setOnClickListener(this);
        button_startDiscuss.setOnClickListener(this);
        //将传入的书的信息显示到TextView中
        text_Book.setText(getIntent().getStringExtra("txt"));
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_return:
                finish();
                break;
            case R.id.button_startDiscuss:
                //获取用户输入的讨论内容
                String discuss = editText.getText().toString();
                if(discuss.equals("")) {
                    new AlertDialog.Builder(StartDiscussActivity.this)
                            .setTitle("输入为空！")
                            .setMessage("请输入正确的讨论内容")
                            .setPositiveButton("确定", null)
                            .show();
                } else {
//                    System.out.println(discuss);
                    //打开用户发表讨论问题的文件
                    File writeFile = new File(this.getExternalFilesDir("discuss"), "discuss.txt");
                    try {
                        writeFile.createNewFile();//如果没有则新建一个
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    try {
                        FileWriter writer = new FileWriter(writeFile.getCanonicalPath(), true);
                        //将这次的书名和讨论内容追加入该文件
                        String write = getIntent().getStringExtra("name")+"_"+discuss+"\n";
//                        System.out.println(write);
                        writer.write(write);
                        writer.close();
                        new AlertDialog.Builder(StartDiscussActivity.this)
                                .setTitle("发起讨论成功！")
                                .setMessage("返回上级菜单")
                                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        finish();
                                    }
                                })
                                .show();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                break;
        }
    }
}
