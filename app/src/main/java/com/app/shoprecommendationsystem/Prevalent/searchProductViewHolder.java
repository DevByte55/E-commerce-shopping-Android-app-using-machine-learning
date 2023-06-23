package com.app.shoprecommendationsystem.Prevalent;



import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.app.shoprecommendationsystem.Interface.ItemClickListner;
import com.app.shoprecommendationsystem.R;

import java.text.BreakIterator;
import java.text.StringCharacterIterator;

public class searchProductViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    private Button searchBtn;
    private EditText inputText;
    private RecyclerView searchList;
    private String searchInput;

    private ItemClickListner itemClickListner;

    public searchProductViewHolder(View itemView) {
        super(itemView);
        inputText = inputText.findViewById(R.id.search_product_name);
        searchBtn = searchBtn.findViewById(R.id.search_btn);
        searchList = searchList.findViewById(R.id.search_list);
    }

    @Override
    public void onClick(View view) {
        itemClickListner.onClick(view,getAdapterPosition(),false);
    }

    public void setItemClickListner(ItemClickListner itemClickListner) {
        this.itemClickListner = itemClickListner;
    }
}




