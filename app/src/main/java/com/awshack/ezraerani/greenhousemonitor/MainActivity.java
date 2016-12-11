package com.awshack.ezraerani.greenhousemonitor;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import rx.Subscription;

public class MainActivity extends AppCompatActivity {

    RequestClient requestClient;
    Calculator calculator;
    Subscription subscription;
    List<Status> stati;
    Status aggregate;
    Status latestStatus;

    @BindView(R.id.activity_main)
    LinearLayout layout;

    @BindView(R.id.currentStatusTV)
    TextView currentStatus;

    @BindView(R.id.aggStatusTV)
    TextView aggregateStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        requestClient = new RestClient().getRequestClient();
        calculator = Calculator.getInstance();
        stati = calculator.getStati();
        aggregate = calculator.getAggregate24HourStatus();

        layout.setBackground(getDrawable(R.drawable.forest2));

//        rx.Observable<List<Status>> statusObservable = requestClient.getHistory();
//        subscription = statusObservable.subscribeOn(Schedulers.io())
//                .flatMap(new Func1<List<Status>, Observable<Status>>() {
//                    @Override
//                    public Observable<Status> call(List<Status> statuses) {
//                        return Observable.from(statuses);
//                    }
//                })
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Subscriber<Status>() {
//                    @Override
//                    public void onCompleted() {
//                        Log.d("onCompleted", "called");
//                        displayData();
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        Log.d("onError", e.getMessage() + " | " + e.toString() );
//
//                    }
//
//                    @Override
//                    public void onNext(Status status) {
//                        calculator.addStatus(status);
//                        Log.d("onNext", status.getHumidity());
//                    }
//                });

//        Call<Status> latestStatus = requestClient.getLatest();
//        latestStatus.enqueue(new Callback<Status>() {
//            @Override
//            public void onResponse(Call<Status> call, Response<Status> response) {
//                initLatest(response.body());
//                Log.d("onResponse", response.message());
//            }
//
//            @Override
//            public void onFailure(Call<Status> call, Throwable t) {
//                Log.d("onFailure", t.getMessage());
//
//            }
//        });

        Call<StatusResponse> resp = requestClient.getHistory();
        resp.enqueue(new Callback<StatusResponse>() {
            @Override
            public void onResponse(Call<StatusResponse> call, Response<StatusResponse> response) {
                if (response.isSuccessful()) {
                    Log.d("response", "isSuccessful");
                    for (Status s : response.body().getStati()) {
                        calculator.addStatus(s);
                    }

                    displayData();
                } else {
                    Log.d("else", response.errorBody().toString());
                }
            }

            @Override
            public void onFailure(Call<StatusResponse> call, Throwable t) {
                Log.d("onFailure", t.getMessage());
            }
        });
    }

    public void displayData() {
        aggregateStatus.setText(formatStatus(aggregate));
        currentStatus.setText(formatStatus(calculator.getLatest()));
        Log.d("displayData", "called");
    }

//    public void initLatest(Status status) {
//        this.latestStatus = status;
//        Log.d("initLatest", "called");
//    }

    public String formatStatus(Status status) {
        return new StringBuilder()
                .append("Humidity: " + status.getHumidity() + "\n")
                .append("Temperature: " + status.getTemperature() + "\n")
                .append("UV Level: " + status.getUvLevel() + "\n")
                .append("Light Exposure: " + status.getLightExposure() + "\n")
                .append("Soil Moisture: " + status.getSoilMoisture())
                .toString();
    }
}
