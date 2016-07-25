package com.example.gift.View;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;

import com.example.gift.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by fenghui on 6/17/16.
 */
public class detail_list extends AppCompatActivity {
    public static boolean isGridView = true;
    private GridView mGridView;
    private ListView mListView;
    private Button button;
    private int flag=0;
//    private ToggleButton toggleButton;

    private List<String> mService1;
    private List<String> mService2;
    private List<String> mService3;
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grid_list_view);
        mGridView = (GridView)findViewById(R.id.app_grid);

//        toggleButton = (ToggleButton)findViewById(R.id.toggleButton);
        button = (Button) findViewById(R.id.toggleButton);

        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar4);
        setSupportActionBar(toolbar);
        ActionBar back = getSupportActionBar();
        back.setDisplayHomeAsUpEnabled(true);
        initData();
        mGridView.setAdapter(new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, mService1));

//        toggleButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                isGridView = !isGridView;
//                updateLayout();
//            }
//        });
        button.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction()==MotionEvent.ACTION_DOWN&&flag==0){
                    button.setBackgroundResource(R.drawable.toggle_btn_checked);
                    isGridView = !isGridView;
                    updateLayout();
                    flag=1;
                }
                else if(event.getAction()==MotionEvent.ACTION_DOWN&&flag==1){
                    button.setBackgroundResource(R.drawable.toggle_btn_unchecked);
                    isGridView = !isGridView;
                    updateLayout();
                    flag=0;
                }
                return true;
            }
        });

    }
    private void initData(){
     mService1 = new ArrayList<>(Arrays.asList("1","2","3","4"));
     mService2 = new ArrayList<>(Arrays.asList("5","6","7","8"));
     mService3 = new ArrayList<>(Arrays.asList("a","b","c","d"));



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        if (item.getItemId() == R.id.action_settings)
        {
//            isGridView = !isGridView;
//            updateLayout();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void updateLayout() {
        if (isGridView) {
            if (mGridView == null) {
                mGridView = (GridView) findViewById(R.id.app_grid);
            }
            mListView.setVisibility(View.GONE);
            mGridView.setVisibility(View.VISIBLE);
//            mGridView.setAdapter(new ServiceZoneAdapter(detail_list.this, mService));
            mGridView.setAdapter(new ArrayAdapter<>(this,
                    android.R.layout.simple_list_item_1, mService3));


//            mGridView.setOnItemClickListener(this);

//            if (mSelectionPosition < 0) {
//                mSelectionPosition = 0;
//            }
            mGridView.setSelection(0);

        } else {
            if (mListView == null) {
                mListView = (ListView) findViewById(R.id.app_list);
            }
            mGridView.setVisibility(View.GONE);
            mListView.setVisibility(View.VISIBLE);
//            mListView.setAdapter(new ServiceZoneAdapter(detail_list.this, mService));
            mListView.setAdapter(new ArrayAdapter<>(this,
                    android.R.layout.simple_list_item_1, mService2));


//            mListView.setOnItemClickListener(this);

//            if (mSelectionPosition < 0) {
//                mSelectionPosition = 0;
//            }
            mListView.setSelection(0);
        }
    }



}
