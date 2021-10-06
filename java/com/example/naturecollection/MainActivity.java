package com.example.naturecollection;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

import com.example.naturecollection.fragments.HomeFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //charger le repository
        PlantRepository repo = new PlantRepository();

        //update plant list
        repo.updateData();

        //pour passer le context en parametre
        HomeFragment homeFragment = new HomeFragment(this);

        // inject fragment in box
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.fragment_container, homeFragment, null)
                .addToBackStack(null)
                .commit();
    }
}