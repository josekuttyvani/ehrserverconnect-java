package com.synnefx.ehrserver.xsd;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for IntervalOfInteger complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="IntervalOfInteger">
 *   &lt;complexContent>
 *     &lt;extension base="{http://schemas.openehr.org/v1}Interval">
 *       &lt;sequence>
 *         &lt;element name="lower" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="upper" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IntervalOfInteger", propOrder = {
        "lower",
        "upper"
})
public class IntervalOfInteger
        extends Interval {

    protected Integer lower;
    protected Integer upper;

    /**
     * Gets the value of the lower property.
     *
     * @return possible object is
     * {@link Integer }
     */
    public Integer getLower() {
        return lower;
    }

    /**
     * Sets the value of the lower property.
     *
     * @param value allowed object is
     *              {@link Integer }
     */
    public void setLower(Integer value) {
        this.lower = value;
    }

    /**
     * Gets the value of the upper property.
     *
     * @return possible object is
     * {@link Integer }
     */
    public Integer getUpper() {
        return upper;
    }

    /**
     * Sets the value of the upper property.
     *
     * @param value allowed object is
     *              {@link Integer }
     */
    public void setUpper(Integer value) {
        this.upper = value;
    }

}
