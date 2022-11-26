package com.midterm.appnauan1;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import com.midterm.appnauan1.databinding.ActivityDishItemBinding;

import java.util.ArrayList;

public class Dish_itemActivity extends AppCompatActivity {
    private ActivityDishItemBinding binding;
    private ArrayList<Food> arrayList;
    private DishAdappter dishAdappter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDishItemBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Intent it = getIntent();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ActionBar actionBar = getSupportActionBar();

        if(it!=null)
        {
            String data = it.getStringExtra("key");
            String name = it.getStringExtra("name");
            actionBar.setTitle(name);
            switch (data)
            {
                case "1":
                {
                    arrayList = new ArrayList<>();
                    dishAdappter = new DishAdappter(arrayList);
                    binding.rvFood.setAdapter(dishAdappter);
                    binding.rvFood.setLayoutManager(new GridLayoutManager(this, 3));
                    arrayList.add(new Food("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTL0eccbI5Zp-rQGkhfMQuuE1EmhY67m09doQ&usqp=CAU", "Món ăn cho cả nhà",1));
                    arrayList.add(new Food("https://cdn.pixabay.com/photo/2017/03/26/11/53/hors-doeuvre-2175326__340.jpg", "Khai vị và tráng miện",2));
                    arrayList.add(new Food("https://cdn.pixabay.com/photo/2019/02/22/23/50/goulash-4014661__340.jpg", "Công thức nấu canh",3));
                    arrayList.add(new Food("https://cdn.pixabay.com/photo/2016/01/02/04/59/coffee-1117933__340.jpg", "Pha cafe",4));
                    arrayList.add(new Food("https://cdn.pixabay.com/photo/2017/02/10/08/38/pasta-2054656__340.jpg", "Các món bún,mỳ",5));
                    arrayList.add(new Food("https://cdn.pixabay.com/photo/2016/08/04/11/56/smoke-1568953__340.jpg","Đồ nướng",6));
                    dishAdappter.notifyDataSetChanged();
                }
            }
        }
    }
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case android.R.id.home:
                onBackPressed();
                return  true;
            default: break;
        }
        return super.onOptionsItemSelected(item);
    }
}