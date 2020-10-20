package com.pucmm.primerparcial;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    public static int orientation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        orientation = getResources().getConfiguration().orientation;

        MenuFragment menuFragment = new MenuFragment();
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.mainLayout, menuFragment).commit();
    }

    @Override
    protected void onResume() {
        super.onResume();
        orientation = getResources().getConfiguration().orientation;
    }

}