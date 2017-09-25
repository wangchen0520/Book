package com.example.a17231.book.TheMainView;

import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.a17231.book.EnterDiscussActivity;
import com.example.a17231.book.R;
import com.example.a17231.book.StartDiscussActivity;

import java.io.IOException;
import java.io.InputStream;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener{
    private boolean ifSearchSuccessfully = false;
    private Button button_bookSearch;
    private Button button_enterDiscuss;
    private Button button_startDiscuss;
    private EditText editText;
    private TextView text_Book;
    private String string = "";
    private String name = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

//        System.out.println("onCreate");
        //为各个控件定义对应的变量
        button_bookSearch = (Button)findViewById(R.id.button_bookSearch);
        button_enterDiscuss = (Button)findViewById(R.id.button_enterDiscuss);
        button_startDiscuss = (Button)findViewById(R.id.button_startDiscuss);
        editText = (EditText) findViewById(R.id.editText);
        text_Book = (TextView) findViewById(R.id.text_Book);

        //为按钮设置点击监听器
        button_bookSearch.setOnClickListener(this);
        button_enterDiscuss.setOnClickListener(this);
        button_startDiscuss.setOnClickListener(this);
    }

    //响应点击事件
    @Override
    public void onClick(View view) {
        Intent intent = new Intent();
        switch(view.getId()) {
            //按下“搜索”按钮后
            case R.id.button_bookSearch:
//                System.out.println("1");
                //获取用户输入的书名
                name = editText.getText().toString();
//                System.out.println(name);
                try {
                    /*FileInputStream bookInputStream = openFileInput(name);
                    bookInputStream.read(book);
                    System.out.println(book);
                    bookInputStream.close();*/
                    //读取Asset中的存有图书信息的文件
                    AssetManager assetManager = getAssets();
                    InputStream inputStream = assetManager.open(name+".txt");
                    //循环读取并储存到字符串中
                    byte[] book = new byte[1024];
                    string = "";
                    while(inputStream.read(book)!=-1) {
                        string += new String(book);
                        book = new byte[1024];
                    }
                    text_Book.setText(string);
                    //告诉系统已经查到书了
                    ifSearchSuccessfully = true;
                    inputStream.close();
                } catch (IOException e) {
                    //没找到时弹出弹窗
                    new AlertDialog.Builder(HomeActivity.this)
                            .setTitle("找不到该图书！")
                            .setMessage("请输入正确的图书名")
                            .setPositiveButton("确定", null)
                            .show();
                    //告诉系统没有查到书
                    ifSearchSuccessfully=false;
                }
                break;
            case R.id.button_enterDiscuss:
                if(ifSearchSuccessfully) {
                    //传入对应图书的信息并跳转
                    intent.setClass(HomeActivity.this, EnterDiscussActivity.class);
                    intent.putExtra("txt", string);
                    intent.putExtra("name", name);
                    startActivity(intent);
                } else {
                    //还没有正确搜索时弹出弹窗提醒
                    new AlertDialog.Builder(HomeActivity.this)
                            .setTitle("还没有搜索结果呢！")
                            .setMessage("请进行正确的搜索")
                            .setPositiveButton("确定", null)
                            .show();
                }
                break;
            case R.id.button_startDiscuss:
                if(ifSearchSuccessfully) {
                    //传入对应图书的信息并跳转
                    intent.setClass(HomeActivity.this, StartDiscussActivity.class);
                    intent.putExtra("txt", string);
                    intent.putExtra("name", name);
                    startActivity(intent);
                } else {
                    //还没有正确搜索时弹出弹窗提醒
                    new AlertDialog.Builder(HomeActivity.this)
                            .setTitle("还没有搜索结果呢！")
                            .setMessage("请进行正确的搜索")
                            .setPositiveButton("确定", null)
                            .show();
                }
                break;
        }
    }
}
