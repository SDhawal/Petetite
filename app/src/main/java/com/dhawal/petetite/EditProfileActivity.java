package com.dhawal.petetite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.dhawal.petetite.Database.Dao.UsersDao;
import com.dhawal.petetite.Database.Entity.User;
import com.dhawal.petetite.Database.UserDatabase;
import com.google.android.material.textfield.TextInputLayout;

public class EditProfileActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private User user;
    private TextInputLayout username,password,petsName,petsAge;
    private Spinner petType;
    private Button update;
    private String petTypeContainer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        username = findViewById(R.id.edit_username);
        password = findViewById(R.id.edit_password);
        petsName = findViewById(R.id.edit_pet_name);
        petsAge =  findViewById(R.id.edit_pets_age);
        petType =  findViewById(R.id.edit_pet_type);
        update = findViewById(R.id.edit_update);

        //adapter
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.pet_type, android.R.layout.simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        petType.setAdapter(adapter);
        petType.setOnItemSelectedListener(this);

        UsersDao usersDao = UserDatabase.getDatabaseInstance(this).usersDao();
        UserDatabase.databaseWriteExecutor.execute(()->{
            user = usersDao.getUser(MainActivity.LOGGED_IN_ID);
            runOnUiThread(this::populateFields);
        });

        update.setOnClickListener(v->{
            user.setUserName(getValue(username));
            user.setPassword(getValue(password));
            user.setPetsName(getValue(petsName));
            user.setPetType(petTypeContainer);

        UserDatabase.databaseWriteExecutor.execute(()->{
            usersDao.update(user);
            runOnUiThread(()->Toast.makeText(this, "Profile Updated Successfully", Toast.LENGTH_SHORT).show());
        });
        });

    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        petTypeContainer = parent.getItemAtPosition(position).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    private void populateFields(){
        username.getEditText().setText(user.getUserName());
        password.getEditText().setText(user.getPassword());
        petsName.getEditText().setText(user.getPetsName());
        petsAge.getEditText().setText(user.getPetsAge());

    }
    private String getValue(TextInputLayout view) {
        return view.getEditText().getText().toString();
    }
}
