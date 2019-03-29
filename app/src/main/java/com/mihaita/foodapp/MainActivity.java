package com.mihaita.foodapp;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener
{

    private DrawerLayout dl;
    private ActionBarDrawerToggle t;

    FoodsAdapter foodsAdapter;
    private List<Foods> foodsList = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //modify action bar
        dl = (DrawerLayout) findViewById(R.id.drawer_layout);
        t = new ActionBarDrawerToggle
                (this, dl, R.string.nav_open, R.string.nav_close);
        dl.addDrawerListener(t);
        t.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        NavigationView nv = findViewById(R.id.nav_view);
        nv.setNavigationItemSelectedListener(this);

//
//        //setting the recycler view
//        RecyclerView recycle = findViewById(R.id.recycle1);
//        foodsAdapter = new FoodsAdapter(foodsList);
//
//
//        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
//        recycle.setLayoutManager(layoutManager);
//        recycle.setItemAnimator(new DefaultItemAnimator());
//
//        // OPTIONAL
//        recycle.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
//
//        DBClass db = new DBClass(this);
//        foodsList.addAll(db.getFoods());
//
//        recycle.setAdapter(foodsAdapter);


    }

    //make menu clickable
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (t.onOptionsItemSelected(item))
            return true;
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.nav_history) {
            Intent i = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(i);

        }

        if (item.getItemId() == R.id.nav_note) {

            Intent i = new Intent(getApplicationContext(), AddNote.class);
            startActivity(i);
        }


        if (item.getItemId() == R.id.nav_exit) {

            finish();
            System.exit(0);
        }

        dl.closeDrawer(GravityCompat.START);
        return true;
    }

}
