package com.synnefx.ehrserver.xsd;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for REFERENCE_RANGE complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="REFERENCE_RANGE">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="meaning" type="{http://schemas.openehr.org/v1}DV_TEXT"/>
 *         &lt;element name="range" type="{http://schemas.openehr.org/v1}DV_INTERVAL"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "REFERENCE_RANGE", propOrder = {
        "meaning",
        "range"
})
public class REFERENCERANGE {

    @XmlElement(required = true)
    protected DVTEXT meaning;
    @XmlElement(required = true)
    protected DVINTERVAL range;

    /**
     * Gets the value of the meaning property.
     *
     * @return possible object is
     * {@link DVTEXT }
     */
    public DVTEXT getMeaning() {
        return meaning;
    }

    /**
     * Sets the value of the meaning property.
     *
     * @param value allowed object is
     *              {@link DVTEXT }
     */
    public void setMeaning(DVTEXT value) {
        this.meaning = value;
    }

    /**
     * Gets the value of the range property.
     *
     * @return possible object is
     * {@link DVINTERVAL }
     */
    public DVINTERVAL getRange() {
        return range;
    }

    /**
     * Sets the value of the range property.
     *
     * @param value allowed object is
     *              {@link DVINTERVAL }
     */
    public void setRange(DVINTERVAL value) {
        this.range = value;
    }

}
