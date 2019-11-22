package com.synnefx.ehrserver.models.query;

import com.synnefx.ehrserver.utils.Utils;
import org.apache.commons.lang.StringUtils;

import java.beans.Transient;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Josekutty
 * 22-11-2019
 */
public class EhrQueryParameter {

    private String format = "json";
    //UID of the EHR we want to query. If no ehrUid is specified, the result will contain results
    //for multiple EHRs.
    private String ehrUid;
    //UID of the organization that owns the EHRs we want to query.
    private String organizationUid;
    //this parameter specifies if the composition query should return data if the value is
    //“true”
    private boolean retrieveData;
    //overrides the grouping of the datavalue query, valid values are: “none”, “composition” or
    //“path”.
    private ResultGrouping grouping = null;
    //fromDate: filter for the results, to get results after this date. Expected format is: yyyyMMdd.
    private LocalDate fromDate;
    //toDate: filter for the results, to get results before this date. Expected format is: yyyyMMdd.
    private LocalDate toDate;
    // filter results by the UID of the composer (author)
    private String composerUid;
    //filter results by the name of the composer (author), can be a partial name.
    private String composerName;

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getEhrUid() {
        return ehrUid;
    }

    public void setEhrUid(String ehrUid) {
        this.ehrUid = ehrUid;
    }

    public String getOrganizationUid() {
        return organizationUid;
    }

    public void setOrganizationUid(String organizationUid) {
        this.organizationUid = organizationUid;
    }

    public boolean isRetrieveData() {
        return retrieveData;
    }

    public void setRetrieveData(boolean retrieveData) {
        this.retrieveData = retrieveData;
    }

    public ResultGrouping getGrouping() {
        return grouping;
    }

    public void setGrouping(ResultGrouping grouping) {
        this.grouping = grouping;
    }

    public LocalDate getFromDate() {
        return fromDate;
    }

    public void setFromDate(LocalDate fromDate) {
        this.fromDate = fromDate;
    }

    public LocalDate getToDate() {
        return toDate;
    }

    public void setToDate(LocalDate toDate) {
        this.toDate = toDate;
    }

    public String getComposerUid() {
        return composerUid;
    }

    public void setComposerUid(String composerUid) {
        this.composerUid = composerUid;
    }

    public String getComposerName() {
        return composerName;
    }

    public void setComposerName(String composerName) {
        this.composerName = composerName;
    }

    @Transient
    public Map<String, Object> getRequestParameters() {
        Map<String, Object> params = new HashMap<>();
        params.put("format", this.format);
        if (StringUtils.isNotEmpty(this.ehrUid)) {
            params.put("ehrUid", this.ehrUid);
        }
        if (StringUtils.isNotEmpty(this.organizationUid)) {
            params.put("organizationUid", this.organizationUid);
        }
        if (this.retrieveData) {
            params.put("retrieveData", "true");
        } else {
            params.put("retrieveData", "false");
        }

        if (null != this.grouping && !ResultGrouping.NONE.equals(this.grouping)) {
            //Group none is invalid, should be empty, composition or path
            //EHRSERVER::API::RESPONSE_CODES::488
            params.put("group", this.grouping.getName());
        }

        if (null != this.fromDate) {
            params.put("fromDate", Utils.dateToString(this.fromDate, "yyyyMMdd"));
        }
        if (null != this.toDate) {
            params.put("toDate", Utils.dateToString(this.toDate, "yyyyMMdd"));
        }

        if (StringUtils.isNotEmpty(this.composerUid)) {
            params.put("composerUid", this.composerUid);
        }

        if (StringUtils.isNotEmpty(this.composerName)) {
            params.put("composerName", this.composerName);
        }
        return params;
    }

    public enum ResultGrouping {

        NONE("none"), COMPOSITION("composition"), PATH("path");

        private final String name;

        ResultGrouping(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }
}
