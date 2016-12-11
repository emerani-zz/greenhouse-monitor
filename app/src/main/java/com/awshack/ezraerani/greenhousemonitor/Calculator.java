package com.awshack.ezraerani.greenhousemonitor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ezraerani on 12/11/16.
 */

public class Calculator {

    private static Calculator instance = new Calculator();
    private List<Status> stati;
    private Status aggregate24HourStatus;
    private Status latest;

    private double aggHumidity, aggTemp, aggLight, aggUv;
    private double sumHumidity, sumTemp, sumLight, sumUv;

    private Calculator() {
        init();
    }

    public static Calculator getInstance() {
        return instance;
    }

    public void init() {
        stati = new ArrayList<>();
        aggregate24HourStatus = new Status();

        aggHumidity = 0;
        aggLight = 0;
        aggTemp = 0;
        aggUv = 0;

        sumHumidity = 0;
        sumLight = 0;
        sumTemp = 0;
        sumUv = 0;
    }

    public void addStatus(Status status) {
        sumLight += Double.parseDouble(status.getLightExposure());
        sumTemp += Double.parseDouble(status.getTemperature());
        sumUv += Double.parseDouble(status.getUvLevel());
        sumHumidity += Double.parseDouble(status.getHumidity());

        stati.add(status);
        int count = stati.size();
        latest = stati.get(count-1);

        aggregate24HourStatus.setHumidity(String.valueOf(sumHumidity / count));
        aggregate24HourStatus.setLightExposure(String.valueOf(sumLight / count));
        aggregate24HourStatus.setTemperature(String.valueOf(sumTemp / count));
        aggregate24HourStatus.setUvLevel(String.valueOf(sumUv / count));
    }

    public Status getAggregate24HourStatus() {
        return aggregate24HourStatus;
    }

    public List<Status> getStati() {
        return stati;
    }

    public Status getLatest() {
        return latest;
    }
}
