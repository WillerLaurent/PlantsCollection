package com.example.naturecollection.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.naturecollection.MainActivity;
import com.example.naturecollection.PlantModel;
import com.example.naturecollection.PlantRepository;
import com.example.naturecollection.R;
import com.example.naturecollection.adapter.PlantAdapter;
import com.example.naturecollection.adapter.PlantItemDecoration;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private MainActivity context;

    public HomeFragment(MainActivity context) {
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);

        //creer liste qui va stoker les plantes
        ArrayList<PlantModel> plantList = new ArrayList<>();

//        ArrayList<PlantModel> pList = PlantRepository.MySingleton.;

        //recuperer le recyclerview
        RecyclerView horizontalRecyclerView = view.findViewById(R.id.horizontal_recycler_view);
        horizontalRecyclerView.setAdapter(new PlantAdapter(context, plantList, R.layout.item_horizontal_plant));

        //recuperer le second recyclerview
        RecyclerView verticalRecyclerView = view.findViewById(R.id.vertical_recycler_view);
        verticalRecyclerView.setAdapter(new PlantAdapter(context, plantList, R.layout.item_vertical_plant));
        verticalRecyclerView.addItemDecoration(new PlantItemDecoration());

        return view;
    }
}


