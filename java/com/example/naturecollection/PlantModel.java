package com.example.naturecollection;

public class PlantModel {

    //fields
    private String name = "Tulipe";
    private String description = "Petite description";
    private String imageUrl = "http://graven.yt/plante.jpg";
    private Boolean liked = false;

    //constructor
    public PlantModel(String name, String description, String imageUrl, Boolean liked) {
        this.name = name;
        this.description = description;
        this.imageUrl = imageUrl;
        this.liked = liked;
    }

    //methods
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Boolean getLiked() {
        return liked;
    }

    public void setLiked(Boolean liked) {
        this.liked = liked;
    }
}
