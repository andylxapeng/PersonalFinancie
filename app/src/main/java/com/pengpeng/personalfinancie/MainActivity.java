package com.pengpeng.personalfinancie;

import android.app.Activity;
import android.content.Context;
import android.graphics.Picture;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {



    GridView gvInfo = null;
    //创建字符串数组
    String [] titles = new String[]
            {"新增收人","新增支出","我的收人","我的支出","数据管理","系统设置","收支便签","退出"};
    //创建
    int [] images = new int[]
            {R.drawable.addoutaccount,
                    R.drawable.addinaccount, R.drawable.outaccountinfo,
                    R.drawable.inaccountinfo, R.drawable.showinfo, R.drawable.sysset,
                    R.drawable.accountflag, R.drawable.exit};


    class Picture{
        private String title;
        private int imageId;
        public Picture(){
            super();
        }
        public Picture(String title,int imageId ){
            super();
            this.title = title;
            this.imageId = imageId;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getImageId() {
            return imageId;
        }

        public void setImageId(int imageId) {
            this.imageId = imageId;
        }

        @Override
        public String toString() {
            return "Picture{" +
                    "title='" + title + '\'' +
                    ", imageId=" + imageId +
                    '}';
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gvInfo = (GridView) findViewById(R.id.gvInfo);
        PictrueAdapter adapter = new PictrueAdapter(titles,images,this);
        gvInfo.setAdapter(adapter);
        gvInfo.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });

    }



    class PictrueAdapter extends BaseAdapter{
        private LayoutInflater inflater;
        private List<Picture> pictures;

        public PictrueAdapter(String [] titles,int [] images,Context context) {
            super();
            pictures = new ArrayList<Picture>();
            inflater = LayoutInflater.from(context);
            for(int i = 0;i < images.length;i++){
                Picture picture = new Picture(titles[i],images[i]);
            }
        }

        @Override
        public int getCount() {
           if(pictures != null){
                return pictures.size();
           }else {
               return 0;
           }
        }

        @Override
        public Object getItem(int position) {
            return pictures.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder viewHolder;
            if(convertView == null){

            }
            return convertView;
        }
    }

    class ViewHolder{
       public TextView title;
        public ImageView image;
    }

}
