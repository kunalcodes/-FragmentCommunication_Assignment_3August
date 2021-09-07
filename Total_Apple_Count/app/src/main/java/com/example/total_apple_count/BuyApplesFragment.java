package com.example.total_apple_count;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class BuyApplesFragment extends Fragment {

    private EditText mEtApplesBuy;
    private int totalApples;
    private CommunicationListener listener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_buy_apples, container, false);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments()!= null){
            totalApples = getArguments().getInt("Total Apples");
        }
    }


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        listener = (CommunicationListener) context;
    }

    @Override
    public void onStop() {
        super.onStop();
        int buyApples = Integer.parseInt(mEtApplesBuy.getText().toString());
        totalApples = totalApples - buyApples;
        Bundle bundle = new Bundle();
        bundle.putInt("Apples", totalApples);
        Log.d("Kunal", "onStop: "+totalApples);
        if (listener != null){
            listener.sendApplesData(bundle);
        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);
    }

    private void initViews(View view) {
        mEtApplesBuy = view.findViewById(R.id.etApplesBuy);
    }
}