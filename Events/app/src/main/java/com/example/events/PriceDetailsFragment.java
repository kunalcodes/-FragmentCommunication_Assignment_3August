package com.example.events;

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


public class PriceDetailsFragment extends Fragment {

    private EditText mEtCurrency;
    private EditText mEtPrice;
    private Button mBtnPreview;
    private String Title;
    private String Description;
    private String StartDate;
    private String EndDate;
    private String StartTime;
    private String EndTime;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_price_details, container, false);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments()!= null){
            Title = getArguments().getString("Title");
            Description = getArguments().getString("Description");
            StartDate = getArguments().getString("StartDate");
            EndDate = getArguments().getString("EndDate");
            StartTime = getArguments().getString("StartTime");
            EndTime = getArguments().getString("EndTime");
        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);
    }

    private void initViews(View view) {
        mEtCurrency = view.findViewById(R.id.etCurrency);
        mEtPrice = view.findViewById(R.id.etPrice);
        mBtnPreview = view.findViewById(R.id.btnPreview);

        mBtnPreview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String Price = mEtPrice.getText().toString() + " " + mEtCurrency.getText().toString();
                Model model = new Model(Title, Description, StartDate, EndDate, StartTime, EndTime, Price);
                Intent intent = new Intent(getActivity(), PreviewActivity.class);
                intent.putExtra("model", model);
                startActivity(intent);
            }
        });
    }

}