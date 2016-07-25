package com.example.gift.View;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.gift.Controller.MyAdapter;
import com.example.gift.R;

import java.util.ArrayList;

/**
 * Created by fenghui on 6/15/16.
 */
public class Function extends AppCompatActivity {
    private ListView lv;
    private MyAdapter mAdapter;
    private ArrayList<String> list;
    private Button bt_selectAll;
    private Button bt_cancelSelected;
    private Button bt_deleteAll;
    private int chechNum;
    private TextView tv_show;
    @Override
    protected void onCreate(Bundle savedInstance){
        super.onCreate(savedInstance);
        setContentView(R.layout.function_list);
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar3);
        setSupportActionBar(toolbar);
        ActionBar back = getSupportActionBar();
        back.setDisplayHomeAsUpEnabled(true);

        lv = (ListView)findViewById(R.id.lv);
        bt_selectAll = (Button)findViewById(R.id.bt_selectAll);
        bt_cancelSelected = (Button)findViewById(R.id.bt_cancelSelected);
        bt_deleteAll = (Button)findViewById(R.id.bt_deleteAll);
        tv_show = (TextView)findViewById(R.id.tv);
        list = new ArrayList<String>();

        initData();
        mAdapter = new MyAdapter(list,this);
        lv.setAdapter(mAdapter);

        bt_selectAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i=0;i<list.size();i++){
                    MyAdapter.getIsSelected().put(i,true);
                }
                chechNum = list.size();
                dataChanged();
            }
        });
        bt_cancelSelected.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i=0;i<list.size();i++){
                    if(MyAdapter.getIsSelected().get(i)){
                        MyAdapter.getIsSelected().put(i,false);
                        chechNum--;
                    }
                    else{
                        MyAdapter.getIsSelected().put(i,true);
                        chechNum++;
                    }
                }
                dataChanged();
            }
        });
        bt_deleteAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i=0;i<list.size();i++){
                    if(MyAdapter.getIsSelected().get(i)){
                        MyAdapter.getIsSelected().put(i,false);
                        chechNum--;
                    }
                }
                dataChanged();
            }
        });
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                MyAdapter.ViewHolder holder = (MyAdapter.ViewHolder)arg1.getTag();
                holder.cb.toggle();
                MyAdapter.getIsSelected().put(arg2,holder.cb.isChecked());
                if(holder.cb.isChecked()==true){
                    chechNum++;
                }
                else{
                    chechNum--;
                }
                tv_show.setText("You have chosen "+chechNum+" items");
            }
        });
    }
    private void initData(){
        list.add("Wedding");
        list.add("Birthday");
        list.add("Party");
    }
    private void dataChanged(){
        mAdapter.notifyDataSetChanged();
        tv_show.setText("You have chosen "+chechNum+" items");
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
