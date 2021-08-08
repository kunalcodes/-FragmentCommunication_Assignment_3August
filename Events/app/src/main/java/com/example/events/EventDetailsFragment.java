package com.example.events;

import android.content.Context;
import android.icu.text.CaseMap;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class EventDetailsFragment extends Fragment {

    private Button mBtnNext;
    private EditText mEtTitle;
    private EditText mEtDescription;
    private CommunicationListener listener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_event_details, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        listener = (CommunicationListener) context;
    }

    private void initViews(View view) {
        mBtnNext = view.findViewById(R.id.btnNext1);
        mEtTitle = view.findViewById(R.id.etTitle);
        mEtDescription = view.findViewById(R.id.etDescription);

        mBtnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Title = mEtTitle.getText().toString();
                String Description = mEtDescription.getText().toString();
                Bundle bundle = new Bundle();
                bundle.putString("Title", Title);
                bundle.putString("Description", Description);
                if (listener != null){
                    listener.launchDateTimeFragment(bundle);
                }
            }
        });
    }
}