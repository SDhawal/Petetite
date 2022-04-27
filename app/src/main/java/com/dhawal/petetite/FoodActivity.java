package com.dhawal.petetite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TimePicker;

public class FoodActivity extends AppCompatActivity {
private TextView morningTime,noonTime,nightTime;
private Button morningTimeChangeButton,noonTimeChangeButton,nightTimeChangeButton;
private ImageButton timeSetButton;
private TimePicker timePicker;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);

        morningTime = findViewById(R.id.food_morning_time);
        noonTime = findViewById(R.id.food_afternoon_time);
        nightTime =findViewById(R.id.food_night_time);
        morningTimeChangeButton =findViewById(R.id.food_change_morning_time);
        noonTimeChangeButton = findViewById(R.id.food_change_afternoon_time);
        nightTimeChangeButton = findViewById(R.id.food_change_night_time);
        timeSetButton = findViewById(R.id.food_set);
        LinearLayout linearLayout = findViewById(R.id.food_linearLayout);

        morningTimeChangeButton.setOnClickListener(v->{
            linearLayout.setVisibility(View.VISIBLE);
            timeSetButton.setOnClickListener(setTime->{

            });
        });

        nightTimeChangeButton.setOnClickListener(v->{
            linearLayout.setVisibility(View.VISIBLE);
        });

        noonTimeChangeButton.setOnClickListener(v->{
            linearLayout.setVisibility(View.VISIBLE);
        });



    }
}