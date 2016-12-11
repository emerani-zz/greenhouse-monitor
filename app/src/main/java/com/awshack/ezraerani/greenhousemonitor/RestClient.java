package com.awshack.ezraerani.greenhousemonitor;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ezraerani on 3/28/16.
 */
public class RestClient {

    private RequestClient requestClient;

    public RestClient() {

        Gson gson = new GsonBuilder()
//                .registerTypeAdapterFactory(new ItemTypeAdapterFactory())
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://django-env.k2g3npjmbr.us-west-2.elasticbeanstalk.com")
                .addConverterFactory(GsonConverterFactory.create(gson))
//                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        requestClient = retrofit.create(RequestClient.class);
    }

    public RequestClient getRequestClient() {
        return requestClient;
    }

}
