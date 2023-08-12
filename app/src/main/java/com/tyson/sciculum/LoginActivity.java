package com.tyson.sciculum;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
Button btn;
EditText name, password;
TextView display;

TextView signUp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btn = findViewById(R.id.login_btn);
        signUp = findViewById(R.id.sign_up);
        name = findViewById(R.id.name);
        password = findViewById(R.id.password);
        display = findViewById(R.id.hello_text);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String Username = name.getText().toString();
                String Userpassword = password.getText().toString();

                //validating the input
              boolean check =  validateinfor(Username, Userpassword);
              if (check){
                  Toast.makeText(getApplicationContext(), "Login successfully", Toast.LENGTH_SHORT).show();
              }
              else {
                  Toast.makeText(getApplicationContext(), "Sorry check the information", Toast.LENGTH_SHORT).show();
              }
            }
        });
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent create = new Intent(LoginActivity.this, CreateActivity.class);
                startActivity(create);
            }
        });
    }
    private boolean validateinfor(String Username, String Userpassword){
        if (Username.length()==0){
            name.requestFocus();
            name.setError("name cannot be empty");
            return false;
        } else if (!Username.matches("[a-zA-Z]+")) {
            name.requestFocus();
            name.setError("Enter valid name!");
            return false;
        } else if (Userpassword.length()<6) {
            password.requestFocus();
            password.setError("Minimun length is 6 characters");
            return false;
        } else if (!Userpassword.matches("[a-zA-Z0-9.-_@]+")) {
            password.requestFocus();
            password.setError("Enter valid password!");
            return false;
        }
        else {
            Intent home = new Intent(LoginActivity.this, HomeActivity.class);
            home.putExtra("USERNAME", Username);
            startActivity(home);
            return true;
        }
    }
}