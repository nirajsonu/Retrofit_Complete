package com.neeraj.task.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.neeraj.task.R;
import com.neeraj.task.adapter.HeroAdapter;
import com.neeraj.task.api.Network;
import com.neeraj.task.api.RestApi;
import com.neeraj.task.model.HeroModel;
import com.neeraj.task.model.RootModel;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
/*import retrofit2.converter.gson.GsonConverterFactory;*/

public class ShowActivity extends AppCompatActivity {
RecyclerView recycleview;
RecyclerView.LayoutManager layoutManager;
HeroAdapter adapter;
ProgressDialog progressDialog;
RestApi network;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);



        //View Intilization
        recycleview=findViewById(R.id.recycleview);
        progressDialog=new ProgressDialog(ShowActivity.this);

        progressDialog.setTitle(R.string.please_wait);



        //for setting the Recycleview to adapter
        recycleview.setHasFixedSize(true);
        layoutManager=new LinearLayoutManager(this);
        recycleview.setLayoutManager(layoutManager);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                getDataFromServer();
            }
        },2000);

    }

    private void getDataFromServer() {

     /*   network=Network.getRetrofit().create(RestApi.class);

        //for Progress Dialog
       *//* progressDialog.show();
        progressDialog.setCancelable(false);
        progressDialog.show();*//*

        //For Retrofit Callbacks
     *//*   Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(RestApi.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RestApi api=retrofit.create(RestApi.class);*//*
      *//*  Call<List<HeroModel>> call=api.getheroes();
        call.enqueue(new Callback<List<HeroModel>>() {
            @Override
            public void onResponse(Call<List<HeroModel>> call, Response<List<HeroModel>> response) {
                adapter=new HeroAdapter(getBaseContext(),response.body());
                adapter.notifyDataSetChanged();
                recycleview.setAdapter(adapter);
                progressDialog.dismiss();
            }

            @Override
            public void onFailure(Call<List<HeroModel>> call, Throwable t) {
                Toast.makeText(getApplicationContext(),t.getMessage(),Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();
            }
        });*//*

        Call<List<RootModel>> call=network.getData();
        call.enqueue(new Callback<List<RootModel>>() {
            @Override
            public void onResponse(Call<List<RootModel>> call, Response<List<RootModel>> response) {
                Toast.makeText(getApplicationContext(), ""+response.body(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<List<RootModel>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "error", Toast.LENGTH_SHORT).show();
            }
        });*/




    }
}
