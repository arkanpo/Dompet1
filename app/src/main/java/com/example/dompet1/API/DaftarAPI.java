package com.example.dompet1.API;

import com.example.dompet1.Model.BeritaList;
import com.example.dompet1.Model.DonasiList;
import com.example.dompet1.Model.LoginList;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface DaftarAPI {

    @GET("getalldonasi")
    Call<List<DonasiList>> viewDonasi();

    @GET("getallberita")
    Call<List<BeritaList>> viewBerita();

    @FormUrlEncoded
    @POST("searchberita")
    Call<BeritaList> search(@Field("judul") String search);

    @FormUrlEncoded
    @POST("login")
    Call<LoginList> login_user(
            @Field("no_hp") String nama,
            @Field("password") String kelas
    );

    @FormUrlEncoded
    @POST("register")
    Call<LoginList> login_user(

    );


}
