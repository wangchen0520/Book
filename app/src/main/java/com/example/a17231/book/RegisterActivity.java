//package com.example.a17231.book;
//
//import android.app.Activity;
//import android.content.Intent;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.Toast;
//
//import com.avos.avoscloud.AVException;
//import com.avos.avoscloud.AVMobilePhoneVerifyCallback;
//import com.avos.avoscloud.AVOSCloud;
//import com.avos.avoscloud.AVUser;
//import com.avos.avoscloud.SignUpCallback;
//
//public class RegisterActivity extends Activity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_register);  //创建时描述基本布局
//
//        AVOSCloud.initialize(this, "aUKc53iX4S9KR2oawu2Kpn3D-gzGzoHsz", "Uj1NNV9YBXvz1wrsy0hlnNNn");
//
//        final EditText user = (EditText)findViewById(R.id.ruserid);
//        final EditText password = (EditText)findViewById(R.id.rpassword);
//        final EditText rpassword = (EditText)findViewById(R.id.rrpassword);
//        final EditText verify = (EditText)findViewById(R.id.phpne_editText);
//        final Button register = (Button)findViewById(R.id.rbutton);
//        Button back = (Button)findViewById(R.id.barBtn);
//        Button send = (Button)findViewById(R.id.registersend_button);
//
//        send.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String a = password.getText().toString();
//                String b = rpassword.getText().toString();
//                String c = user.getText().toString();
//                if(a.equals(b)){
//
//                    AVUser user = new AVUser();
//                    user.setUsername(c);
//                    user.setPassword(b);
//                    user.setMobilePhoneNumber(c);
//                    user.signUpInBackground(new SignUpCallback() {
//                        @Override
//                        public void done(AVException e) {
//                            Toast.makeText(getApplicationContext(),"发送成功",Toast.LENGTH_SHORT).show();
//                        }
//                    });
//                }else{
//                    Toast.makeText(getApplicationContext(),"密码错误",Toast.LENGTH_SHORT).show();
//                }
//            }
//        });
//
//        register.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String smsCode = verify.getText().toString();
//                AVUser.verifyMobilePhoneInBackground(smsCode, new AVMobilePhoneVerifyCallback() {
//
//                    @Override
//                    public void done(AVException e) {
//                        // TODO Auto-generated method stub
//                        if(e == null){
//                            Toast.makeText(getApplicationContext(),"注册成功",Toast.LENGTH_SHORT).show();
//                            Intent i = new Intent(RegisterActivity.this,LoginActivity.class);
//                            startActivity(i);
//                            finish();
//                        }else {
//                            Toast.makeText(getApplicationContext(),"注册失败！",Toast.LENGTH_SHORT).show();
//                        }
//                    }
//                });
//            }
//        });
//
//        back.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i = new Intent(RegisterActivity.this,LoginActivity.class);
//                startActivity(i);
//            }
//        });
//    }
//}
