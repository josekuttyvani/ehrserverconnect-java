package com.synnefx.ehrserver.xsd;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DV_BOOLEAN complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="DV_BOOLEAN">
 *   &lt;complexContent>
 *     &lt;extension base="{http://schemas.openehr.org/v1}DATA_VALUE">
 *       &lt;sequence>
 *         &lt;element name="value" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DV_BOOLEAN", propOrder = {
        "value"
})
public class DVBOOLEAN
        extends DATAVALUE {

    protected boolean value;

    /**
     * Gets the value of the value property.
     */
    public boolean isValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     */
    public void setValue(boolean value) {
        this.value = value;
    }

}
