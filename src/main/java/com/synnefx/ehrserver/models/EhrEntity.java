package com.synnefx.ehrserver.models;

import com.google.gson.annotations.SerializedName;

/**
 * @author Josekutty
 * 20-11-2019
 */
public class EhrEntity {

    @SerializedName("uid")
    private String uid;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }
}
