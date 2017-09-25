package com.example.a17231.book.FindView;

/**
 * Created by hasee on 2017/8/10.
 */

public class Goodbook {

    private String name;

    private int imageId;

    public Goodbook(String name,int imageId){
        this.name=name;
        this.imageId=imageId;
    }

    public String getName(){
        return name;
    }

    public int getImageId(){
        return imageId;
    }
}
