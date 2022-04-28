package com.dhawal.petetite;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.dhawal.petetite.Database.Dao.UsersDao;
import com.dhawal.petetite.Database.Entity.User;
import com.dhawal.petetite.Database.UserDatabase;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private User user;
    public static int LOGGED_IN_ID;
    private TextView petsName;
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
        petsName = findViewById(R.id.main_petName);

        LOGGED_IN_ID = getIntent().getIntExtra(LoginActivity.EXTRA_LOGIN_ID,-1);
        UsersDao usersDao = UserDatabase.getDatabaseInstance(this).usersDao();
        UserDatabase.databaseWriteExecutor.execute(()->{
            user = usersDao.getUser(LOGGED_IN_ID);
            runOnUiThread(this::setPetName);
        });

        food_card.setOnClickListener(v->{
            Intent intent = new Intent(this,FoodActivity.class);
            startActivity(intent);
        });

        water_card.setOnClickListener(v->{
            Intent intent = new Intent (this,WaterActivity.class);
            startActivity(intent);
        });

        vaccine_card.setOnClickListener(v->{
            Intent intent = new Intent(this,VaccineActivity.class);
            startActivity(intent);
        });

        deWarming_card.setOnClickListener(v->{
            Intent intent = new Intent(this,DeWarmingActivity.class);
            startActivity(intent);
        });



    }
    public void setPetName(){
        petsName.setText(user.getPetsName()+"'s");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_activity_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_editProfile:
                Intent intentForEditActivity = new Intent(this,EditProfileActivity.class);
                startActivity(intentForEditActivity);
                break;
            case R.id.menu_logout:
                Intent intentForLoginActivity = new Intent(this,LoginActivity.class);
                startActivity(intentForLoginActivity);
                finish();
                break;

        }
        return true;
    }
}