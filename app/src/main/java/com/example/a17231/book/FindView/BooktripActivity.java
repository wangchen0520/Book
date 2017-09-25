package com.example.a17231.book.FindView;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.example.a17231.book.R;
import com.example.a17231.book.TheMainView.IncludeActivity;

import java.util.ArrayList;
import java.util.List;

public class BooktripActivity extends AppCompatActivity {

    private List<Booktrip> booktrips=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booktrip);
        ActionBar actionbar=getSupportActionBar();
        if(actionbar!=null){
            actionbar.hide();
        }
        Button back=(Button)findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BooktripActivity.this, IncludeActivity.class);
                startActivity(intent);
            }
        });
        initBooktrips();
        RecyclerView recyclerView =(RecyclerView)findViewById(R.id.recycler_view);
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(layoutManager);
        BooktripAdapter adapter=new BooktripAdapter(booktrips);
        recyclerView.setAdapter(adapter);
    }

    private void initBooktrips(){
        Booktrip book1=new Booktrip("2017/8/10小光留念        2200/8/10小光留念ssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssxxxxxcccvsadadadadadadad撒大大大大大大哒哒哒哒哒哒哒啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊" ,R.drawable.book1);
        booktrips.add(book1);
        Booktrip book2=new Booktrip("1987/8/10小小留念        2200/8/10小小留念",R.drawable.book2);
        booktrips.add(book2);
    }

}
