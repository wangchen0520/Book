package com.example.a17231.book.RegisterAndLogin;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import com.example.a17231.book.R;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends Activity {

    private String a = "";
    private String b = "";
    private Button btn;
    private Button lost;
    private Button login;
    private EditText userId;
    private EditText userPassword;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btn = (Button) findViewById(R.id.register);
        btn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(i);
            }
        });

        //忘记密码的选项
        lost = (Button) findViewById(R.id.losepassword);
//        lost.setOnClickListener(new OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent x = new Intent(LoginActivity.this, IncludeActivity.class);
//                startActivity(x);
//            }
//        });

        userId = (EditText) findViewById(R.id.email);
        userPassword = (EditText) findViewById(R.id.password);

        login = (Button) findViewById(R.id.email_sign_in_button);
        login.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                a = userId.getText().toString();
                b = userPassword.getText().toString();
                DownloadRegisterInfo(a);

                //打开文件进行密码的匹配

            }
        });




    }

    //从服务器里面下载相应的文件
    public String DownloadRegisterInfo(String filename){


        return "";
    }
}



