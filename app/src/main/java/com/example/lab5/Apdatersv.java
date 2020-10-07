package com.example.lab5;



import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import static com.example.lab5.MainActivity.lvNews;


public class Apdatersv extends BaseAdapter {

    Context context;
    ArrayList<News> data;

    MainActivity activity;


    public Apdatersv(Context context, ArrayList<News> data){
        this.context = context;
        this.data = data;
    }
    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }


    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        final view holder;

        if(convertView == null){
            holder = new view();
            LayoutInflater inflater =((Activity)context).getLayoutInflater();
            convertView = inflater.inflate(R.layout.sinhvien,null);
            holder.txtmalop = convertView.findViewById(R.id.txtmalop);
            holder.txttenlop = convertView.findViewById(R.id.txttenlop);
            convertView.setTag(holder);

        }else
            holder =(view) convertView.getTag();
                lvNews.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(context,Main2Activity.class);
                intent.putExtra("openlink",data.get(position).getLink());
                context.startActivity(intent);

            }
        });
 holder.txtmalop.setText(data.get(position).getTitle());
 holder.txttenlop.setText(data.get(position).getLink());


 return convertView;



    }


    class view{
        ImageView  avatar,xoa,create;
        TextView txtdate,txthoten,txttenlop,txtmalop,txtnganh;
    }


}
