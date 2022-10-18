package com.vineet.foodwrap;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class FeedFragment extends Fragment {
    private RecyclerView recyclerView;

    private ArrayList<Feed> arrayList;





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View myView = inflater.inflate(R.layout.fragment_feed, container, false);


        arrayList = new ArrayList<>();

        recyclerView = myView.findViewById(R.id.recyclerView);

        arrayList.add(new Feed(R.drawable.profilephoto, R.drawable.post, "Vineet Ajmani", "message"));
        arrayList.add(new Feed(R.drawable.profilephoto, R.drawable.post1, "Vineet Ajmani", "message"));
        arrayList.add(new Feed(R.drawable.profilephoto, R.drawable.post, "Vineet Ajmani", "message"));
        arrayList.add(new Feed(R.drawable.profilephoto, R.drawable.post1, "Vineet Ajmani", "message"));
        arrayList.add(new Feed(R.drawable.profilephoto, R.drawable.post, "Vineet Ajmani", "message"));

        recyclerView = myView.findViewById(R.id.recyclerView);

        RecyclerAdapter recyclerAdapter = new RecyclerAdapter(arrayList);




        recyclerView.setAdapter(recyclerAdapter);


        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));


        // Inflate the layout for this fragment
        return myView;
    }
}