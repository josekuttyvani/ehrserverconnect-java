package com.synnefx.ehrserver.xsd;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DV_QUANTITY complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="DV_QUANTITY">
 *   &lt;complexContent>
 *     &lt;extension base="{http://schemas.openehr.org/v1}DV_AMOUNT">
 *       &lt;sequence>
 *         &lt;element name="magnitude" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="units" type="{http://schemas.openehr.org/v1}NotEmptyString"/>
 *         &lt;element name="precision" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DV_QUANTITY", propOrder = {
        "magnitude",
        "units",
        "precision"
})
public class DVQUANTITY
        extends DVAMOUNT {

    protected double magnitude;
    @XmlElement(required = true)
    protected String units;
    @XmlElement(defaultValue = "-1")
    protected Integer precision;

    /**
     * Gets the value of the magnitude property.
     */
    public double getMagnitude() {
        return magnitude;
    }

    /**
     * Sets the value of the magnitude property.
     */
    public void setMagnitude(double value) {
        this.magnitude = value;
    }

    /**
     * Gets the value of the units property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getUnits() {
        return units;
    }

    /**
     * Sets the value of the units property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setUnits(String value) {
        this.units = value;
    }

    /**
     * Gets the value of the precision property.
     *
     * @return possible object is
     * {@link Integer }
     */
    public Integer getPrecision() {
        return precision;
    }

    /**
     * Sets the value of the precision property.
     *
     * @param value allowed object is
     *              {@link Integer }
     */
    public void setPrecision(Integer value) {
        this.precision = value;
    }

}
