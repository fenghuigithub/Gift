package com.example.gift.View;

import android.annotation.SuppressLint;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.example.gift.R;

public class MainActivity extends AppCompatActivity implements OnClickListener{

    public static MainActivity m;
    //Bottom bar
//    private ViewPager mViewPager;
//    private FragmentPagerAdapter bAdapter;
//    private List<Fragment> mFragment = new ArrayList<>();
    private MainTab02 mTab02;
    private MainTab01 mTab01;
    private MainTab03 mTab03;
    private MainTab04 mTab04;

    private LinearLayout mTabBtnHome;
    private LinearLayout mTabBtnLove;
    private LinearLayout mTabBtnSetting;
    private LinearLayout mTabBtnAbout;
    private FragmentManager fragmentManager;


    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
//    private GoogleApiClient client;

    @SuppressLint("NewApi")

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        m=this;
        initView();


        fragmentManager = getFragmentManager();
        setTabSelection(0);





    }





    private void initView(){
        mTabBtnHome = (LinearLayout)findViewById(R.id.id_tab_bottom_home);
        mTabBtnLove = (LinearLayout)findViewById(R.id.id_tab_bottom_love);
        mTabBtnSetting = (LinearLayout)findViewById(R.id.id_tab_bottom_setting);
        mTabBtnAbout = (LinearLayout)findViewById(R.id.id_tab_bottom_about);

        mTabBtnHome.setOnClickListener(this);
        mTabBtnLove.setOnClickListener(this);
        mTabBtnSetting.setOnClickListener(this);
        mTabBtnAbout.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
       switch(v.getId()){
           case R.id.id_tab_bottom_home:
               setTabSelection(0);
               break;
           case R.id.id_tab_bottom_love:
               setTabSelection(1);
               break;
           case R.id.id_tab_bottom_setting:
               setTabSelection(2);
               break;
           case R.id.id_tab_bottom_about:
               setTabSelection(3);
               break;
           default:break;
       }
    }
    @SuppressLint("NewApi")

    private void setTabSelection(int index){
        resetTabBtn();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        hideFragments(transaction);
        switch (index){
            case 0:
                ((ImageButton)mTabBtnHome.findViewById(R.id.btn_tab_bottom_home)).setImageResource(R.drawable.tab_home_pressed);
                if(mTab01==null){
                    mTab01 = new MainTab01();
                    transaction.add(R.id.id_content, mTab01);
                }
                else{
                    transaction.show(mTab01);
                }
                break;
            case 1:
                ((ImageButton)mTabBtnLove.findViewById(R.id.btn_tab_bottom_love)).setImageResource(R.drawable.tab_love_pressed);
                if(mTab02==null){
                    mTab02 = new MainTab02();
                    transaction.add(R.id.id_content, mTab02);
                }
                else{
                    transaction.show(mTab02);
                }
                break;
            case 2:
                ((ImageButton)mTabBtnSetting.findViewById(R.id.btn_tab_bottom_setting)).setImageResource(R.drawable.tab_setting_pressed);
                if(mTab03==null){
                    mTab03 = new MainTab03();
                    transaction.add(R.id.id_content, mTab03);
                }
                else{
                    transaction.show(mTab03);
                }
                break;
            case 3:
                ((ImageButton)mTabBtnAbout.findViewById(R.id.btn_tab_bottom_about)).setImageResource(R.drawable.tab_about_pressed);
                if(mTab04 == null){
                    mTab04 = new MainTab04();
                    transaction.add(R.id.id_content, mTab04);
                }
                else{
                    transaction.show(mTab04);
                }
                break;

        }
        transaction.commit();
    }

    public void resetTabBtn(){
        ((ImageButton)mTabBtnHome.findViewById(R.id.btn_tab_bottom_home)).setImageResource(R.drawable.tab_home_normal);
        ((ImageButton)mTabBtnLove.findViewById(R.id.btn_tab_bottom_love)).setImageResource(R.drawable.tab_love_normal);
        ((ImageButton)mTabBtnSetting.findViewById(R.id.btn_tab_bottom_setting)).setImageResource(R.drawable.tab_setting_normal);
        ((ImageButton)mTabBtnAbout.findViewById(R.id.btn_tab_bottom_about)).setImageResource(R.drawable.tab_about_normal);
    }

    @SuppressLint("NewApi")

    private void hideFragments(FragmentTransaction transaction)
    {
        if (mTab01 != null)
        {
            transaction.hide(mTab01);
        }
        if (mTab02 != null)
        {
            transaction.hide(mTab02);
        }
        if (mTab03 != null)
        {
            transaction.hide(mTab03);
        }
        if (mTab04 != null)
        {
            transaction.hide(mTab04);
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
