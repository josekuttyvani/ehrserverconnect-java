package com.synnefx.ehrserver.models;

import com.google.gson.annotations.SerializedName;

/**
 * @author Josekutty
 * 20-11-2019
 */
public class Template extends EhrEntity {

    private String templateId;
    private String concept;
    private String language;
    private String externalUid;
    private String archetypeId;
    private String archetypeConcept;
    private String organizationUid;
    @SerializedName("setID")
    private String setId;
    private Integer versionNumber;

    public String getTemplateId() {
        return templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

    public String getConcept() {
        return concept;
    }

    public void setConcept(String concept) {
        this.concept = concept;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getExternalUid() {
        return externalUid;
    }

    public void setExternalUid(String externalUid) {
        this.externalUid = externalUid;
    }

    public String getArchetypeId() {
        return archetypeId;
    }

    public void setArchetypeId(String archetypeId) {
        this.archetypeId = archetypeId;
    }

    public String getArchetypeConcept() {
        return archetypeConcept;
    }

    public void setArchetypeConcept(String archetypeConcept) {
        this.archetypeConcept = archetypeConcept;
    }

    public String getOrganizationUid() {
        return organizationUid;
    }

    public void setOrganizationUid(String organizationUid) {
        this.organizationUid = organizationUid;
    }

    public String getSetId() {
        return setId;
    }

    public void setSetId(String setId) {
        this.setId = setId;
    }

    public Integer getVersionNumber() {
        return versionNumber;
    }

    public void setVersionNumber(Integer versionNumber) {
        this.versionNumber = versionNumber;
    }
}
