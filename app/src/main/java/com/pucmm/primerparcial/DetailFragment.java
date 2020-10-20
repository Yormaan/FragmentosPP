package com.pucmm.primerparcial;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class DetailFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail, container, false);

        TextView textView = (TextView)view.findViewById(R.id.txt_Details);

        Bundle bundle = getArguments();
        if(bundle != null){
            if(bundle.getString("selected_data") != null){
                textView.setText(bundle.getString("selected_data"));
            }
        }

        return view;
    }
}