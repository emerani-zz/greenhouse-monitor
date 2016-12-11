
package com.awshack.ezraerani.greenhousemonitor;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class StatusResponse {

    @SerializedName("count")
    @Expose
    private int count;
    @SerializedName("stati")
    @Expose
    private List<Status> stati = null;

    /**
     * 
     * @return
     *     The count
     */
    public int getCount() {
        return count;
    }

    /**
     * 
     * @param count
     *     The count
     */
    public void setCount(int count) {
        this.count = count;
    }

    /**
     * 
     * @return
     *     The stati
     */
    public List<Status> getStati() {
        return stati;
    }

    /**
     * 
     * @param stati
     *     The stati
     */
    public void setStati(List<Status> stati) {
        this.stati = stati;
    }

}
