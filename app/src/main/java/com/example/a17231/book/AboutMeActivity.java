package com.example.a17231.book;

import android.app.LocalActivityManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.a17231.book.HistoryActivity;
import com.example.a17231.book.MyDiscussActivity;
import com.example.a17231.book.MyViewPageAdapter;
import com.example.a17231.book.R;

import java.util.ArrayList;
import java.util.List;

public class AboutMeActivity extends AppCompatActivity implements View.OnClickListener {
    private Button button_return;
    private Button button_history;
    private Button button_myDiscuss;
    private ViewPager vpr;
    //LocalActivityManager用来获取每个activity的view,放于Adapter中
    //MyViewPageAdapter用来放viewpager的内容
    //OnPageChangeListener设置页面的滑动事件
    private LocalActivityManager manager;
    private MyViewPageAdapter viewPageAdapter;
    private ViewPager.OnPageChangeListener pageChangeListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_me);

        button_return = (Button) findViewById(R.id.button_return);
        button_history = (Button) findViewById(R.id.button_history);
        button_myDiscuss = (Button) findViewById(R.id.button_myDiscuss);
        manager = new LocalActivityManager(this, true);
        manager.dispatchCreate(savedInstanceState);
        vpr = (ViewPager) findViewById(R.id.viewpager);

        button_return.setOnClickListener(this);
        button_history.setOnClickListener(this);
        button_myDiscuss.setOnClickListener(this);

        AddActivitiesToViewPager();
        vpr.setCurrentItem(0);
        vpr.setOnPageChangeListener(pageChangeListener);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_return:
                finish();
                break;
            case R.id.button_history:
                vpr.setCurrentItem(0);
                break;
            case R.id.button_myDiscuss:
                vpr.setCurrentItem(1);
                break;
        }
    }

    private  void AddActivitiesToViewPager() {
        List<View> mViews = new ArrayList<View>();
        Intent intent = new Intent();

        intent.setClass(this, HistoryActivity.class);
        intent.putExtra("id", 1);
        mViews.add(getView("QualityActivity1", intent));

        intent.setClass(this, MyDiscussActivity.class);
        intent.putExtra("id", 2);
        mViews.add(getView("QualityActivity2", intent));

        viewPageAdapter = new MyViewPageAdapter(mViews);
        vpr.setAdapter(viewPageAdapter);
    }

    private View getView(String id, Intent intent) {
        return manager.startActivity(id, intent).getDecorView();
    }
}
