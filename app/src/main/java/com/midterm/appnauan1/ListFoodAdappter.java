package com.midterm.appnauan1;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public  class ListFoodAdappter extends RecyclerView.Adapter<ListFoodAdappter.ViewHolder> {
    private static ArrayList<MenuFood> arrayList;
    private static Context context;
    public ListFoodAdappter(ArrayList<MenuFood> MenuFood) {
        this.arrayList = MenuFood;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.menu_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.name.setText(arrayList.get(position).getName());
        Picasso.get().load(arrayList.get(position).getAvatar()).into(holder.avatar);
        holder.cardView.setCardBackgroundColor(Color.rgb(248, 239, 186));

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView name;
        public ImageView avatar;
        public CardView cardView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            avatar = (ImageView)itemView.findViewById(R.id.avatar);
            name = (TextView)itemView.findViewById(R.id.name);
            cardView = (CardView)itemView.findViewById(R.id.card);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(view.getContext(),Dish_itemActivity.class);
                    intent.putExtra("key",String.valueOf(arrayList.get(getAdapterPosition()).getKey()));
                    intent.putExtra("name",arrayList.get(getAdapterPosition()).getName());
                    view.getContext().startActivity(intent);

                }
            });
        }



    }
}
