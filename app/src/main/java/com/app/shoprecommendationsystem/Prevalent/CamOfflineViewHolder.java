package com.app.shoprecommendationsystem.Prevalent;



import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.app.shoprecommendationsystem.Interface.ItemClickListner;
import com.app.shoprecommendationsystem.R;

import java.text.BreakIterator;
import java.text.StringCharacterIterator;

public class CamOfflineViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    TextView result, confidence;
    ImageView imageView;
    Button picture;

    private ItemClickListner itemClickListner;

    public CamOfflineViewHolder(View itemView) {
        super(itemView);
        result = result.findViewById(R.id.result);
        confidence = confidence.findViewById(R.id.confidence);
        imageView = imageView.findViewById(R.id.imageView);
        picture = picture.findViewById(R.id.Take_Picture);
    }

    @Override
    public void onClick(View view) {
        itemClickListner.onClick(view,getAdapterPosition(),false);
    }

    public void setItemClickListner(ItemClickListner itemClickListner) {
        this.itemClickListner = itemClickListner;
    }
}



