package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;





//import androidx.appcompat.app.AlertController;


    public class ListActivity extends AppCompatActivity implements MyRecyclerViewAdapter.ItemClickListener{
        private RecyclerView recyclerView;
        private RecyclerView.Adapter mAdapter;
        private RecyclerView.LayoutManager layoutManager;
        MyRecyclerViewAdapter  adapter;
        String items []=new String[]{"Android","iphone" , "Windows","Blackberry","Linux" };
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_list);
            recyclerView = (RecyclerView) findViewById(R.id.rv);
            ArrayList<String> phoneNames = new ArrayList<>();
            phoneNames.add("Android");
            phoneNames.add("iphone");
            phoneNames.add("Windows");
            phoneNames.add("Blackberry");
            phoneNames.add("Linux");

            // use this setting to improve performance if you know that changes
            // in content do not change the layout size of the RecyclerView
            recyclerView.setHasFixedSize(true);

            // use a linear layout manager
            layoutManager = new LinearLayoutManager(this);
            recyclerView.setLayoutManager(layoutManager);

            adapter = new MyRecyclerViewAdapter(this, phoneNames);
            adapter.setClickListener(this);
            recyclerView.setAdapter(adapter);

        }
        @Override
        public void onItemClick(View view, int position) {
            Toast.makeText(this, "You clicked " + adapter.getItem(position) + " on row number " + position, Toast.LENGTH_SHORT).show();
            Intent intent=new Intent(this,DeviceDetailActivity.class);
            startActivity(intent);
        }
    }


