package com.dhawal.petetite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.dhawal.petetite.Database.Dao.UsersDao;
import com.dhawal.petetite.Database.Entity.User;
import com.dhawal.petetite.Database.UserDatabase;
import com.google.android.material.snackbar.Snackbar;

public class LoginActivity extends AppCompatActivity {
EditText username , password;
Button loginButton;
TextView goToRegister;
    public static final String EXTRA_LOGIN_ID = "LoginId";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = findViewById(R.id.login_username);
        password = findViewById(R.id.login_password);
        loginButton = findViewById(R.id.login_loginButton);
        goToRegister = findViewById(R.id.login_register);

        goToRegister.setOnClickListener(v->{
            Intent intent = new Intent(this, RegisterActivity.class);
            startActivity(intent);
        });

        UsersDao usersDao = UserDatabase.getDatabaseInstance(this).usersDao();

        loginButton.setOnClickListener(v->{
            String userNameValue = username.getText().toString();
            String passwordValue = password.getText().toString();

            UserDatabase.databaseWriteExecutor.execute(()->{
                if (!usersDao.exist(userNameValue)) {
                    runOnUiThread(() -> {
                        Toast.makeText(this, "Invalid Username", Toast.LENGTH_SHORT).show();

                    });
                    return;
                } else {
                    runOnUiThread(() -> username.setError(null));
                }

                User user = usersDao.validate(userNameValue,passwordValue);
                if (user == null) {
                    runOnUiThread(() -> {
                        Toast.makeText(this, "Invalid Password", Toast.LENGTH_SHORT).show();

                });
                    return;
                } else {
                    runOnUiThread(() -> password.setError(null));
                }

                Intent goToMainActivity = new Intent(this,MainActivity.class);
                goToMainActivity.putExtra(EXTRA_LOGIN_ID,user.getId());
                startActivity(goToMainActivity);
                finish();
            });
        });

    }
}