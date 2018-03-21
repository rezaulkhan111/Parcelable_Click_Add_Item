package com.example.entern.testapp;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class TowActivity extends Activity implements View.OnClickListener{


    ArrayList<PersonInfo> personInfos;
    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    Button mAdd_Item;
//    TextView textView,textView2;
   Adapter adapter = new Adapter();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tow);
        //textView=findViewById(R.id.showTextView);
        //textView2=findViewById(R.id.ageTextView);
        mAdd_Item=(Button) findViewById(R.id.bt_add_item);
        mAdd_Item.setOnClickListener(this);


        mRecyclerView=findViewById(R.id.my_recycler_view);
        //Bundle bundleData=getIntent().getExtras();

        personInfos = getIntent().getExtras().getParcelableArrayList("Message");
        adapter.addItems(personInfos);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(adapter);
    }

    @Override
    public void onClick(View view) {
        adapter.addItem(personInfos.get(0));

    }
}
