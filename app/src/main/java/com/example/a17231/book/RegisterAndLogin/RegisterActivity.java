package com.example.a17231.book.RegisterAndLogin;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import com.example.a17231.book.R;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RegisterActivity extends Activity {

    private EditText registeruser;
    private EditText registerpassword;
    private Button registerbutton;
    private String UserName, UerPassWord;

    private String line;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);  //创建时描述基本布局

        registeruser = (EditText) findViewById(R.id.reguserid);
        registerpassword = (EditText) findViewById(R.id.regpassword);
        registerbutton = (Button) findViewById(R.id.regbutton);

        UserName = registeruser.getText().toString();
        UerPassWord = registerpassword.getText().toString();

        registerbutton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    CreatFile(UserName, UerPassWord);//创建相应的文件，以注册的姓名ID为文件名称。
                }catch (IOException e){

                }



            }
        });


    }


    //下面的方法是用来创建新用户信息文件的。创建txt文件
    public String CreatFile(String filenameTemp, String filecontent) throws IOException {

        String fileName = filenameTemp + ".txt";
        String filePath = "/sdcard/RegisterInformation/";
        writeTxtToFile(filecontent, filePath, fileName);
        return fileName;

    }

    // 将字符串写入到文本文件中
    public void writeTxtToFile(String strcontent, String filePath, String fileName) {
        //生成文件夹之后，再生成文件，不然会出错
        makeFilePath(filePath, fileName);

        String strFilePath = filePath + fileName;
        // 每次写入时，都换行写
        String strContent = strcontent + "\r\n";
        try {
            File file = new File(strFilePath);
            if (!file.exists()) {
                Log.d("TestFile", "Create the file:" + strFilePath);
                file.getParentFile().mkdirs();
                file.createNewFile();
            }
            RandomAccessFile raf = new RandomAccessFile(file, "rwd");
            raf.seek(file.length());
            raf.write(strContent.getBytes());
            raf.close();
        } catch (Exception e) {
            Log.e("TestFile", "Error on write File:" + e);
        }
    }

    // 生成文件
    public File makeFilePath(String filePath, String fileName) {
        File file = null;
        makeRootDirectory(filePath);
        try {
            file = new File(filePath + fileName);
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return file;
    }

    // 生成文件夹
    public static void makeRootDirectory(String filePath) {
        File file = null;
        try {
            file = new File(filePath);
            if (!file.exists()) {
                file.mkdir();
            }
        } catch (Exception e) {
            Log.i("error:", e + "");
        }
    }

    //上传文件到服务器的方法，上传用户信息到服务器的指定的路径里面
    public void UpLoadRegisterInfo() {



    }

}
