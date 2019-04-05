package com.example.admin.greenifythegardenapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.google.firebase.auth.FirebaseAuth;

public class Ngo extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private  static WebView browser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ngo);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.ngo_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        browser=(WebView)findViewById(R.id.web_ngo);
        String url="https://www.kenils.org/ngos-for-tree-plantation/";
        browser.getSettings().getJavaScriptEnabled();
        browser.loadUrl(url);
        browser.setWebViewClient(new WebViewClient());

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.ngo_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.drawer, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_logout) {
            FirebaseAuth.getInstance().signOut();
            Intent i = new Intent(getApplicationContext(),WelcomeActivity.class);
            startActivity(i);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id=item.getItemId();
        switch (id){

            case R.id.nav_Guide:
                Intent h= new Intent(Ngo.this,DrawerActivity.class);
                startActivity(h);
                break;
            case R.id.nav_Ngo:
                Intent i= new Intent(Ngo.this,Ngo.class);
                startActivity(i);
                break;
            case R.id.nav_ToolShop:
                Intent g= new Intent(Ngo.this,ToolShop.class);
                startActivity(g);
                break;

            case R.id.nav_Event:
                Intent t= new Intent(Ngo.this,Event.class);
                startActivity(t);
                break;
            case R.id.nav_setting:
                Intent s = new Intent(  Ngo.this,SettingsActivity.class);
                startActivity(s);
                break;
            case R.id.nav_find:
                Intent m = new Intent(  Ngo.this,MapsActivity.class);
                startActivity(m);
                break;

        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.ngo_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
