package com.example.events;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class PreviewActivity extends AppCompatActivity {

    private TextView mTvTitle;
    private TextView mTvDescription;
    private TextView mTvStartDate;
    private TextView mTvEndDate;
    private TextView mTvStartTime;
    private TextView mTvEndTime;
    private TextView mTvPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preview);
        initViews();
        setData();
    }

    private void setData() {
        Model model = (Model) getIntent().getSerializableExtra("model");
        mTvTitle.setText(model.getTitle());
        mTvDescription.setText(model.getDescription());
        mTvStartDate.setText(model.getStartDate());
        mTvEndDate.setText(model.getEndDate());
        mTvStartTime.setText(model.getStartTime());
        mTvEndTime.setText(model.getEndTime());
        mTvPrice.setText(model.getPrice());

    }

    private void initViews() {
        mTvTitle = findViewById(R.id.tvTitle);
        mTvDescription = findViewById(R.id.tvDescription);
        mTvStartDate = findViewById(R.id.tvStartDate);
        mTvEndDate = findViewById(R.id.tvEndDate);
        mTvStartTime = findViewById(R.id.tvStartTime);
        mTvEndTime = findViewById(R.id.tvEndTime);
        mTvPrice = findViewById(R.id.tvPrice);
    }
}