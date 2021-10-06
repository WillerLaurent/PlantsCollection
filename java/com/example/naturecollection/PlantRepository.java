package com.example.naturecollection;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class PlantRepository {

    public class MySingleton {

        //connect to plant reference
        DatabaseReference databaseRef = FirebaseDatabase.getInstance().getReference("plants");

        //create plants list
        ArrayList<PlantModel> plantList = new ArrayList<>();

        private MySingleton() {
        }

        private MySingleton uniqueInstance;

        public MySingleton getINSTANCE() {

            if (uniqueInstance == null) {
                uniqueInstance = new MySingleton();
            }
            return uniqueInstance;
        }

        public DatabaseReference getDatabaseRef() {
            return databaseRef;
        }

        public ArrayList<PlantModel> getPlantList() {
            return plantList;
        }
    }

    public void updateData() {
        // absorber les donnees depuis databaseRef -> plantList
        MySingleton mySingleton = new MySingleton();
        mySingleton.getDatabaseRef().addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                //vider la liste
                mySingleton.getPlantList().clear();

                //recolter la liste
                for (DataSnapshot ds : snapshot.getChildren()) {
                    // creer objet plante
                    PlantModel plant = ds.getValue(PlantModel.class);

                    //verifier que la plante n'est pas nulle
                    if (plant != null) {
                        mySingleton.getPlantList().add(plant);
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}
