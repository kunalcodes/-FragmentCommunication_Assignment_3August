package com.example.events;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class EventActivity extends AppCompatActivity implements CommunicationListener {

    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fragmentManager = getSupportFragmentManager();
        setContentView(R.layout.activity_event);
        launchStudentEventDetailsFragment();
    }

    private void launchStudentEventDetailsFragment() {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        EventDetailsFragment eventDetailsFragment = new EventDetailsFragment();
        fragmentTransaction.add(R.id.container, eventDetailsFragment, "EventDetails").commit();
    }

    @Override
    public void launchDateTimeFragment(Bundle bundle) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        TimeAndDateFragment timeAndDateFragment = new TimeAndDateFragment();
        timeAndDateFragment.setArguments(bundle);
        fragmentTransaction.replace(R.id.container, timeAndDateFragment, "TimeAndDate").commit();
    }

    @Override
    public void launchPriceFragment(Bundle bundle) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        PriceDetailsFragment priceDetailsFragment = new PriceDetailsFragment();
        priceDetailsFragment.setArguments(bundle);
        fragmentTransaction.replace(R.id.container, priceDetailsFragment, "PriceDetails").commit();
    }
}