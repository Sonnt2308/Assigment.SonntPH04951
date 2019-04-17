package com.example.quynh.assigment;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.quynh.assigment.fragment.Fr_AboutUs;
import com.example.quynh.assigment.fragment.Fr_Category;
import com.example.quynh.assigment.fragment.Fr_Gift;
import com.example.quynh.assigment.fragment.Fr_Latest;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        addFragment(new Fr_Category());
    }

    public void addFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frlayout, fragment);
        fragmentTransaction.commit();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        int id = item.getItemId();

        if (id == R.id.nav_lates) {

            Fr_Latest latest = new Fr_Latest();
            fragmentTransaction.replace(R.id.frlayout, latest);
            toolbar.setTitle("Latest");
            Toast.makeText(this, "LATEST", Toast.LENGTH_SHORT).show();

        } else if (id == R.id.nav_category) {

            Fr_Category category = new Fr_Category();
            fragmentTransaction.replace(R.id.frlayout, category);
            toolbar.setTitle("Category");
            Toast.makeText(this, "CATEGORY", Toast.LENGTH_SHORT).show();

        } else if (id == R.id.nav_gift) {

            Fr_Gift gift = new Fr_Gift();
            fragmentTransaction.replace(R.id.frlayout, gift);
            toolbar.setTitle("Gift");
            Toast.makeText(this, "GIFT", Toast.LENGTH_SHORT).show();

        } else if (id == R.id.nav_favorites) {

        } else if (id == R.id.nav_tareap) {

        } else if (id == R.id.nav_moreapp) {

        } else if (id == R.id.nav_aboutus) {

            Fr_AboutUs aboutUs = new Fr_AboutUs();
            fragmentTransaction.replace(R.id.frlayout, aboutUs);
            toolbar.setTitle("About Us");
            Toast.makeText(this, "ABOUT US", Toast.LENGTH_SHORT).show();

        } else if (id == R.id.nav_setting) {

        } else if (id == R.id.nav_police) {

        }

        fragmentTransaction.commit();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }




}
