package edu.skku.swp3.straycat;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class DonationSnackFragment extends Fragment {
    private RecyclerView recyclerViewSnack;
    private SnackItemAdapter adapter;
    private ArrayList<CashHistory> historyList;

    private OnItemBuyListener onItemBuyListener;

    public void setOnItemBuyListener(OnItemBuyListener onItemBuyListener) {
        this.onItemBuyListener = onItemBuyListener;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.donation_snack, container, false);
        recyclerViewSnack = rootView.findViewById(R.id.recyler_view_snack);

        historyList = (ArrayList<CashHistory>) getArguments().getSerializable("historyList");
        this.adapter = new SnackItemAdapter();

        recyclerViewSnack.setAdapter(adapter);
        recyclerViewSnack.setLayoutManager(new GridLayoutManager(getContext(),2,GridLayoutManager.VERTICAL,false));

        recyclerViewSnack.addOnItemTouchListener(
                new RecyclerItemClickListener(getContext(), recyclerViewSnack, new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        showAddCashDialog(adapter.get(position));
                    }
                }));


        adapter.addItem(new SnackItem("8",R.drawable.tuna_can,"참치캔"));
        adapter.addItem(new SnackItem("14",R.drawable.snack2,"츄르세트"));
        adapter.addItem(new SnackItem("2",R.drawable.snack3,"미니츄르(새우)"));
        adapter.addItem(new SnackItem("23",R.drawable.snack4,"Temptations"));

        return rootView;
    }
    void showAddCashDialog(final SnackItem item)
    {
        final EditText edittext = new EditText(getContext());

        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("간식 구매");
        builder.setMessage("캐시를 사용해 구매하시겠습니까?");
        builder.setPositiveButton("예",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        historyList.add(new CashHistory(item.snackName, -Integer.parseInt(item.money)));
                        Toast.makeText(getContext(),  "\"" + item.snackName + "\" 구매완료" ,Toast.LENGTH_LONG).show();
                        if(onItemBuyListener!=null) onItemBuyListener.onItemBuy(item);
                        SnackItemViewModel snackItemViewModel = ViewModelProviders.of(getActivity()).get(SnackItemViewModel.class);
                        snackItemViewModel.snackInventory.add(item);
                    }
                });
        builder.setNegativeButton("아니요",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
        builder.show();
    }

    interface OnItemBuyListener {
        void onItemBuy(SnackItem item);
    }
}