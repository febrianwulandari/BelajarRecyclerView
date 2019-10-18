package com.iky.apprecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rv_food;
    private ArrayList<Food> foods;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv_food = findViewById(R.id.rv_food);
        foods = new ArrayList<>();
        foods.add( new Food("Pisang Coklat",5, 10000, true));
        foods.add( new Food("Cimol",2.5f, 4000, true));
        foods.add( new Food("burger",1, 20000, false));
        foods.add( new Food("Bakso",5, 8000, true));
        foods.add( new Food("pizza",1, 100000, false));
        foods.add( new Food("cilok",5, 5000, true));

        LinearLayoutManager lm = new LinearLayoutManager(this);
        FoodAdapter adapter = new FoodAdapter(this,foods);
        DividerItemDecoration divider = new DividerItemDecoration(this,lm.getOrientation());
        rv_food.setLayoutManager(lm);
        rv_food.setAdapter(adapter);
        rv_food.addItemDecoration(divider);
    }
}
