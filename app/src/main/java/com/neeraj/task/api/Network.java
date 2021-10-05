package com.neeraj.task.api;



import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;

import retrofit2.converter.jackson.JacksonConverterFactory;

public class Network {
  
    String BASE_URL="https://simplifiedcoding.net/demos/";

    public static Retrofit getRetrofit()
    {


        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);


        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(120, TimeUnit.SECONDS)
                .writeTimeout(120, TimeUnit.SECONDS)
                .readTimeout(120, TimeUnit.SECONDS)
                .addInterceptor(interceptor).build();


        Retrofit retrofit=new Retrofit.Builder().baseUrl(FAKE_JSON_BASE_URL)
                .addConverterFactory(JacksonConverterFactory.create()).client(client)
                .build();

    return retrofit;
    }

}
