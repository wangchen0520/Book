package com.example.a17231.book.FindView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.a17231.book.R;

import java.util.List;

/**
 * Created by hasee on 2017/8/10.
 */

public class GoodbookAdapter extends ArrayAdapter<Goodbook> {
    private int resourceId;

    public GoodbookAdapter(Context context, int textViewResourceId,
                           List<Goodbook> objects){
        super(context,textViewResourceId,objects);
        resourceId=textViewResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        Goodbook goodbook=getItem(position);//获取当前书本实例
        View view = LayoutInflater.from(getContext()).inflate(resourceId,parent,
                false);
        ImageView goodbookImage=(ImageView)view.findViewById(R.id.goodbook_image);
        TextView goodbookName=(TextView)view.findViewById(R.id.goodbook_name);
        goodbookImage.setImageResource(goodbook.getImageId());
        goodbookName.setText(goodbook.getName());
        return view;
    }
}
