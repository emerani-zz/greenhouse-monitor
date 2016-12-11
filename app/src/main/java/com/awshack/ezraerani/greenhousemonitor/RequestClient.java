package com.awshack.ezraerani.greenhousemonitor;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by ezraerani on 3/28/16.
 */
public interface RequestClient {

    @GET("history/")
    Observable<List<Status>> getObservableHistory();

    @GET("history/")
    Call<StatusResponse> getHistory();



    @GET("latest/")
    Call<Status> getLatest();

}
