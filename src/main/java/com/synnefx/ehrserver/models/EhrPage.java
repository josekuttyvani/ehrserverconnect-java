package com.synnefx.ehrserver.models;

/**
 * @author Josekutty
 * 20-11-2019
 */
public class EhrPage {

    private Long max;
    private Long offset;
    private Long nextOffset;
    private Long prevOffset;

    public Long getMax() {
        return max;
    }

    public void setMax(Long max) {
        this.max = max;
    }

    public Long getOffset() {
        return offset;
    }

    public void setOffset(Long offset) {
        this.offset = offset;
    }

    public Long getNextOffset() {
        return nextOffset;
    }

    public void setNextOffset(Long nextOffset) {
        this.nextOffset = nextOffset;
    }

    public Long getPrevOffset() {
        return prevOffset;
    }

    public void setPrevOffset(Long prevOffset) {
        this.prevOffset = prevOffset;
    }
}
