package com.tyson.sciculum;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {
    private TextView name;
Button gbc_btn, gcs_btn, git_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        gbc_btn = findViewById(R.id.gbc_btn);
        gcs_btn = findViewById(R.id.gcs_btn);
        git_btn = findViewById(R.id.git_btn);

        gbc_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gbc = new Intent(HomeActivity.this, GbcActivity.class);
                startActivity(gbc);

            }
        });
        gcs_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gcs = new Intent(HomeActivity.this, GcsActivity.class);
                startActivity(gcs);
            }
        });
        git_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent git = new Intent(HomeActivity.this, GitActivity.class);
                startActivity(git);
            }
        });
        Intent getdata = getIntent();

        String  Username = getdata.getStringExtra("USERNAME");


        //finding the username and password
        name = findViewById(R.id.hello_text);

        name.setText("Hello " + Username);


    }
}