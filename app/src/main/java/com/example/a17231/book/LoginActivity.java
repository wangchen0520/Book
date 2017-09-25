//package com.example.a17231.book;
//
//import android.app.Activity;
//import android.content.Intent;
//import android.os.Bundle;
//import android.view.View;
//import android.view.View.OnClickListener;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.Toast;
//
//import com.avos.avoscloud.AVException;
//import com.avos.avoscloud.AVOSCloud;
//import com.avos.avoscloud.AVQuery;
//import com.avos.avoscloud.AVUser;
//import com.avos.avoscloud.FindCallback;
//import com.avos.avoscloud.LogInCallback;
//
//import java.util.List;
//
///**
// * A login screen that offers login via email/password.
// */
//public class LoginActivity extends Activity  {
//
//    private String a = "";
//    private String b = "";
//    private Button btn;
//    private Button lost;
//    private Button login;
//    private EditText userId;
//    private EditText userPassword;
//
//    @Override
//    protected void onCreate(final Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_login);
//
//        AVOSCloud.initialize(this, "aUKc53iX4S9KR2oawu2Kpn3D-gzGzoHsz", "Uj1NNV9YBXvz1wrsy0hlnNNn");
//
//
//        btn = (Button) findViewById(R.id.register);
//        btn.setOnClickListener(new OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i = new Intent(LoginActivity.this, RegisterActivity.class);
//                startActivity(i);
//            }
//        });
//
//
//        lost = (Button) findViewById(R.id.losepassword);
//        lost.setOnClickListener(new OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent x = new Intent(LoginActivity.this, phone_login.class);
//                startActivity(x);
//            }
//        });
//
//        userId = (EditText)findViewById(R.id.email);
//        userPassword = (EditText)findViewById(R.id.password);
//
//        login = (Button)findViewById(R.id.email_sign_in_button);
//        login.setOnClickListener(new OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                a = userId.getText().toString();
//                b = userPassword.getText().toString();
//                if(a != null && b != null){
//                    AVUser.logInInBackground(a, b, new LogInCallback() {
//                        public void done(AVUser user, AVException e) {
//                            if (e == null) {
//                                AVQuery<AVUser> query = AVUser.getQuery();
//                                query.whereEqualTo("username","123");
//                                query.findInBackground(new FindCallback<AVUser>() {
//                                    @Override
//                                    public void done(List<AVUser> list, AVException e) {
//                                        if(e == null){
//                                           // String url = list.get(0).getAVFile("head_pic").getUrl();
//                                            AVUser user1 = AVUser.getCurrentUser();
//                                            user1.put("head_pic",list.get(0).getAVFile("head_pic"));
//                                            user1.saveInBackground();
//                                        }
//                                    }
//                                });
//
//                                Intent intent = new Intent(LoginActivity.this,MainActivity.class);
//                                startActivity(intent);
//                                finish();
//                            } else {
//                                Toast.makeText(getApplicationContext(),"登录失败",Toast.LENGTH_SHORT).show();
//                            }
//                        }
//                    });
//
//
//                }else{
//                    Toast.makeText(getApplicationContext(),"请输入用户名",Toast.LENGTH_SHORT).show();
//                }
//            }
//        });
//    }
//}
//
