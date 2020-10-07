package com.example.lab5;


import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

   public static ListView lvNews;
    Intent intent;
    Apdatersv apdatersv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        lvNews = findViewById(R.id.lv);
        final NewsSeedAsyncTask newsSeedAsyncTask = new NewsSeedAsyncTask();
        newsSeedAsyncTask.execute();

        intent = new Intent(this,Main2Activity.class);


//        lvNews.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
////                String link2="";
////                for (int i =0;i<news)
//
//                intent.putExtra("openlink",uri);
//                startActivity(intent);
//
//            }
//        });


    }

    class NewsSeedAsyncTask extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... voids) {
            try {
                URL url = new URL("https://vnexpress.net/rss/suc-khoe.rss");
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                InputStream inputStream = httpURLConnection.getInputStream();
                final List newses = NewsReader.listNews(inputStream);
                apdatersv = new Apdatersv(MainActivity.this, (ArrayList<News>) newses);


                MainActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(MainActivity.this, ""+apdatersv.getCount(), Toast.LENGTH_SHORT).show();
                        lvNews.setAdapter(apdatersv);
                    }
                });

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
    }


}