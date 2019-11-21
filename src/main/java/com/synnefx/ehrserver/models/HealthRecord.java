package com.synnefx.ehrserver.models;

import com.google.gson.annotations.SerializedName;

import java.time.Instant;
import java.util.Date;

/**
 * @author Josekutty
 * 20-11-2019
 */
public class HealthRecord extends EhrEntity {

    @SerializedName("dateCreated")
    private Date dateCreated;

    private String subjectUid;

    private String systemId;

    private String organizationUid;

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getSubjectUid() {
        return subjectUid;
    }

    public void setSubjectUid(String subjectUid) {
        this.subjectUid = subjectUid;
    }

    public String getSystemId() {
        return systemId;
    }

    public void setSystemId(String systemId) {
        this.systemId = systemId;
    }

    public String getOrganizationUid() {
        return organizationUid;
    }

    public void setOrganizationUid(String organizationUid) {
        this.organizationUid = organizationUid;
    }
}
