package edu.skku.swp3.straycat;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import java.util.ArrayList;

public class SnackItemViewModel extends ViewModel {
    ArrayList<SnackItem> snackInventory = new ArrayList<SnackItem>();
}
