package com.synnefx.ehrserver.models;

/**
 * @author Josekutty
 * 22-11-2019
 */
public class EhrPageRequest {

    private Integer maxRecords = 20;

    private Integer offset = 0;

    public EhrPageRequest() {

    }

    public EhrPageRequest(Integer maxRecords, Integer offset) {
        this.maxRecords = maxRecords;
        this.offset = offset;
    }

    public EhrPageRequest(Integer maxRecords) {
        this.maxRecords = maxRecords;
    }

    public Integer getMaxRecords() {
        return maxRecords;
    }

    public void setMaxRecords(Integer maxRecords) {
        this.maxRecords = maxRecords;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }
}
