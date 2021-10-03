# Retrofit_Complete
Retrofit is the one of the Best networking libarary in Android developed by Square.
It is basically annotation based libarary for java and android internally used OkHttp client for network response.
Retrofit needs any json factory provider to serialize and de-serialize object 
some common factory providers are:
GSON-->Developed by google
JACKSON

Note:On Android, callbacks will be executed on the main thread but Retrofit request will work on background thread

some common annotations mentioned below:

<B>HTTP Requests<B>
-----------------------------
@GET-->For Get HTTP Request(For fetching the data from the server).<br>
@POST-->For Post HTTP Request.(For Creating a new Resource in the server)<br>
@PATCH-->For updating the Resource.(It will update only selected resources)<br>
@PUT-->For updating the Resource(It will update whole resources).<br>
@DELETE-->For Delete the Resource(It will delete selected resources).<br>


<B>Headers<B> 
------------------
Headers are used to specifiy extra information to the server for exmple token key or MIME<br>
@Headers:used to pass the header in HTTP request<br>
@Header:used when you pass the header on body<br>
@HeaderMap:used when you pass the header on body with key,value pair.<br>


<B>Some More<B>
----------------------
@formUrlEncoded-->For sending the data to url 

@MultiPart-->For sending files to the server.

<B>GSON Annotations<B>
--------------------------
@SerializedName-->When json field and pojo class variable is diffrent<br>
@Expose-->To prevent a java class variable to serliazation/deserialization.<br>
@Since-->for versioning of your Json classes.(Field will only be considered for Serialization/deserialization starting from certain version.<b>Before that version<b>, it will ignored.)<br>
@Until-->for versioning of your Json classes.( field will only be considered for Serialization/deserialization until certain version. <b>After that version<b>, it will ignored.)<br>
@JsonAdapter--> specifying the custom adapter we created above
