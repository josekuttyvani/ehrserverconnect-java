package com.synnefx.ehrserver.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * @author Josekutty
 * 20-11-2019
 */
public class EhrListResponse extends EhrPageResult {

    @SerializedName("ehrs")
    private List<EhrHealthRecord> healthRecords;

    public List<EhrHealthRecord> getHealthRecords() {
        return healthRecords;
    }

    public void setHealthRecords(List<EhrHealthRecord> healthRecords) {
        this.healthRecords = healthRecords;
    }
}
