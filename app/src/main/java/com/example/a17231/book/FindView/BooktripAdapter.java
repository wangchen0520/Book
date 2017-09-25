package com.example.a17231.book.FindView;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.a17231.book.R;

import java.util.List;

/**
 * Created by hasee on 2017/8/10.
 */

public class BooktripAdapter extends RecyclerView.Adapter<BooktripAdapter.ViewHolder> {

    private List<Booktrip> booktrips;

    static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView booktripImage;
        TextView booktripHistory;

        public ViewHolder(View view){
            super(view);
            booktripImage=(ImageView)view.findViewById(R.id.booktrip_image);
            booktripHistory=(TextView)view.findViewById(R.id.booktrip_history);
        }
    }

    public BooktripAdapter(List<Booktrip> booktripList){
        booktrips=booktripList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.booktrip_item,parent,false);
        ViewHolder holder=new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position){
        Booktrip booktrip=booktrips.get(position);
        holder.booktripImage.setImageResource(booktrip.getImageId());
        holder.booktripHistory.setText(booktrip.getName());
    }
    @Override
    public int getItemCount(){
        return booktrips.size();
    }

}
