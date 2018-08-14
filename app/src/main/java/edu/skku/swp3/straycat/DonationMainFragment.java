package edu.skku.swp3.straycat;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class DonationMainFragment extends Fragment {

    private TextView tvCash;
    private Map fragmentMap = new HashMap<Integer, Fragment>();
    public ArrayList<CashHistory> historyList = new ArrayList();

    {
        fragmentMap.put(R.id.cv_cashlist_donation, new DonationCashListFragment());
        fragmentMap.put(R.id.cv_co_sponsor, new DonationCo_SponsorFragment());

        DonationSnackFragment donationSnackFragment = new DonationSnackFragment();
        donationSnackFragment.setOnItemBuyListener(new DonationSnackFragment.OnItemBuyListener() {
            @Override
            public void onItemBuy(SnackItem item) {
                updateCashSum();
            }
        });
        fragmentMap.put(R.id.cv_snack_donation, donationSnackFragment);

        //어댑터에 임시 데이터 넣기
        historyList.add(new CashHistory("캐시충전", 100));

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.donation_main, container, false);

        Iterator<Integer> itr = fragmentMap.keySet().iterator();

        while(itr.hasNext()){
            View cardView = view.findViewById(itr.next());
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view){
                    Log.d("Test", "card view clicked");
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("historyList", historyList);

                    Fragment nextFragment = (Fragment)fragmentMap.get(view.getId());
                    nextFragment.setArguments(bundle);
                    FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                    transaction.addToBackStack(null);
                    transaction.add(R.id.nav_fragment, nextFragment);
                    transaction.commit();
                }
            });
        }

        view.findViewById(R.id.cv_add_cash).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showAddCashDialog();
            }
        });
        view.findViewById(R.id.cv_minus_cash).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showMinusCashDialog();
            }
        });

        tvCash = view.findViewById(R.id.tv_cash);
        updateCashSum();

        return view;
    }

    void showAddCashDialog()
    {
        final EditText edittext = new EditText(getContext());

        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("캐시 충전하기");
        builder.setMessage("충전할 캐시를 입력하세요");
        builder.setView(edittext);
        builder.setPositiveButton("입력",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        int addCash =Integer.parseInt(edittext.getText().toString());
                        historyList.add(new CashHistory("캐시충전", addCash));
                        updateCashSum();
//                        Toast.makeText(getContext(),edittext.getText().toString() ,Toast.LENGTH_LONG);
                    }
                });
        builder.setNegativeButton("취소",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
        builder.show();
    }

    void showMinusCashDialog()
    {
        final EditText edittext = new EditText(getContext());

        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("캐시 내보내기");
        builder.setMessage("내보낼 캐시를 입력하세요");
        builder.setView(edittext);
        builder.setPositiveButton("입력",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        int minusCash = -Integer.parseInt(edittext.getText().toString());
//                        Toast.makeText(getContext(),edittext.getText().toString() ,Toast.LENGTH_LONG);
                        historyList.add(new CashHistory("내보내기", minusCash));
                        updateCashSum();
                    }
                });
        builder.setNegativeButton("취소",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
        builder.show();
    }

    private void updateCashSum() {
        int sum = 0;
        for(CashHistory history : historyList) {
            sum += history.money;
        }
        tvCash.setText(String.valueOf(sum));
    }

}
