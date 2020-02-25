package com.example.crystalshine;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toolbar;

import com.example.crystalshine.fragment.ProjectNameListFragment;
import com.example.crystalshine.fragment.ShopListFragment;
import com.example.crystalshine.fragment.TownshipListFragment;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    private String fragmentName;
    private TextView txttitle;

    private String mActivityTitle;
    private String[] items;

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;

    public static Intent getInstance(Context applicationContext) {
        return new Intent(applicationContext, MainActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txttitle = findViewById(R.id.tvTitle);
        Toolbar toolbar =  findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        init();
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle;
//        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
//                this, mDrawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
//        mDrawerLayout.addDrawerListener(toggle);
//        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.navView);
//        navigationView.setNavigationItemSelectedListener(this);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_dehaze_black_24dp);
    }

    private void init() {

        Intent intent = getIntent();
        fragmentName = intent.getStringExtra("fragment");

        Log.e("fragmentName",fragmentName);

        if(fragmentName.equals("Projects")){
            loadFragment(new ProjectNameListFragment());
            txttitle.setText("Projects");
        }
        if(fragmentName.equals("Township")){
            loadFragment(new TownshipListFragment());
            txttitle.setText("Township");
        }
        if(fragmentName.equals("ShopList")){
            loadFragment(new ShopListFragment());
            txttitle.setText("Shop List");
        }
    }
    private void loadFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.frame,fragment).commit();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    private void setSupportActionBar(Toolbar toolbar) {
    }
}
