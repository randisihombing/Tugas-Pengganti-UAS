package com.example.icontact;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;


import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class IntroActivity extends AppCompatActivity {

    private ViewPager screenPager;
    IntroViewPagerAdapter introViewPagerAdapter;
    TabLayout tabIndicator;
    Button btnGetStarted;
    int position = 0;
    Animation btnAnim;

    @Override
    protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        //agar activity full screen
        requestWindowFeature(Window.FEATURE_ACTION_BAR);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_intro);

        //hide action bar


        //views
        tabIndicator = findViewById(R.id.tab_indicator);
        btnGetStarted = findViewById(R.id.btn_get_started);
        btnAnim = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.button_animation);


        //listscreen
        final List<ScreenItem> mList = new ArrayList<>();
        mList.add(new ScreenItem("Hello.. Welcome To MyApps","Ini adalah aplikasi android tentang Tempat Wisata yang ada di daerah Bandung",R.drawable.tmpt_wisata));
        mList.add(new ScreenItem("First App","Aplikasi ini berisi informasi berupa Maps untuk setiap lokasi tempat wisata",R.drawable.tmpt_wisata));
        mList.add(new ScreenItem("What Inside?","Selamat mencoba menjelajahi aplikasi",R.drawable.tmpt_wisata));

        //bagian viewpager
        screenPager = findViewById(R.id.screen_viewpager);
        introViewPagerAdapter = new IntroViewPagerAdapter(this,mList);
        screenPager.setAdapter(introViewPagerAdapter);

        //tablayout
        tabIndicator.setupWithViewPager(screenPager);

        tabIndicator.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                if(tab.getPosition() == mList.size()-1){
                    loadLastScreen();
                }

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


        //GetStarted Listener

        btnGetStarted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //open Main Activity

                Intent navActivity = new Intent (getApplicationContext(),MenuActivity.class);
                startActivity(navActivity);


            }
        });


    }
    //menampilkan tombol getStarted
    private void loadLastScreen(){

        btnGetStarted.setVisibility(View.VISIBLE);
        tabIndicator.setVisibility(View.INVISIBLE);
        //
        //
        btnGetStarted.setAnimation(btnAnim);

    }
}
