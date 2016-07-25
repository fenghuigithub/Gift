package com.example.gift.View;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TableRow;
import android.widget.Toast;

import com.example.gift.R;

/**
 * Created by fenghui on 6/11/16.
 */
public class MainTab04 extends Fragment {
    private TableRow tableRow1;
    private TableRow tableRow2;
    private Button button1;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle savedInstanceState){
        View newsLayout = inflater.inflate(R.layout.main_tab_04,viewGroup,false);

        tableRow1 = (TableRow)newsLayout.findViewById(R.id.about_item1);
        tableRow2 = (TableRow)newsLayout.findViewById(R.id.about_item2);
        button1 = (Button)newsLayout.findViewById(R.id.apply);

        tableRow1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.m,"Contact Us",Toast.LENGTH_SHORT).show();
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.m,detail_list.class);
                startActivity(intent);
            }
        });

        return newsLayout;
    }
}
