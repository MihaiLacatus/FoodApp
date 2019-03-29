package com.mihaita.foodapp;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.util.List;

public class FoodsAdapter extends RecyclerView.Adapter<FoodsAdapter.MyViewHolder> {

    List<Foods> foodsList;

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView displayDate, displayFoodName, displayCalories,displayQuantity,displayTotal;

        MyViewHolder(View view) {
            super(view);

            displayDate = view.findViewById(R.id.display_date);
            displayFoodName = view.findViewById(R.id.display_foodName);
            displayCalories = view.findViewById(R.id.display_calories);
            displayQuantity = view.findViewById(R.id.display_quantity);
            displayTotal = view.findViewById(R.id.display_totalCalories);

        }
    }

    FoodsAdapter(List<Foods> foodsList){this.foodsList = foodsList;}



    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.foodrow, viewGroup, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder viewHolder, int i) {
        final Foods foods = foodsList.get(i);

        viewHolder.displayDate.setText(String.valueOf(foods.getDate()));
        viewHolder.displayFoodName.setText(foods.getFoodName());
        viewHolder.displayCalories.setText(String.valueOf(foods.getCalories()));
        viewHolder.displayQuantity.setText(String.valueOf(foods.getQuantity()));
        viewHolder.displayTotal.setText(String.valueOf(foods.getCalories() * foods.getQuantity()));


    }

    @Override
    public int getItemCount()  {
        return this.foodsList.size();
    }
}
