package com.neeraj.task.api;


import com.neeraj.task.model.CommentModel;
import com.neeraj.task.model.HeroModel;
import com.neeraj.task.model.PostModel;
import com.neeraj.task.model.RootModel;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;


import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

public interface RestApi {

   // String FAKE_JSON_BASE_URL="https://jsonplaceholder.typicode.com/";
    String FEED_URL="posts";




    //All types of get Requests

    //direct base url+string value
    @GET("marvel")
    Call<List<HeroModel>> getheroes();



    @Headers("")
    @GET("profile")
    Call<List<RootModel>> getData();




    //string variable
    @GET(FEED_URL)
    Call<List<PostModel>> getPosts();



    //Static url request
/*    @GET("posts/1/comments")
    Call<List<CommentModel>> getComments();*/



    //Dynamic url request
/*    @GET("posts/{id}/comments")
    Call<List<CommentModel>> getComments(@Path("id") int userId);*/


//if we sent the data to url with ?and json keyname
    //comments/?postId=2?sortBy="abc"?orderby="asc"
    @GET("comments")
    Call<List<CommentModel>> getComments(@Query("postId") int postid,@Query("_sort") String sortBy,@Query("_order") String orderBy);


//key value pair
    @GET("comments")
    Call<List<CommentModel>> getComments(@QueryMap Map<String, String> pramas);


    //Directly url pass
    @GET()
    Call<List<CommentModel>> getComments(@Url String url);


    @GET("comments")
    Call<List<CommentModel>> getComments(@Query("postId") Integer[] ids,
                                         @Query("_sort")String sortBy,
                                         @Query("_order")String orderBy
                                         );

    //All Types of Post Requests.


    //json type ka data ho
   @POST("posts")
    Call<PostModel> createPost(@Body PostModel postModel);


   //website form url data
    @FormUrlEncoded
    @POST("posts")
    Call<PostModel> createPost
            (@Field("userId") int userId,
             @Field("title") String title,
             @Field("body") String text);



    //key value pair me data send
    @FormUrlEncoded
    @POST("posts")
    Call<PostModel> createPost(@FieldMap Map<String,String> postMap);

    //file,binary data sent karne ke liye,part by part data sent.


}
