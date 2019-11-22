package com.synnefx.ehrserver.xsd;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for IntervalOfDate complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="IntervalOfDate">
 *   &lt;complexContent>
 *     &lt;extension base="{http://schemas.openehr.org/v1}Interval">
 *       &lt;sequence>
 *         &lt;element name="lower" type="{http://schemas.openehr.org/v1}Iso8601Date" minOccurs="0"/>
 *         &lt;element name="upper" type="{http://schemas.openehr.org/v1}Iso8601Date" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IntervalOfDate", propOrder = {
        "lower",
        "upper"
})
public class IntervalOfDate
        extends Interval {

    protected String lower;
    protected String upper;

    /**
     * Gets the value of the lower property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getLower() {
        return lower;
    }

    /**
     * Sets the value of the lower property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setLower(String value) {
        this.lower = value;
    }

    /**
     * Gets the value of the upper property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getUpper() {
        return upper;
    }

    /**
     * Sets the value of the upper property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setUpper(String value) {
        this.upper = value;
    }

}
