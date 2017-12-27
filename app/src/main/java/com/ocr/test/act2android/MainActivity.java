package com.ocr.test.act2android;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.oc.rss.fake.FakeNews;
import com.oc.rss.fake.FakeNewsList;
import com.ocr.test.act2android.model.ListNewsAdapter;

import java.util.List;

/**
 * Main activity with list of news contained within a RecyclerView
 * The items on the list once clicked will launch a second activity with the details in a webview
 * @author : Boyman
 */
public class MainActivity extends AppCompatActivity {

    // Fill in the fakenews list with our jar
    private List<FakeNews> list = FakeNewsList.all;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // retrieving the recyclerView component from the view manager :
        RecyclerView mRecycler = (RecyclerView) findViewById(R.id.mRecycler);
        mRecycler.setLayoutManager(new LinearLayoutManager(this));


        // define layout provided by Android SDK : simple_list_item_1
        RecyclerView.Adapter mAdapter = new ListNewsAdapter(list,android.R.layout.simple_list_item_1);
        mRecycler.setAdapter(mAdapter);
    }
}
