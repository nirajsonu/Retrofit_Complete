package com.neeraj.task.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.neeraj.task.R;
import com.neeraj.task.dao.UserDao;

public class LoginActivity extends AppCompatActivity {
   private Button login;
    TextView register;
    EditText email,password;
    UserDao db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        login=findViewById(R.id.login);
        register=findViewById(R.id.register);
        email=findViewById(R.id.email);
        password=findViewById(R.id.password);
        db=new UserDao(LoginActivity.this);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user_email = email.getText().toString();
                String user_password = password.getText().toString();
                Boolean res = db.checkUser(user_email, user_password);
                if (TextUtils.isEmpty(user_email)) {
                    email.setError("Please fill email");
                }
                else if(TextUtils.isEmpty(user_password))
                {
                    password.setError("please fill password");
                }
                else
                    {
                    if (res) {
                        Toast.makeText(LoginActivity.this, "Login sucess", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(LoginActivity.this, ShowActivity.class);
                        startActivity(i);
                        finish();
                    } else {
                        Toast.makeText(LoginActivity.this, "try again", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(i);
            }
        });
    }
}
