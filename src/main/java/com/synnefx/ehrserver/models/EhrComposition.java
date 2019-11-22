package com.synnefx.ehrserver.models;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * @author Josekutty
 * 22-11-2019
 */
public class EhrComposition extends EhrEntity {


    @SerializedName("category")
    @Expose
    private String category;
    @SerializedName("startTime")
    @Expose
    private String startTime;
    @SerializedName("subjectId")
    @Expose
    private String subjectId;
    @SerializedName("ehrUid")
    @Expose
    private String ehrUid;
    @SerializedName("templateId")
    @Expose
    private String templateId;
    @SerializedName("archetypeId")
    @Expose
    private String archetypeId;
    @SerializedName("lastVersion")
    @Expose
    private Boolean lastVersion;
    @SerializedName("organizationUid")
    @Expose
    private String organizationUid;
    @SerializedName("parent")
    @Expose
    private String parent;


    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

    public String getEhrUid() {
        return ehrUid;
    }

    public void setEhrUid(String ehrUid) {
        this.ehrUid = ehrUid;
    }

    public String getTemplateId() {
        return templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

    public String getArchetypeId() {
        return archetypeId;
    }

    public void setArchetypeId(String archetypeId) {
        this.archetypeId = archetypeId;
    }

    public Boolean getLastVersion() {
        return lastVersion;
    }

    public void setLastVersion(Boolean lastVersion) {
        this.lastVersion = lastVersion;
    }

    public String getOrganizationUid() {
        return organizationUid;
    }

    public void setOrganizationUid(String organizationUid) {
        this.organizationUid = organizationUid;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }
}
