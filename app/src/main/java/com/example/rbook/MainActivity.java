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
    private Button page2_btn;
    private Button page3_btn;

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
        page2_btn = findViewById(R.id.secondPage);
        page3_btn = findViewById(R.id.thridPage);

        home_btn.setOnClickListener(this);
        page2_btn.setOnClickListener(this);
        page3_btn.setOnClickListener(this);

        View homepage = View.inflate(MainActivity.this, R.layout.homepage, null);
        View page2 = View.inflate(MainActivity.this, R.layout.page2, null);
        View page3 = View.inflate(MainActivity.this, R.layout.page3, null);
        views = new ArrayList<View>();
        views.add((homepage));
        views.add(page2);
        views.add(page3);

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
                Toast.makeText(this, "Page2", Toast.LENGTH_SHORT).show();
                break;
            case R.id.thridPage:
                viewPager.setCurrentItem(2);
                Toast.makeText(this, "Page3", Toast.LENGTH_SHORT).show();
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
