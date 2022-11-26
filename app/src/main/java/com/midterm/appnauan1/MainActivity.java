package com.midterm.appnauan1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.midterm.appnauan1.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ConstraintLayout btnWelcome;
    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        btnWelcome = findViewById(R.id.btn_welcome);
        btnWelcome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,MainFood.class);
                startActivity(intent);
            }
        });
    }
}