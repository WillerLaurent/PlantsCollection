package com.example.naturecollection.adapter;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.naturecollection.MainActivity;
import com.example.naturecollection.PlantModel;
import com.example.naturecollection.R;

import java.util.ArrayList;
import java.util.List;

public class PlantAdapter extends RecyclerView.Adapter<PlantAdapter.ViewHolder>{

    private MainActivity context;
    private int layoutId;
    private List<PlantModel> plantList;

    //construtor
    public PlantAdapter(MainActivity context,  List plantList, int layoutId) {

        this.context = context;
        this.plantList = plantList;
        this.layoutId = layoutId;
    }


    // boite pour ranger tous les composants à controler
    public static class ViewHolder extends RecyclerView.ViewHolder {

        private final ImageView plantImage;
        private ImageView starIcon;
        private TextView plantName;
        private TextView plantDescription;

        public ViewHolder(View view) {
            super(view);

            plantImage = view.findViewById(R.id.image_item);
            starIcon = view.findViewById(R.id.star_icon);

            //this field only exist in item_vertical_plant
            if (view.findViewById(R.id.name_item) != null) {
                plantName = view.findViewById(R.id.name_item);
            }

            //this field only exist in item_vertical_plant
            if (view.findViewById(R.id.description_item) != null) {
                plantDescription = view.findViewById(R.id.description_item);
            }
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(layoutId, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) { //holder contient le viewHolder rempli plus haut
        //recuperer infos de chaque plante selon position
        PlantModel currentPlant = plantList.get(position);


        //use glide pour recuperer image a partir de son lien
        Glide.with(context).load(Uri.parse(currentPlant.getImageUrl())).into(holder.plantImage);

       //update plant name
        //this field only exist in item_vertical_plant
        if (holder.plantName != null) {
            holder.plantName.setText(currentPlant.getName());
        }

        //update plant description
        //this field only exist in item_vertical_plant
        if (holder.plantDescription != null) {
            holder.plantDescription.setText(currentPlant.getDescription());
        }

        //check if plant is liked
        if (currentPlant.getLiked() == Boolean.TRUE) {
            holder.starIcon.setImageResource(R.drawable.ic_star);
        }
        else {
            holder.starIcon.setImageResource(R.drawable.ic_unstar);
        }
    }

    @Override
    public int getItemCount() {
        return plantList.size();
    }
}
