package com.example.foodsupp.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.foodsupp.R;

import java.util.Objects;

public class OrderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Place Order");
    }
}
