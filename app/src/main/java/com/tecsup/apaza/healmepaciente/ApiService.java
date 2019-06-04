package com.tecsup.apaza.healmepaciente;

//import com.tecsup.apaza.healmepaciente.Class.Doctor;
import com.tecsup.apaza.healmepaciente.Class.ResponseMessage;
import com.tecsup.apaza.healmepaciente.Class.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiService {

    String API_BASE_URL = "http://3.81.8.234";

    @GET("api/user")
    Call<List<User>> getUsers();

    @FormUrlEncoded
    @POST("/api/user")
    Call<ResponseMessage> createDoctor(@Field("email") String email,
                                         @Field("password") String password,
                                         @Field("name") String name,
                                         @Field("lastname") String lastname,
                                         @Field("user_type") String user_type,
                                         @Field("document_type") String document_type,
                                         @Field("identity_document") String identity_document);

    @FormUrlEncoded
    @POST("/api/login")
    Call<ResponseMessage> loginUser(@Field("email") String email,
                                       @Field("password") String password);



}
