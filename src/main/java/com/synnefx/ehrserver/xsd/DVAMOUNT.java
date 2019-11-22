package com.synnefx.ehrserver.xsd;

import javax.xml.bind.annotation.*;


/**
 * <p>Java class for DV_AMOUNT complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="DV_AMOUNT">
 *   &lt;complexContent>
 *     &lt;extension base="{http://schemas.openehr.org/v1}DV_QUANTIFIED">
 *       &lt;sequence>
 *         &lt;element name="accuracy" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
 *         &lt;element name="accuracy_is_percent" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DV_AMOUNT", propOrder = {
        "accuracy",
        "accuracyIsPercent"
})
@XmlSeeAlso({
        DVCOUNT.class,
        DVDURATION.class,
        DVPROPORTION.class,
        DVQUANTITY.class
})
public class DVAMOUNT
        extends DVQUANTIFIED {

    @XmlElement(defaultValue = "-1.0")
    protected Float accuracy;
    @XmlElement(name = "accuracy_is_percent")
    protected Boolean accuracyIsPercent;

    /**
     * Gets the value of the accuracy property.
     *
     * @return possible object is
     * {@link Float }
     */
    public Float getAccuracy() {
        return accuracy;
    }

    /**
     * Sets the value of the accuracy property.
     *
     * @param value allowed object is
     *              {@link Float }
     */
    public void setAccuracy(Float value) {
        this.accuracy = value;
    }

    /**
     * Gets the value of the accuracyIsPercent property.
     *
     * @return possible object is
     * {@link Boolean }
     */
    public Boolean isAccuracyIsPercent() {
        return accuracyIsPercent;
    }

    /**
     * Sets the value of the accuracyIsPercent property.
     *
     * @param value allowed object is
     *              {@link Boolean }
     */
    public void setAccuracyIsPercent(Boolean value) {
        this.accuracyIsPercent = value;
    }

}
