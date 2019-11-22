package com.synnefx.ehrserver.xsd;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for IntervalOfReal complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="IntervalOfReal">
 *   &lt;complexContent>
 *     &lt;extension base="{http://schemas.openehr.org/v1}Interval">
 *       &lt;sequence>
 *         &lt;element name="lower" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
 *         &lt;element name="upper" type="{http://www.w3.org/2001/XMLSchema}float" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IntervalOfReal", propOrder = {
        "lower",
        "upper"
})
public class IntervalOfReal
        extends Interval {

    protected Float lower;
    protected Float upper;

    /**
     * Gets the value of the lower property.
     *
     * @return possible object is
     * {@link Float }
     */
    public Float getLower() {
        return lower;
    }

    /**
     * Sets the value of the lower property.
     *
     * @param value allowed object is
     *              {@link Float }
     */
    public void setLower(Float value) {
        this.lower = value;
    }

    /**
     * Gets the value of the upper property.
     *
     * @return possible object is
     * {@link Float }
     */
    public Float getUpper() {
        return upper;
    }

    /**
     * Sets the value of the upper property.
     *
     * @param value allowed object is
     *              {@link Float }
     */
    public void setUpper(Float value) {
        this.upper = value;
    }

}
