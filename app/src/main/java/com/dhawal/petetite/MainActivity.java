package com.dhawal.petetite;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
CardView food_card,water_card,vaccine_card,deWarming_card,bath_card,medical_card;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        food_card= findViewById(R.id.main_food);
        water_card=findViewById(R.id.main_water);
        vaccine_card=findViewById(R.id.main_vaccine);
        deWarming_card=findViewById(R.id.main_de_warming);
        bath_card = findViewById(R.id.main_bath);
        medical_card = findViewById(R.id.main_medical);

        food_card.setOnClickListener(v->{
            Intent intent = new Intent(this,FoodActivity.class);
            startActivity(intent);
        });

        water_card.setOnClickListener(v->{
            Intent intent = new Intent (this,WaterActivity.class);
            startActivity(intent);
        });




    }
}