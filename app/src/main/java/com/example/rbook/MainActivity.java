package com.example.rbook;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,ViewPager.OnPageChangeListener {

    private Button home_btn;
    private Button library_btn;
    private Button profile_btn;

    MyPagerAdapter adapter;
    ViewPager viewPager;
    List<View> views;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    public void init() {
        home_btn = findViewById(R.id.homePage);
        library_btn = findViewById(R.id.secondPage);
        profile_btn = findViewById(R.id.thridPage);
        home_btn.setOnClickListener(this);
        library_btn.setOnClickListener(this);
        profile_btn.setOnClickListener(this);

        View homepage = View.inflate(MainActivity.this, R.layout.homepage, null);
        View library = View.inflate(MainActivity.this, R.layout.library, null);
        View profile = View.inflate(MainActivity.this, R.layout.profile, null);
        views = new ArrayList<View>();
        views.add((homepage));
        views.add(library);
        views.add(profile);

        this.adapter = new MyPagerAdapter(views);

        viewPager = findViewById(R.id.viewpage);
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(0);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.homePage:
                Toast.makeText(this, "HomePage", Toast.LENGTH_SHORT).show();
                viewPager.setCurrentItem(0);
                break;
            case R.id.secondPage:
                viewPager.setCurrentItem(1);
                Toast.makeText(this, "Library", Toast.LENGTH_SHORT).show();
                break;
            case R.id.thridPage:
                viewPager.setCurrentItem(2);
                Toast.makeText(this, "Profile", Toast.LENGTH_SHORT).show();
                break;
        }
    }
    @Override
    public void onPageScrollStateChanged(int arg0) {

    }

    @Override
    public void onPageScrolled(int arg0, float arg1, int arg2) {

    }

    @Override
    public void onPageSelected(int arg0) {

    }
}
