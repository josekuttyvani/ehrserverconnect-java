package com.synnefx.ehrserver.models.query;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * @author Josekutty
 * 22-11-2019
 */
public class Projection {

    @SerializedName("archetypeId")
    @Expose
    private String archetypeId;
    @SerializedName("path")
    @Expose
    private String path;
    @SerializedName("rmTypeName")
    @Expose
    private String rmTypeName;

    public String getArchetypeId() {
        return archetypeId;
    }

    public void setArchetypeId(String archetypeId) {
        this.archetypeId = archetypeId;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getRmTypeName() {
        return rmTypeName;
    }

    public void setRmTypeName(String rmTypeName) {
        this.rmTypeName = rmTypeName;
    }
}
