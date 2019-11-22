package com.synnefx.ehrserver.models.query;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.synnefx.ehrserver.models.EhrOrganization;

import java.util.List;

/**
 * @author Josekutty
 * 22-11-2019
 */
public class Author {


    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("organizations")
    @Expose
    private List<EhrOrganization> organizations = null;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<EhrOrganization> getOrganizations() {
        return organizations;
    }

    public void setOrganizations(List<EhrOrganization> organizations) {
        this.organizations = organizations;
    }
}
