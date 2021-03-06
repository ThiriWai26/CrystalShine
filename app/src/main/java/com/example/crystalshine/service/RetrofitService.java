package com.example.crystalshine.service;

import com.example.crystalshine.api.ApiEnd;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitService {

    public static final String BASE_URL="http://172.104.51.119";
    private static ApiEnd apiEnd;
    private static RetrofitService retrofitService;

    private RetrofitService(){ }

    public static RetrofitService getInstance(){
        if(retrofitService == null){
            retrofitService = new RetrofitService();
        }


        return retrofitService;
    }

    public static ApiEnd getApiEnd(){


        Gson gson = new GsonBuilder().setLenient().create();
        Retrofit service = new Retrofit.Builder().baseUrl(BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        if(apiEnd == null) {

            apiEnd = service.create(ApiEnd.class);
        }

        return apiEnd;
    }
}
