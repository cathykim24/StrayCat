package edu.skku.swp3.straycat.Donation;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import edu.skku.swp3.straycat.R;

public class DonationCashListFragment extends Fragment {
    private RecyclerView recyclerView;
    private CashHistoryAdapter adapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // View 인스턴스화 및 레퍼런스 할당
        View rootView =  inflater.inflate(R.layout.donation_cashlist, container, false);
        recyclerView = rootView.findViewById(R.id.recycler_view);

        ArrayList<CashHistory> historyList = (ArrayList<CashHistory>) getArguments().getSerializable("historyList");
        this.adapter = new CashHistoryAdapter(historyList);

        //리사이클러뷰에 데이터 넣기
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(container.getContext()));

        return rootView;
    }
}
