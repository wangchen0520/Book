package com.example.a17231.book.FindView;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.example.a17231.book.R;
import com.example.a17231.book.TheMainView.IncludeActivity;

import java.util.ArrayList;
import java.util.List;

public class GoodbookActivity extends AppCompatActivity {
    private List<Goodbook> goodbooks=new ArrayList<>();

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goodbook);
        Button back=(Button)findViewById(R.id.back1);
        back.setOnClickListener(new View.OnClickListener() {               //怎么返回上一层的界面而不是返回主页面，直接返回FindActivity不会出现下面的图标
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GoodbookActivity.this, IncludeActivity.class);
                startActivity(intent);
            }
        });
        ActionBar actionbar=getSupportActionBar();
        if(actionbar!=null){
            actionbar.hide();
        }
        initGoodbooks();//此方法可用于更新推荐书籍
        GoodbookAdapter adapter=new GoodbookAdapter(GoodbookActivity.this,
                R.layout.goodbook_item,goodbooks);
        ListView listView=(ListView)findViewById(R.id.list_view);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent,View view,int position,long id){
                Goodbook book=goodbooks.get(position);
                Intent intent=new Intent(GoodbookActivity.this,ReasonActivity.class);
                startActivity(intent);
            }
        });
    }

    private void initGoodbooks(){
        for(int i=0;i<4;i++){
            Goodbook book1=new Goodbook("第一行代码",R.drawable.book1);
            goodbooks.add(book1);
            Goodbook book2=new Goodbook("追梦师",R.drawable.book2);
            goodbooks.add(book2);
            Goodbook book3=new Goodbook("我是一只小小鸟",R.drawable.book3);
            goodbooks.add(book3);

        }
    }

}
