package com.example.foodsupp.ViewHolders;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.foodsupp.R;

/**
 * Created by Muhammad Anas Shamsi on 11/24/18.
 */
public class RVDealsViewHolder extends RecyclerView.ViewHolder {

    public TextView deliveryTime,dealPrice,dealTitle;

    public RVDealsViewHolder(@NonNull View itemView) {
        super(itemView);

        deliveryTime = itemView.findViewById(R.id.delivery_time);
        dealPrice = itemView.findViewById(R.id.deal_price);
        dealTitle = itemView.findViewById(R.id.deal_title);
    }
}
