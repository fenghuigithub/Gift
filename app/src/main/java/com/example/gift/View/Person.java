package com.example.gift.View;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.gift.Controller.CustomImageView;
import com.example.gift.R;

/**
 * Created by fenghui on 6/15/16.
 */
public class Person extends AppCompatActivity{
    private CustomImageView image1;
    private CustomImageView image2;
    private CustomImageView image3;
    @Override
    protected void onCreate(Bundle savedInstance){
        super.onCreate(savedInstance);
        setContentView(R.layout.person_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);
        ActionBar back = getSupportActionBar();
        back.setDisplayHomeAsUpEnabled(true);

        image1 = (CustomImageView)findViewById(R.id.low);
        image2 = (CustomImageView)findViewById(R.id.median);
        image3 = (CustomImageView)findViewById(R.id.high);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        if(id==R.id.action_settings){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
