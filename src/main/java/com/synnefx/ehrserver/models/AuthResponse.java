package com.synnefx.ehrserver.models;

import com.google.gson.annotations.SerializedName;

/**
 * @author Josekutty
 * 20-11-2019
 */
public class AuthResponse {

    @SerializedName("token")
    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
