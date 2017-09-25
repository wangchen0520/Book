package com.example.a17231.book;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class RefreshInfo extends AppCompatActivity implements View.OnClickListener{

    private  static PersonalMessage info=new PersonalMessage("dada","call me king","2016141463085","四川大学","软件学院","软件工程");

    private Button back;

    private Button modify;

    private EditText petName;

    private EditText id;

    private EditText university;

    private EditText school;

    private EditText major;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_refresh_info);
        back=(Button)findViewById(R.id.back_myinfo);
        modify=(Button)findViewById(R.id.button_refresh_my_info);
        petName=(EditText)findViewById(R.id.text_head);
        id=(EditText)findViewById(R.id.text_id);
        university=(EditText)findViewById(R.id.text_university);
        school=(EditText)findViewById(R.id.text_college);
        major=(EditText)findViewById(R.id.text_major);
        petName.setText(info.getPetName());
        id.setText(info.getId());
        university.setText(info.getUniversity());
        school.setText(info.getSchool());
        major.setText(info.getMajor());
        back.setOnClickListener(this);
        modify.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.back_myinfo:
                Intent intent1=new Intent(RefreshInfo.this,PersonalMessageActivity.class);
                finish();
                startActivity(intent1);
                break;
            case R.id.button_refresh_my_info:
                info.setId(id.getText().toString());
                info.setUniversity(university.getText().toString());
                info.setSchool(school.getText().toString());
                info.setMajor(major.getText().toString());
                info.setPetName(petName.getText().toString());
                Intent intent=new Intent(RefreshInfo.this,PersonalMessageActivity.class);
                finish();
                startActivity(intent);
                break;
            default:
        }
    }

    public static PersonalMessage getInfo(){
        return info;
    }
}
