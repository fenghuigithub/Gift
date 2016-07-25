package com.example.gift.View;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.gift.Controller.CustomImageView;
import com.example.gift.Controller.GalleryAdapter;
import com.example.gift.Controller.PersonAdapter;
import com.example.gift.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * Created by fenghui on 6/11/16.
 */
@SuppressLint("NewApi")
public class MainTab01 extends Fragment {
    //Gallary
    private RecyclerView mRecyclerView;
    private GalleryAdapter mAdapter;
    private List<Integer> mData;
    private List<String> tData;
    //Personality
    private RecyclerView nRecycleView;
    private PersonAdapter nAdapter;
    private List<Integer> nData;
    private List<String> eData;

    //Test circle picture
    private CustomImageView Image1;
    private CustomImageView Image2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle savedInstanceState){
        View newsLayout = inflater.inflate(R.layout.content_main,viewGroup,false);

        initData();
        //Gallary
        mRecyclerView = (RecyclerView) newsLayout.findViewById(R.id.recycle_horizontal);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        mRecyclerView.setLayoutManager(linearLayoutManager);

        mAdapter = new GalleryAdapter(getContext(), mData, tData);
        mAdapter.setOnItemClickListener(new GalleryAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(MainActivity.m, position + "", Toast.LENGTH_SHORT).show();
            }
        });
        mRecyclerView.setAdapter(mAdapter);

        //Personality
        nRecycleView = (RecyclerView) newsLayout.findViewById(R.id.recycle_personality);
        LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(getContext());
        linearLayoutManager1.setOrientation(LinearLayoutManager.HORIZONTAL);
        nRecycleView.setLayoutManager(linearLayoutManager1);

        nAdapter = new PersonAdapter(getContext(), nData, eData);
//        nAdapter.setOnItemClickListener1(new PersonAdapter.OnItemClickListener1() {
//            @Override
//            public void OnItemClick1(View view, int position) {
//                Toast.makeText(MainActivity, this, eData.get(position), Toast.LENGTH_SHORT).show();
//            }
//
//
//        });
        nRecycleView.setAdapter(nAdapter);

        //Test circle picture
        Image1 =(CustomImageView)newsLayout.findViewById(R.id.test1);
        Image1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.m,detail_list.class);
                startActivity(intent);
            }
        });
        Image2 =(CustomImageView)newsLayout.findViewById(R.id.test2);
        Image2.setOnClickListener(new View.OnClickListener(){
            @Override
             public void onClick(View v){
                Intent intent = new Intent(MainActivity.m,Function.class);
                startActivity(intent);
            }
        });

        return newsLayout;
    }
    private void initData() {
        mData = new ArrayList<>(Arrays.asList(R.drawable.a, R.drawable.b, R.drawable.c, R.drawable.d, R.drawable.e));
        tData = new ArrayList<>(Arrays.asList("Y", "U", "X", "I", "N"));
        nData = new ArrayList<>(Arrays.asList(R.drawable.f, R.drawable.g, R.drawable.h));
        eData = new ArrayList<>(Arrays.asList("Outgoing", "Shy", "Friendly"));


    }
}
