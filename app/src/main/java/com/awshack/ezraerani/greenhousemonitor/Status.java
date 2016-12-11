
package com.awshack.ezraerani.greenhousemonitor;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Status {

    @SerializedName("humidity")
    @Expose
    private String humidity;
    @SerializedName("soil_moisture")
    @Expose
    private String soilMoisture;
    @SerializedName("uv_level")
    @Expose
    private String uvLevel;
    @SerializedName("light_exposure")
    @Expose
    private String lightExposure;
    @SerializedName("time")
    @Expose
    private String time;
    @SerializedName("temperature")
    @Expose
    private String temperature;

    /**
     * 
     * @return
     *     The humidity
     */
    public String getHumidity() {
        return humidity;
    }

    /**
     * 
     * @param humidity
     *     The humidity
     */
    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    /**
     * 
     * @return
     *     The soilMoisture
     */
    public String getSoilMoisture() {
        return soilMoisture;
    }

    /**
     * 
     * @param soilMoisture
     *     The soil_moisture
     */
    public void setSoilMoisture(String soilMoisture) {
        this.soilMoisture = soilMoisture;
    }

    /**
     * 
     * @return
     *     The uvLevel
     */
    public String getUvLevel() {
        return uvLevel;
    }

    /**
     * 
     * @param uvLevel
     *     The uv_level
     */
    public void setUvLevel(String uvLevel) {
        this.uvLevel = uvLevel;
    }

    /**
     * 
     * @return
     *     The lightExposure
     */
    public String getLightExposure() {
        return lightExposure;
    }

    /**
     * 
     * @param lightExposure
     *     The light_exposure
     */
    public void setLightExposure(String lightExposure) {
        this.lightExposure = lightExposure;
    }

    /**
     * 
     * @return
     *     The time
     */
    public String getTime() {
        return time;
    }

    /**
     * 
     * @param time
     *     The time
     */
    public void setTime(String time) {
        this.time = time;
    }

    /**
     * 
     * @return
     *     The temperature
     */
    public String getTemperature() {
        return temperature;
    }

    /**
     * 
     * @param temperature
     *     The temperature
     */
    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

}
