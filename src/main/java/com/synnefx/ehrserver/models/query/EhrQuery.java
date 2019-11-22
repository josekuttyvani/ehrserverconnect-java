package com.synnefx.ehrserver.models.query;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.synnefx.ehrserver.models.EhrEntity;

import java.util.List;

/**
 * @author Josekutty
 * 22-11-2019
 */
public class EhrQuery extends EhrEntity {

    @SerializedName("name")
    @Expose
    private Name name;
    @SerializedName("format")
    @Expose
    private String format;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("author")
    @Expose
    private Author author;
    @SerializedName("group")
    @Expose
    private String group;
    @SerializedName("projections")
    @Expose
    private List<Projection> projections = null;


    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public List<Projection> getProjections() {
        return projections;
    }

    public void setProjections(List<Projection> projections) {
        this.projections = projections;
    }
}
