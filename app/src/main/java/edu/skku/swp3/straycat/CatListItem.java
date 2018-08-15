package edu.skku.swp3.straycat;

import java.io.Serializable;

public class CatListItem implements Serializable{
    public int imageResId;
    public String catAddress;
    public String catSpecies;

    public CatListItem(int imageResId, String catAddress, String catSpecies) {
        this.imageResId = imageResId;
        this.catAddress = catAddress;
        this.catSpecies = catSpecies;
    }
}
