package com.synnefx.ehrserver.xsd;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GENERIC_ID complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="GENERIC_ID">
 *   &lt;complexContent>
 *     &lt;extension base="{http://schemas.openehr.org/v1}OBJECT_ID">
 *       &lt;sequence>
 *         &lt;element name="scheme" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GENERIC_ID", propOrder = {
        "scheme"
})
public class GENERICID
        extends OBJECTID {

    @XmlElement(required = true)
    protected String scheme;

    /**
     * Gets the value of the scheme property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getScheme() {
        return scheme;
    }

    /**
     * Sets the value of the scheme property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setScheme(String value) {
        this.scheme = value;
    }

}
