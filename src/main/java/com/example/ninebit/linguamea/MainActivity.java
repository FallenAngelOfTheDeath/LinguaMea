package com.example.ninebit.linguamea;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.ninebit.linguamea.activity.EditorActivity;
import com.example.ninebit.linguamea.adapter.ViewPagerAdapter;
import com.example.ninebit.linguamea.fragment.AboutFragment;
import com.example.ninebit.linguamea.fragment.GrammarFragment;
import com.example.ninebit.linguamea.fragment.HomeFragment;
import com.example.ninebit.linguamea.fragment.dictionaries.CustomDictionaryFragment;
import com.example.ninebit.linguamea.fragment.dictionaries.MainDictionaryFragment;
import com.example.ninebit.linguamea.fragment.dictionaries.OIDictionaryFragment;
import com.example.ninebit.linguamea.fragment.preference.CustomDictionaryPreferenceFragment;
import com.example.ninebit.linguamea.interfaces.ClickListener;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private DrawerLayout mDrawer;
    private Toolbar toolbar;
    private NavigationView nvDrawer;
    private ActionBarDrawerToggle drawerToggle;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private FrameLayout flContent;
    private FloatingActionButton floatingActionButton;
    private ViewPagerAdapter mViewPagerAdapter;
    private ClickListener mClickListener;

    private String LOGTAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linmea);

        floatingActionButton = (FloatingActionButton) findViewById(R.id.fab_activity);
        floatingActionButton.setOnClickListener(this);

        setGUI();

        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.flContent);
        if (fragment == null) {
            fragment = new HomeFragment();
            fm.beginTransaction().add(R.id.flContent, fragment).commit();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (drawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        drawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        drawerToggle.onConfigurationChanged(newConfig);
    }

    public void setGUI (){
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        nvDrawer = (NavigationView) findViewById(R.id.nvView);
        setupDrawerContent(nvDrawer);
        mDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawerToggle = setupDrawerToggle();
        mDrawer.addDrawerListener(drawerToggle);

        flContent = (FrameLayout) findViewById(R.id.flContent);
        flContent.setVisibility(View.VISIBLE);

        viewPager = (ViewPager) findViewById(R.id.viewpager);

        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs_bar);
        tabLayout.setupWithViewPager(viewPager);

        setupTabIcons();
    }

    private ActionBarDrawerToggle setupDrawerToggle() {
        return new ActionBarDrawerToggle(this, mDrawer, toolbar, R.string.drawer_open,  R.string.drawer_close);
    }

    private void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        selectDrawerItem(menuItem);
                        return true;
                    }
                });
    }

    public void selectDrawerItem(MenuItem menuItem) {
        switch(menuItem.getItemId()) {
            case R.id.nav_drawer_home:
                fragmentCommit(HomeFragment.class, null, menuItem, View.GONE, View.GONE, View.VISIBLE);
                break;
            case R.id.nav_drawer_dictionaries:
                fragmentCommit(MainDictionaryFragment.class, null, menuItem,View.VISIBLE, View.VISIBLE, View.GONE);
                break;
            case R.id.nav_drawer_grammar:
                fragmentCommit(GrammarFragment.class, null, menuItem,View.GONE, View.GONE, View.VISIBLE);
                break;
            case R.id.nav_drawer_settings:

                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.flContent, new CustomDictionaryPreferenceFragment())
                        .commit();

                tabLayout.setVisibility(View.GONE);
                viewPager.setVisibility(View.GONE);
                flContent.setVisibility(View.VISIBLE);
                mDrawer.closeDrawers();
                break;
            case R.id.nav_drawer_about:
                fragmentCommit(AboutFragment.class, null, menuItem,View.GONE, View.GONE, View.VISIBLE);
                break;
            default:
                fragmentCommit(HomeFragment.class, null, menuItem,View.GONE, View.GONE, View.VISIBLE);
        }


    }

    private void fragmentCommit (Class fragmentClass,Fragment fragment, MenuItem menuItem,
                                 int visibilityTab, int visibilityPager, int visibilityContent){

        try {
            fragment = (Fragment) fragmentClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.flContent, fragment).commit();
        menuItem.setChecked(true);
        setTitle(menuItem.getTitle());
        mDrawer.closeDrawers();

        tabLayout.setVisibility(visibilityTab);
        viewPager.setVisibility(visibilityPager);
        flContent.setVisibility(visibilityContent);
    }

    private void setupTabIcons() {
        TextView tabOne = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        tabOne.setText(R.string.main);
        tabOne.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_widgets, 0, 0, 0);
        tabLayout.getTabAt(0).setCustomView(tabOne);
        TextView tabTwo = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        tabTwo.setText(R.string.custom);
        tabTwo.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_pets, 0, 0, 0);
        tabLayout.getTabAt(1).setCustomView(tabTwo);
        TextView tabThree = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        tabThree.setText(R.string.oi_dictionary);
        tabThree.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_favorite, 0, 0, 0);
        tabLayout.getTabAt(2).setCustomView(tabThree);
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFrag(new MainDictionaryFragment(), getResources().getString(R.string.main));
        adapter.addFrag(new CustomDictionaryFragment(), getResources().getString(R.string.custom));
        adapter.addFrag(new OIDictionaryFragment(), getResources().getString(R.string.oi_dictionary));
        viewPager.setAdapter(adapter);
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
    public void onClick(View v) {
        Integer tabPosition = tabLayout.getSelectedTabPosition();
        switch (tabPosition){
            case 0:
                Snackbar
                        .make(v, "Main D",
                                Snackbar.LENGTH_SHORT)
                        .show();
                Log.i(LOGTAG, tabPosition.toString());
                break;
            case 1:
                Intent intent = new Intent(this, EditorActivity.class);
                startActivity(intent);
                Log.i(LOGTAG, tabPosition.toString());
                break;
            case 2:
                Snackbar
                        .make(v, "Favorite D",
                                Snackbar.LENGTH_SHORT)
                        .show();
                Log.i(LOGTAG, tabPosition.toString());
                break;
        }
    }
}
