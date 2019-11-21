package com.synnefx.ehrserver.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * @author Josekutty
 * 20-11-2019
 */
public class EhrListResponse extends EhrPageResult {

    @SerializedName("ehrs")
    private List<HealthRecord> healthRecords;

    public List<HealthRecord> getHealthRecords() {
        return healthRecords;
    }

    public void setHealthRecords(List<HealthRecord> healthRecords) {
        this.healthRecords = healthRecords;
    }
}
