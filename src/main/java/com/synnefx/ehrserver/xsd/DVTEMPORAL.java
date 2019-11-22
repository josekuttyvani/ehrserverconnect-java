package com.synnefx.ehrserver.xsd;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DV_TEMPORAL complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="DV_TEMPORAL">
 *   &lt;complexContent>
 *     &lt;extension base="{http://schemas.openehr.org/v1}DV_QUANTIFIED">
 *       &lt;sequence>
 *         &lt;element name="accuracy" type="{http://schemas.openehr.org/v1}DV_DURATION" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DV_TEMPORAL", propOrder = {
        "accuracy"
})
@XmlSeeAlso({
        DVTIME.class,
        DVDATETIME.class,
        DVDATE.class
})
public class DVTEMPORAL
        extends DVQUANTIFIED {

    protected DVDURATION accuracy;

    /**
     * Gets the value of the accuracy property.
     *
     * @return possible object is
     * {@link DVDURATION }
     */
    public DVDURATION getAccuracy() {
        return accuracy;
    }

    /**
     * Sets the value of the accuracy property.
     *
     * @param value allowed object is
     *              {@link DVDURATION }
     */
    public void setAccuracy(DVDURATION value) {
        this.accuracy = value;
    }

}
