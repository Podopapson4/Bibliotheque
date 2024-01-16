package com.podosoft.bibliotheque.MyHelpers;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.concurrent.TimeUnit;

public class GeneralHelper {

    //  URLs
    public static final String urlGoogleBooksApi = "https://www.googleapis.com/books/v1/";

    //  retrofit
    public static Retrofit retrofitGoogleBooksApi(){
        OkHttpClient okHttpClient = new OkHttpClient();
        OkHttpClient clientWith1mTimeout = okHttpClient.newBuilder().readTimeout(1, TimeUnit.MINUTES).build();

        return new Retrofit.Builder()
                .baseUrl(urlGoogleBooksApi)
                .addConverterFactory(GsonConverterFactory.create())
                .client(clientWith1mTimeout)
                .build();
    }

















}
