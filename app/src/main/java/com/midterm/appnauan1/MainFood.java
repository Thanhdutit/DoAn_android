package com.midterm.appnauan1;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import com.midterm.appnauan1.databinding.ActivityMainFoodBinding;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MainFood extends AppCompatActivity {
    private ActivityMainFoodBinding binding;
    private ArrayList<MenuFood> arrayList;
    private ListFoodAdappter listFoodAdappter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainFoodBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ViewFlipper();
        arrayList = new ArrayList<>();
        listFoodAdappter = new ListFoodAdappter(arrayList);
        binding.rvFood.setAdapter(listFoodAdappter);
        binding.rvFood.setLayoutManager(new GridLayoutManager(this, 3));
        arrayList.add(new MenuFood("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTL0eccbI5Zp-rQGkhfMQuuE1EmhY67m09doQ&usqp=CAU", "Món ăn cho cả nhà",1));
        arrayList.add(new MenuFood("https://cdn.pixabay.com/photo/2017/03/26/11/53/hors-doeuvre-2175326__340.jpg", "Khai vị và tráng miệng",2));
        arrayList.add(new MenuFood("https://cdn.pixabay.com/photo/2019/02/22/23/50/goulash-4014661__340.jpg", "Công thức nấu canh",3));
        arrayList.add(new MenuFood("https://cdn.pixabay.com/photo/2016/01/02/04/59/coffee-1117933__340.jpg", "Pha cafe",4));
        arrayList.add(new MenuFood("https://cdn.pixabay.com/photo/2017/02/10/08/38/pasta-2054656__340.jpg", "Các món bún,mỳ",5));
        arrayList.add(new MenuFood("https://cdn.pixabay.com/photo/2016/08/04/11/56/smoke-1568953__340.jpg","Đồ nướng",6));
        listFoodAdappter.notifyDataSetChanged();



    }

    void ViewFlipper()
    {
        ArrayList<String> food = new ArrayList<>();
        food.add("https://cdn.pixabay.com/photo/2016/05/26/14/11/chef-1417239__340.png");
        food.add("https://cdn.pixabay.com/photo/2012/04/13/21/18/grilling-33664__340.png");
        food.add("https://cdn.pixabay.com/photo/2021/02/08/07/39/chef-5993951__340.jpg");
        for(int i=0 ;i<food.size();i++)
        {
            ImageView imageView = new ImageView(getApplicationContext());
            Picasso.get().load(food.get(i)).into(imageView);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            binding.viewFlipper.addView(imageView);

        }
        binding.viewFlipper.setFlipInterval(5000);
        binding.viewFlipper.setAutoStart(true);
        Animation animation_in = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_in_right);
        Animation animation_out = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_out_right);
        binding.viewFlipper.setInAnimation(animation_in);
        binding.viewFlipper.setOutAnimation(animation_out);



    }
}