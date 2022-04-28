package com.dhawal.petetite;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class WaterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_water);

        TextView valueOfTimeInterval = findViewById(R.id.water_interval_value);
        EditText setTimeInterval = findViewById(R.id.water_set_interval);
        Button setNotifier = findViewById(R.id.water_set_notifyAlert);

        setNotifier.setOnClickListener(v->{
            valueOfTimeInterval.setText(setTimeInterval.getText());
            NotificationCompat.Builder builder = new NotificationCompat.Builder(this, String.valueOf(valueOfTimeInterval))
                    .setSmallIcon(R.drawable.water)
                    .setContentTitle("Woof-Woof")
                    .setContentText("Time to refill my Water Bowl")
                    .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                    .setCategory(NotificationCompat.CATEGORY_REMINDER);

            setTimeInterval.setText("");

        });
    }
}