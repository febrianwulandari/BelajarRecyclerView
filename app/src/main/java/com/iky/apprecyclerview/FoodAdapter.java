package com.iky.apprecyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.ViewHolder>{

    private Context mContext;
    //food diambil dari nama folder object
    private ArrayList<Food> foods;

    public FoodAdapter(Context mContext, ArrayList<Food> foods) {
        this.mContext = mContext;
        this.foods = foods;
    }

    @NonNull
    @Override
    //menentukan layout untuk menmpilkan data
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        // false dia,bil dari ViewGroup parent di public view holder
        View view = inflater.inflate(R.layout.tampilan_list_food_item,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }
        // menentukan data apa yang akan tampil
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Food currentFood = foods.get(position);
        holder.name.setText(currentFood.getName());
        holder.price.setText(currentFood.getPrice()+"");
        holder.rate.setRating(currentFood.getRate());
        if(currentFood.getFave()){
            holder.Fave.setImageResource(R.drawable.ic_mood_black_24dp);
        } else{
            holder.Fave.setImageResource(R.drawable.ic_mood_bad_black_24dp);
        }
    }

    @Override
    public int getItemCount() {
        return foods.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView Fave;
        TextView name,price;
        RatingBar rate;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            Fave = itemView.findViewById(R.id.Fave);
            name = itemView.findViewById(R.id.txtname);
            price = itemView.findViewById(R.id.txtprice);
            rate = itemView.findViewById(R.id.ratingBar);
        }
    }
}
