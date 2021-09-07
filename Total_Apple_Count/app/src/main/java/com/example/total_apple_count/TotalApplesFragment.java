package com.example.total_apple_count;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class TotalApplesFragment extends Fragment {

    private Button mBtnNext;
    private EditText mEtApplesAvailable;
    private TextView mTvApplesAvailable;
    private CommunicationListener listener;
    private int totalApples;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_total_apples, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);


    }

    @Override
    public void onResume() {
        super.onResume();

    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        listener = (CommunicationListener) context;
    }

    private void initViews(View view) {
        mBtnNext = view.findViewById(R.id.btnNext);
        mEtApplesAvailable = view.findViewById(R.id.etApplesAvailable);
        mTvApplesAvailable = view.findViewById(R.id.tvApplesAvailable);

        getParentFragmentManager().addOnBackStackChangedListener(new FragmentManager.OnBackStackChangedListener() {
            @Override
            public void onBackStackChanged() {
                if (getParentFragmentManager().getBackStackEntryCount() == 0){
                    if (getArguments()!= null){
                        totalApples = getArguments().getInt("Apples");
                        Log.d("Kunal", "onCreate: "+totalApples);
                    }
                        mTvApplesAvailable.setText(totalApples+"");
                }
            }
        });

        mBtnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int TotalApples = Integer.parseInt(mEtApplesAvailable.getText().toString());
                Bundle bundle = new Bundle();
                bundle.putInt("Total Apples", TotalApples);
                if (listener != null){
                    listener.launchBuyApplesFragment(bundle);
                }
            }
        });
    }
}