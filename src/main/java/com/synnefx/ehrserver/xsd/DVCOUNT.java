package com.synnefx.ehrserver.xsd;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DV_COUNT complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="DV_COUNT">
 *   &lt;complexContent>
 *     &lt;extension base="{http://schemas.openehr.org/v1}DV_AMOUNT">
 *       &lt;sequence>
 *         &lt;element name="magnitude" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DV_COUNT", propOrder = {
        "magnitude"
})
public class DVCOUNT
        extends DVAMOUNT {

    protected long magnitude;

    /**
     * Gets the value of the magnitude property.
     */
    public long getMagnitude() {
        return magnitude;
    }

    /**
     * Sets the value of the magnitude property.
     */
    public void setMagnitude(long value) {
        this.magnitude = value;
    }

}
