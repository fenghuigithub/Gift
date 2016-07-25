package com.example.gift.View;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gift.R;

/**
 * Created by fenghui on 6/11/16.
 */
public class MainTab03 extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle savedInstanceState){
        View newsLayout = inflater.inflate(R.layout.main_tab_03,viewGroup,false);
        return newsLayout;
    }
}
