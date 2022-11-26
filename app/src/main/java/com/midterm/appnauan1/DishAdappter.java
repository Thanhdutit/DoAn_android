package com.midterm.appnauan1;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class DishAdappter extends RecyclerView.Adapter<DishAdappter.ViewHolder> {
    private static ArrayList<Food> arrayList;
    public DishAdappter(ArrayList<Food> food) {
        this.arrayList = food;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.dish_food,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.name.setText(arrayList.get(position).getName());
        Picasso.get().load(arrayList.get(position).getAvatar()).into(holder.avatar);

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView name;
        public ImageView avatar;
        public ImageView love;
        private boolean like = false;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            avatar = (ImageView)itemView.findViewById(R.id.avatar);
            name = (TextView)itemView.findViewById(R.id.name);
            love = (ImageView)itemView.findViewById(R.id.love);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int  id = arrayList.get(getAdapterPosition()).getId();
                    Intent intent = new Intent(view.getContext(), Food_details.class);
                    intent.putExtra("id",String.valueOf(id));
                    view.getContext().startActivity(intent);

                }
            });
            love.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Toast.makeText(view.getContext(), "click",Toast.LENGTH_SHORT).show();
                    if(!like)
                    {
                        love.setImageResource(R.drawable.love1);
                        like = true;
                    }
                    else {
                        love.setImageResource(R.drawable.love);
                        like = false;
                    }
                }
            });
        }
    }
}
