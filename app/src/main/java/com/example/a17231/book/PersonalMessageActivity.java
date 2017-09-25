package com.example.a17231.book;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PersonalMessageActivity extends AppCompatActivity implements View.OnClickListener{

    private Button back;

    private Button modify;

    private PersonalMessage nowInfo;

    private TextView petName;

    private TextView id;

    private TextView university;

    private TextView school;

    private TextView major;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_message);
        back=(Button)findViewById(R.id.back_myinfo);
        modify=(Button)findViewById(R.id.button_refresh_my_info);
        petName=(TextView)findViewById(R.id.text_head);
        id=(TextView)findViewById(R.id.text_id);
        university=(TextView)findViewById(R.id.text_university);
        school=(TextView)findViewById(R.id.text_college);
        major=(TextView)findViewById(R.id.text_major);
        back.setOnClickListener(this);
        modify.setOnClickListener(this);
        nowInfo=RefreshInfo.getInfo();
        petName.setText(nowInfo.getPetName());
        id.setText(nowInfo.getId());
        university.setText(nowInfo.getUniversity());
        school.setText(nowInfo.getSchool());
        major.setText(nowInfo.getMajor());
    }

    @Override
    public void onClick(View v){
        switch(v.getId()){
            case R.id.back_myinfo:
                finish();
                break;
            case R.id.button_refresh_my_info:
                Intent intent=new Intent(PersonalMessageActivity.this,RefreshInfo.class);
                finish();
                startActivity(intent);
                break;
            default:
        }
    }
}
