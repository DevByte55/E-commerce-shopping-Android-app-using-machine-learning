package com.app.shoprecommendationsystem.Prevalent;



import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.app.shoprecommendationsystem.Interface.ItemClickListner;
import com.app.shoprecommendationsystem.R;

import java.text.BreakIterator;
import java.text.StringCharacterIterator;

public class CartViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    public TextView txtProductName,txtProductPrice,txtProductQuantity,txtProductStatus;

    private ItemClickListner itemClickListner;

    public CartViewHolder(View itemView) {
        super(itemView);
        txtProductName = itemView.findViewById(R.id.cart_product_name);
        txtProductPrice = itemView.findViewById(R.id.cart_product_price);
        txtProductQuantity = itemView.findViewById(R.id.cart_product_quantity);
        txtProductStatus = itemView.findViewById(R.id.cart_product_status);
    }

    @Override
    public void onClick(View view) {
        itemClickListner.onClick(view,getAdapterPosition(),false);
    }

    public void setItemClickListner(ItemClickListner itemClickListner) {
        this.itemClickListner = itemClickListner;
    }
}


