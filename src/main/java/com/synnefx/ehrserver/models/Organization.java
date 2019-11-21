package com.synnefx.ehrserver.models;

/**
 * @author Josekutty
 * 20-11-2019
 */
public class Organization extends EhrEntity {

    private String name;

    private String number;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
