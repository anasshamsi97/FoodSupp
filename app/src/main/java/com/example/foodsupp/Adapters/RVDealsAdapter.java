package com.example.foodsupp.Adapters;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.foodsupp.Activities.MainActivity;
import com.example.foodsupp.Activities.OrderActivity;
import com.example.foodsupp.POJO.Deals;
import com.example.foodsupp.R;
import com.example.foodsupp.ViewHolders.RVDealsViewHolder;

import java.util.ArrayList;

/**
 * Created by Muhammad Anas Shamsi on 11/24/18.
 */
public class RVDealsAdapter extends RecyclerView.Adapter<RVDealsViewHolder> {

    private ArrayList<Deals> dealsArrayList;
    private MainActivity mainActivity;

    public RVDealsAdapter(ArrayList<Deals> dealsArrayList, MainActivity mainActivity) {
        this.dealsArrayList = dealsArrayList;
        this.mainActivity = mainActivity;
    }

    @NonNull
    @Override
    public RVDealsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.rv_item_deals, viewGroup, false);

        return new RVDealsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RVDealsViewHolder rvDealsViewHolder, int i) {
        Deals deals = dealsArrayList.get(i);
        rvDealsViewHolder.dealTitle.setText(deals.getDealTitle());
        rvDealsViewHolder.dealPrice.setText(deals.getDealPrice());
        rvDealsViewHolder.deliveryTime.setText(Html.fromHtml(deals.getDeliveryTime()));

        rvDealsViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainActivity.startActivity(new Intent(mainActivity,OrderActivity.class));
            }
        });
    }

    @Override
    public int getItemCount() {
        return dealsArrayList.size();
    }
}

