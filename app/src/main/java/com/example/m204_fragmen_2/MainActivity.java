package com.example.m204_fragmen_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        FragmentA fa = new FragmentA();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.container,fa)
                .commit();

    }
}