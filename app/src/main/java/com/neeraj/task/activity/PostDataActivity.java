package com.neeraj.task.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.neeraj.task.R;
import com.neeraj.task.api.RestApi;
import com.neeraj.task.model.PostModel;

public class PostDataActivity extends AppCompatActivity {
Button post_data;
RestApi restApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_data);
        post_data=findViewById(R.id.post_data);
       /* restApi=RestApi.retrofit.create(RestApi.class);*/



        post_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createPost();
            }
        });
    }

    private void createPost() {
        PostModel postModel=new PostModel();
    }
}