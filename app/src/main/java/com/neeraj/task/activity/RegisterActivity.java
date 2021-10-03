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
import com.neeraj.task.dao.model.UserModel;
import com.neeraj.task.dao.UserDao;

public class RegisterActivity extends AppCompatActivity {
    Button register;
    TextView login;
    EditText email,password,mobile_no;
    UserDao userDao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        register=findViewById(R.id.register);
        login=findViewById(R.id.login);
        email=findViewById(R.id.email);
        password=findViewById(R.id.password);
        mobile_no=findViewById(R.id.mobile_no);
        userDao=new UserDao(RegisterActivity.this);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user_email = email.getText().toString();
                String user_pass = password.getText().toString();
                String mobile =mobile_no.getText().toString();
                UserModel u = new UserModel(user_email, user_pass, mobile);
                long result = userDao.insert_Record(u);
                if (TextUtils.isEmpty(user_email)) {
                    email.setError("Please add password id");
                }

                else if(TextUtils.isEmpty(user_pass))
                {
                    password.setError("Please fill password");
                }

                else if(TextUtils.isEmpty(mobile))
                {
                    mobile_no.setError("Please enter the mobile no");
                }


                else {
                    if (result > 0) {
                        Toast.makeText(RegisterActivity.this, "Data saved", Toast.LENGTH_SHORT).show();
                        Intent i=new Intent(RegisterActivity.this, LoginActivity.class);
                        startActivity(i);
                        finish();
                    } else {
                        Toast.makeText(RegisterActivity.this, "Data not saved", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(i);
                finish();
            }
        });
    }
}
