package com.synnefx.ehrserver.xsd;

import javax.xml.bind.annotation.*;


/**
 * <p>Java class for DV_QUANTIFIED complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="DV_QUANTIFIED">
 *   &lt;complexContent>
 *     &lt;extension base="{http://schemas.openehr.org/v1}DV_ORDERED">
 *       &lt;sequence>
 *         &lt;element name="magnitude_status" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DV_QUANTIFIED", propOrder = {
        "magnitudeStatus"
})
@XmlSeeAlso({
        DVAMOUNT.class,
        DVTEMPORAL.class
})
public abstract class DVQUANTIFIED
        extends DVORDERED {

    @XmlElement(name = "magnitude_status")
    protected String magnitudeStatus;

    /**
     * Gets the value of the magnitudeStatus property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getMagnitudeStatus() {
        return magnitudeStatus;
    }

    /**
     * Sets the value of the magnitudeStatus property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setMagnitudeStatus(String value) {
        this.magnitudeStatus = value;
    }

}
