package com.iddamal.min.timetable;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.graphics.drawable.Drawable;
import android.support.design.widget.TabLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    // Variables -- model
    private ArrayList<Unit> mUnits;
    private ArrayList<Assessment> mAssessments;

    // Variables -- view
    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;
    public ProgressDialog mProgressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mProgressDialog = new ProgressDialog(MainActivity.this);

        // Setting up array lists
        mUnits = new ArrayList<>();
        mAssessments = new ArrayList<>();

        createDummyUnits();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);
    }

    public void createDummyUnits(){
        // Shows loading spinner until all of this is done
        this.mProgressDialog.setMessage("Generating");
        this.mProgressDialog.show();

        BackgroundGenerator mBackgroundGenerator = new BackgroundGenerator(getApplicationContext());

        Unit artsUnit = new Unit("Arts Hello", "ATS1011", R.drawable.arts_background, "Faculty of Arts");
        mBackgroundGenerator.createColours(artsUnit.getBackground());
        mUnits.add(artsUnit);

        Unit commUnit = new Unit("Commerce World", "BFC2011", R.drawable.commerce_background, "Faculty of Business and Economics");
        mBackgroundGenerator.createColours(commUnit.getBackground());
        mUnits.add(commUnit);

        Unit medUnit = new Unit("Intoduction to Medicine", "MED1040", R.drawable.medicine_background, "Faculty of Medicine");
        mBackgroundGenerator.createColours(medUnit.getBackground());
        mUnits.add(medUnit);

        Unit sciUnit = new Unit("Science Unit", "SCI1030", R.drawable.science_background, "Faculty of Science");
        mBackgroundGenerator.createColours(sciUnit.getBackground());
        mUnits.add(sciUnit);

        this.mProgressDialog.dismiss();
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

        switch (item.getItemId()) {
            case R.id.action_settings:
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return UnitFragment.newInstance();
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return mUnits.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mUnits.get(position).getUnitCode();
        }
    }
}
