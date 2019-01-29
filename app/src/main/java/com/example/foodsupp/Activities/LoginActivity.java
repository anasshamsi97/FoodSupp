package com.example.foodsupp.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.foodsupp.R;

public class LoginActivity extends AppCompatActivity {

    private EditText username, password;
    private Button login;
    private TextView signUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = findViewById(R.id.et_username);
        password = findViewById(R.id.et_password);
        signUp = findViewById(R.id.signup);
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, SignUpActivity.class));
            }
        });
        login = findViewById(R.id.btn_login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                authenticate();
            }
        });
    }

    private void authenticate() {
        if (TextUtils.isEmpty(username.getText()) || TextUtils.isEmpty(password.getText()))
            Toast.makeText(this, "Username or password cant be empty"
                    , Toast.LENGTH_SHORT).show();

        else if (username.getText().toString().equals("test")
                && password.getText().toString().equals("test")) {
            startActivity(new Intent(this, MainActivity.class));
            finish();
        } else
            Toast.makeText(this, "Username or password is wrong"
                    , Toast.LENGTH_SHORT).show();
    }
}
