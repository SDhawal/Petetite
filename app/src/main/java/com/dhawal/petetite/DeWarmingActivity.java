package com.dhawal.petetite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class DeWarmingActivity extends AppCompatActivity {
    private TextView previousDate,nextDate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_de_warming);

        previousDate = findViewById(R.id.deWarming_lastDoneOn);
        nextDate = findViewById(R.id.deWarming_nextVaccinationOn);

        EditText nextDay = findViewById(R.id.deWarming_nextDay);
        EditText nextMonth = findViewById(R.id.deWarming_nextMonth);
        EditText nextYear = findViewById(R.id.deWarming_nextYear);
        LinearLayout layout = findViewById(R.id.deWarming_layout);
        Button setNextDate = findViewById(R.id.deWarming_setNextDate);
        Button confirmDate = findViewById(R.id.deWarming_confirmNextDate);

        setNextDate.setOnClickListener(v->{
            layout.setVisibility(View.VISIBLE);
        });

        confirmDate.setOnClickListener(v->{
            int day = Integer.parseInt(nextDay.getText().toString());
            int month = Integer.parseInt(nextMonth.getText().toString());
            int year = Integer.parseInt(nextYear.getText().toString());
            if (!(day<=31&&month<=12&&year<=2030)){
                Toast.makeText(this, "DD-MM-YYYY format Accepted", Toast.LENGTH_SHORT).show();
                layout.setVisibility(View.INVISIBLE);
            }
            if (day<=0&&month<=0&&year<=2022){
                Toast.makeText(this, "DD-MM-YYYY format Accepted", Toast.LENGTH_SHORT).show();
                layout.setVisibility(View.INVISIBLE);
            }
            if (day<=0&&month<=0&&year<=2022){
                Toast.makeText(this, "DD-MM-YYYY format Accepted", Toast.LENGTH_SHORT).show();
                layout.setVisibility(View.INVISIBLE);
            }
            String DATE = day+"-"+month+"-"+year;
            nextDate.setText(DATE);

            layout.setVisibility(View.INVISIBLE);
        });

    }

}