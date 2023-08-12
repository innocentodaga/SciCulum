package com.tyson.sciculum;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CreateActivity extends AppCompatActivity {
    Button btn;
    private EditText name, password, email, confirmPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);

        name = findViewById(R.id.name);
        password = findViewById(R.id.password);
        email = findViewById(R.id.emial);
        confirmPassword = findViewById(R.id.confirm_password);
        btn = findViewById(R.id.create_btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String Username = name.getText().toString();
                String Useremail = email.getText().toString();
                String Userpassword = password.getText().toString();
                String Confirmpassword = confirmPassword.getText().toString();

                //making a function to validate the user input
                boolean check = validateinfor(Username, Useremail, Userpassword, Confirmpassword);

                if (check){
                    Toast.makeText(getApplicationContext(), "Data is valid",Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(getApplicationContext(), "Sorry check information", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private boolean validateinfor(String Username, String Useremail, String Userpassword, String Confirmpassword){
        if (Username.length() == 0){
            name.requestFocus();
            name.setError("Name cannot be empty!");
            return false;
        } else if (!Username.matches("[a-zA-Z]+")) {
            name.requestFocus();
            name.setError("Enter only alphabet characters!");
            return false;
        } else if (Useremail.length()==0) {
            email.requestFocus();
            email.setError("Email cannot be empty!");
            return false;
        } else if (!Useremail.matches("[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+")) {
            email.requestFocus();
            email.setError("Enter valid email!");
            return false;
        } else if (Userpassword.length()<6) {
            password.requestFocus();
            password.setError("Minimum length is 6 characters!");
            return false;
        } else if (!Userpassword.matches("[a-zA-Z0-9]+")) {
            password.requestFocus();
            password.setError("User characters and Numbers only");
            return false;
        }
        /* else if (Usernumber.length()==0) {
            number.requestFocus();
            number.setError("Number cannot be empty!");
            return false;
        }
        else if (!Usernumber.matches("^[+][0-9]{10,13}$")){
            number.requestFocus();
            number.setError("Correct format is +256xxxxxxxxx!");
            return false;
        }
        */
        else {
            Intent login = new Intent(CreateActivity.this, LoginActivity.class);
            startActivity(login);
            return true;
        }

    }
}