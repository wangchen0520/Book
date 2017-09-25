package com.example.a17231.book.Comment;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.example.a17231.book.R;

public class CommentIncludeAll extends Activity {
    ListView listView;
    //这里的数据实际上是从服务器传来，包括头像、昵称、话题
    String[] titles = {"标题1", "标题2", "标题3", "标题4"};
    String[] texts = {"文本内容A", "文本内容B", "文本内容C", "文本内容D"};
    int[] resIds = {R.drawable.main_icon1_1, R.drawable.main_icon1_1, R.drawable.main_icon1_1, R.drawable.main_icon1_1};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.comment_main);
        this.setTitle("BaseAdapter for ListView");
        listView = (ListView) this.findViewById(R.id.MyListView);
        listView.setAdapter(new ListViewAdapter(titles, texts, resIds));
    }

    public class ListViewAdapter extends BaseAdapter {
        View[] itemViews;

        public ListViewAdapter(String[] itemTitles, String[] itemTexts,
                               int[] itemImageRes) {
            itemViews = new View[itemTitles.length];

            for (int i = 0; i < itemViews.length; i++) {
                itemViews[i] = makeItemView(itemTitles[i], itemTexts[i],
                        itemImageRes[i]);
            }
        }

        public int getCount() {
            return itemViews.length;
        }

        public View getItem(int position) {
            return itemViews[position];
        }

        public long getItemId(int position) {
            return position;
        }

        private View makeItemView(String strTitle, String strText, int resId) {
            LayoutInflater inflater = (LayoutInflater) CommentIncludeAll.this
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            // 使用View的对象itemView与R.layout.item关联
            View itemView = inflater.inflate(R.layout.activity_comment_include_all, null);

            // 通过findViewById()方法实例R.layout.item内各组件
            TextView title = (TextView) itemView.findViewById(R.id.itemTitle);
            title.setText(strTitle);
            TextView text = (TextView) itemView.findViewById(R.id.itemText);
            text.setText(strText);
            ImageView image = (ImageView) itemView.findViewById(R.id.itemImage);
            image.setImageResource(resId);
            return itemView;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null)
                return itemViews[position];
            return convertView;
        }
    }

}