package com.example.dompet1.API;

public class UtilsAPI {

    public static final String BASE_ROOT_URL = "https://donasi.litebig.co.id/sedekahdigital/index.php/";

    public static DaftarAPI getdaftarAPI() {
        return RetrofitClient.getClient(BASE_ROOT_URL).create(DaftarAPI.class);
    }



}
