package com.example.total_apple_count;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity implements CommunicationListener {

    private FragmentManager fragmentManager;
    private TotalApplesFragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fragmentManager = getSupportFragmentManager();
        setContentView(R.layout.activity_main);
        launchTotalApplesFragment();
    }


    private void launchTotalApplesFragment() {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragment = new TotalApplesFragment();
        fragmentTransaction.add(R.id.container, fragment, "TotalApples").commit();
    }

    @Override
    public void launchBuyApplesFragment(Bundle bundle) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        BuyApplesFragment buyApplesFragment = new BuyApplesFragment();
        buyApplesFragment.setArguments(bundle);
        fragmentTransaction.replace(R.id.container, buyApplesFragment, "personalDetailsFragment").addToBackStack("BuyApplesFragment").commit();

    }

    @Override
    public void sendApplesData(Bundle bundle) {
        fragment.setArguments(bundle);
        Log.d("Kunal", "sendApplesData: "+bundle.getInt("Apples"));
    }
}