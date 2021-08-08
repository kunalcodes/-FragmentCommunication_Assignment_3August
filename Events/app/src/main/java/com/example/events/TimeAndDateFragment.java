package com.example.events;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class TimeAndDateFragment extends Fragment {

    private EditText mEtStartDate;
    private EditText mEtEndDate;
    private EditText mEtStartTime;
    private EditText mEtEndTime;
    private Button mBtnNext;
    private String Title;
    private String Description;
    private CommunicationListener listener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_time_and_date, container, false);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        listener = (CommunicationListener) context;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments()!= null){
            Title = getArguments().getString("Title");
            Description = getArguments().getString("Description");
        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);
    }

    private void initViews(View view) {
        mEtStartDate = view.findViewById(R.id.etStartDate);
        mEtEndDate = view.findViewById(R.id.etEndDate);
        mEtStartTime = view.findViewById(R.id.etStartTime);
        mEtEndTime = view.findViewById(R.id.etEndTime);
        mBtnNext = view.findViewById(R.id.btnNext2);

        mBtnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String StartDate = mEtStartDate.getText().toString();
                String EndDate = mEtEndDate.getText().toString();
                String StartTime = mEtStartTime.getText().toString();
                String EndTime = mEtEndTime.getText().toString();
                Bundle bundle = new Bundle();
                bundle.putString("Title", Title);
                bundle.putString("Description", Description);
                bundle.putString("StartDate", StartDate);
                bundle.putString("EndDate", EndDate);
                bundle.putString("StartTime", StartTime);
                bundle.putString("EndTime", EndTime);
                if (listener != null){
                    listener.launchPriceFragment(bundle);
                }
            }
        });
    }
}