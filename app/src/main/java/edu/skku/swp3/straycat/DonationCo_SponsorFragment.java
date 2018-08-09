package edu.skku.swp3.straycat;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class DonationCo_SponsorFragment extends Fragment {
    private RecyclerView recyclerViewSnack;
    private SnackItemAdapter adapter;
    private SnackItemViewModel snackItemViewModel;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.donation_snack, container, false);
        recyclerViewSnack = rootView.findViewById(R.id.recyler_view_snack);

        snackItemViewModel  = ViewModelProviders.of(getActivity()).get(SnackItemViewModel.class);

        adapter = new SnackItemAdapter();
        adapter.setItems(snackItemViewModel.snackInventory);

        recyclerViewSnack.setAdapter(adapter);
        recyclerViewSnack.setLayoutManager(new GridLayoutManager(getContext(), 2, GridLayoutManager.VERTICAL, false));

        return rootView;

    }

}