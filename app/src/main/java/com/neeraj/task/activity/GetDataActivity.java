package com.neeraj.task.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.neeraj.task.R;
import com.neeraj.task.api.RestApi;
import com.neeraj.task.model.CommentModel;


import java.util.HashMap;
import java.util.List;
import java.util.Map;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GetDataActivity extends AppCompatActivity{
Button fetch_data_btn;
Button clear_data_btn;
TextView textView;
RestApi restApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_data);
       textView=findViewById(R.id.data_txt);
       clear_data_btn=findViewById(R.id.clear_data_btn);
        fetch_data_btn=findViewById(R.id.fetch_data_btn);
     /*   restApi= RestApi.retrofit.create(RestApi.class);*/
        fetch_data_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // getData();
                getComments();
            }
        });

        clear_data_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(" ");
            }
        });
    }

    private void showPost(CommentModel commentModel) {
        textView.append(commentModel.getId()+"\n"+commentModel.getPostId()+"\n"+commentModel.getBody()+"\n"+commentModel.getEmail()+"");
    }

    /*private void getData() {
        Call<List<PostModel>> call=restApi.getPosts();
        call.enqueue(new Callback<List<PostModel>>() {
            @Override
            public void onResponse(Call<List<PostModel>> call, Response<List<PostModel>> response) {

                if(response.isSuccessful())
                {
                    for(PostModel postModel:response.body())
                    {
                        showPost(postModel);
                    }
                }

            }

            @Override
            public void onFailure(Call<List<PostModel>> call, Throwable t) {

            }
        });

    }*/

    private void getComments() {

        Map<String,String> parameters=new HashMap<>();

        parameters.put("postId","5");
        parameters.put("_sort","id");
        parameters.put("_order","desc");

       // Call<List<CommentModel>> call=restApi.getComments(parameters);
        Call<List<CommentModel>> call=restApi.getComments(2,"id","desc");
        //Call<List<CommentModel>> call=restApi.getComments(new Integer[]{2,4,6,8},null,null);

        //Call<List<CommentModel>> call=restApi.getComments("https://jsonplaceholder.typicode.com/posts/2/comments?postId=2");
        call.enqueue(new Callback<List<CommentModel>>() {
            @Override
            public void onResponse(Call<List<CommentModel>> call, Response<List<CommentModel>> response) {
                if(response.isSuccessful())
                {
                    for(CommentModel commentModel:response.body())
                    {
                        showPost(commentModel);
                    }
                }
            }

            @Override
            public void onFailure(Call<List<CommentModel>> call, Throwable t) {

            }
        });
    }


}