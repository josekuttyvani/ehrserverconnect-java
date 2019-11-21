package com.synnefx.ehrserver.models;

import javax.xml.bind.annotation.*;

/**
 * @author Josekutty
 * 20-11-2019
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "versionsType", namespace = "http://schemas.openehr.org/v1", propOrder = {
        "type", "message", "code"
})
@XmlRootElement( name = "result" )
public class ErrorResponse {

    @XmlElement
    private String type;

    @XmlElement
    private String message;

    @XmlElement
    private String code;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
