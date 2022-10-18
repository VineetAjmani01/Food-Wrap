package com.vineet.foodwrap;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class ResttaurantHomeFragment extends Fragment {

    TextView detailsrest, restdaterequest;
    int y1,m2,d3;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View myView = inflater.inflate(R.layout.fragment_resttaurant_home, container, false);

        restdaterequest = myView.findViewById(R.id.textView6);
        detailsrest = myView.findViewById(R.id.textView4);





        /*
        Bundle b =getIntent().getExtras();
        String fi = b.getString("food_item_key");
        String fc= b.getString("food_count_key");
        String date = b.getString("date_key");
        String NgoName = b.getString("ngo_name_key");
        String mn = b.getString("member_name_key");
        detailsrest.setText(" Food Item:- "+fi+"\n Food Count:- "+fc+"\n NGO Name:- "+NgoName+"\n Member Name:- "+mn);
        restdaterequest.setText("Date:- "+date);

        */

        // Inflate the layout for this fragment
        return myView;
    }
}