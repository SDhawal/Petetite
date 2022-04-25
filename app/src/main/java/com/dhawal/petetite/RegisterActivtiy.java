package com.dhawal.petetite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.material.textfield.TextInputLayout;

public class RegisterActivtiy extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private TextInputLayout username, password, confirmPassword, petsName, petsAge;
    private Spinner petType;
    private Button register;
    private String petTypeContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_activtiy);

        username = findViewById(R.id.register_username);
        password = findViewById(R.id.register_password);
        confirmPassword = findViewById(R.id.register_confirm_password);
        petsAge = findViewById(R.id.register_pets_age);
        petsName = findViewById(R.id.register_pet_name);
        petType = findViewById(R.id.register_pet_type);
        register = findViewById(R.id.register_register);

        confirmPassword.setOnFocusChangeListener((v, hasFocus) -> {
            if (!password.getEditText().getText().equals(confirmPassword.getEditText().getText())) {
                confirmPassword.setError("Passwords did not match");
            }
        });


        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.pet_type, android.R.layout.simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        petType.setAdapter(adapter);
        petType.setOnItemSelectedListener(this);

        //main validations
        register.setOnClickListener(v->{
            if (isAllInformationFilled(username,password,confirmPassword,petsAge,petsName)){
                return;
            }

            if(!isPasswordMatched(password,confirmPassword)){
                return;
            }


        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        petTypeContainer = parent.getItemAtPosition(position).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
    private boolean isAllInformationFilled(TextInputLayout... views){
        boolean errorFound =false;
        for(TextInputLayout view : views){
            String valueEntered = view.getEditText().getText().toString();
            if(valueEntered.isEmpty()&&petTypeContainer.isEmpty()){
                Toast.makeText(this, "All the fields are mandatory", Toast.LENGTH_SHORT).show();
                errorFound=true;
            }else{
                errorFound=false;
            }

        }
        return errorFound;
    }

    private boolean isPasswordMatched(@NonNull TextInputLayout password,@NonNull TextInputLayout confirmPassword){
        String passwordValue = password.getEditText().getText().toString();
        String reenterPasswordValue = confirmPassword.getEditText().getText().toString();
        if (!passwordValue.equals(reenterPasswordValue)){
            Toast.makeText(this, "Passwords Should Match", Toast.LENGTH_SHORT).show();
            return false;
        }else{
            return true;
        }
    }

    private String getValue(@NonNull TextInputLayout view){
        return view.getEditText().getText().toString();
    }

}