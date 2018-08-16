package edu.skku.swp3.straycat;

import java.io.Serializable;

public class CatListItem implements Serializable{
    public int imageResId;
    public String catAddress;
    public String catSpecies;
    public String catName;

    public int getImageResId() {
        return imageResId;
    }

    public void setImageResId(int imageResId) {
        this.imageResId = imageResId;
    }

    public String getCatAddress() {
        return catAddress;
    }

    public void setCatAddress(String catAddress) {
        this.catAddress = catAddress;
    }

    public String getCatSpecies() {
        return catSpecies;
    }

    public void setCatSpecies(String catSpecies) {
        this.catSpecies = catSpecies;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }


    public CatListItem(int imageResId, String catAddress, String catSpecies, String catName) {
        this.imageResId = imageResId;
        this.catAddress = catAddress;
        this.catSpecies = catSpecies;
        this.catName = catName;
    }
}
