package com.neeraj.task.model;

/*import com.google.gson.annotations.SerializedName;*/

public class PostModel {
    public int userId;
    public int id;
    public String title;

 /*   @SerializedName("body")*/
    public String body;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
