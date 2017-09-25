package com.example.a17231.book;

import android.app.LocalActivityManager;
import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.a17231.book.TheMainView.MyinfoActivity;

import java.util.ArrayList;
import java.util.List;

public class IncludeActivity extends AppCompatActivity {


    //控件
    private ImageView img1, img2, img3;
    private ViewPager vp;

    //LocalActivityManager用来获取每个activity的view,放于Adapter中
    //MyViewPageAdapter用来放viewpager的内容
    //OnClickListener设置底部图片的点击事件
    //OnPageChangeListener设置图片的滑动事件
    private LocalActivityManager manager;
    private MyViewPageAdapter viewPageAdapter;
    private View.OnClickListener clickListener;
    private ViewPager.OnPageChangeListener pageChangeListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_include);

        manager = new LocalActivityManager(this, true);
        manager.dispatchCreate(savedInstanceState);

        vp = (ViewPager) findViewById(R.id.viewpager);
        InitView();
    }


    private void InitView() {
        // TODO Auto-generated method stub
        img1 = (ImageView) findViewById(R.id.main_img1);
        img2 = (ImageView) findViewById(R.id.main_img2);
        img3 = (ImageView) findViewById(R.id.main_img3);

        clickListener = new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                switch (v.getId()) {
                    case R.id.main_img1:
                        vp.setCurrentItem(0);
                        break;
                    case R.id.main_img2:
                        vp.setCurrentItem(1);
                        break;
                    case R.id.main_img3:
                        vp.setCurrentItem(2);
                        break;
                }
            }
        };

        img1.setOnClickListener(clickListener);
        img2.setOnClickListener(clickListener);
        img3.setOnClickListener(clickListener);

        InitPager();

    }

    private void InitPager() {
        // TODO Auto-generated method stub
        pageChangeListener = new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageSelected(int arg0) {
                // TODO Auto-generated method stub
                switch (arg0) {
                    case 0:
                        img1.setImageResource(R.drawable.main_icon1_1);
                        img2.setImageResource(R.drawable.main_icon2_2);
                        img3.setImageResource(R.drawable.main_icon3_2);

                        break;
                    case 1:
                        img1.setImageResource(R.drawable.main_icon1_2);
                        img2.setImageResource(R.drawable.main_icon2_1);
                        img3.setImageResource(R.drawable.main_icon3_2);

                        break;
                    case 2:
                        img1.setImageResource(R.drawable.main_icon1_2);
                        img2.setImageResource(R.drawable.main_icon2_2);
                        img3.setImageResource(R.drawable.main_icon3_1);
                        break;
                }
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onPageScrollStateChanged(int arg0) {
                // TODO Auto-generated method stub

            }
        };

        AddActivitiesToViewPager();
        vp.setCurrentItem(0);
        vp.setOnPageChangeListener(pageChangeListener);
    }

    private void AddActivitiesToViewPager() {
        List<View> mViews = new ArrayList<View>();
        Intent intent = new Intent();

        intent.setClass(this, HomeActivity.class);
        intent.putExtra("id", 1);
        mViews.add(getView("QualityActivity1", intent));

        intent.setClass(this, FindActivity.class);
        intent.putExtra("id", 2);
        mViews.add(getView("QualityActivity2", intent));

        intent.setClass(this, MyinfoActivity.class);
        intent.putExtra("id", 3);
        mViews.add(getView("QualityActivity3", intent));


        viewPageAdapter = new MyViewPageAdapter(mViews);
        vp.setAdapter(viewPageAdapter);

    }

    private View getView(String id, Intent intent) {
        return manager.startActivity(id, intent).getDecorView();

    }


}

