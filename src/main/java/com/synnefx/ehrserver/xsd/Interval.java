package com.synnefx.ehrserver.xsd;

import javax.xml.bind.annotation.*;


/**
 * <p>Java class for Interval complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="Interval">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="lower_included" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="upper_included" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="lower_unbounded" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="upper_unbounded" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Interval", propOrder = {
        "lowerIncluded",
        "upperIncluded",
        "lowerUnbounded",
        "upperUnbounded"
})
@XmlSeeAlso({
        IntervalOfTime.class,
        IntervalOfDuration.class,
        IntervalOfDateTime.class,
        IntervalOfInteger.class,
        IntervalOfReal.class,
        IntervalOfDate.class
})
public abstract class Interval {

    @XmlElement(name = "lower_included")
    protected Boolean lowerIncluded;
    @XmlElement(name = "upper_included")
    protected Boolean upperIncluded;
    @XmlElement(name = "lower_unbounded")
    protected boolean lowerUnbounded;
    @XmlElement(name = "upper_unbounded")
    protected boolean upperUnbounded;

    /**
     * Gets the value of the lowerIncluded property.
     *
     * @return possible object is
     * {@link Boolean }
     */
    public Boolean isLowerIncluded() {
        return lowerIncluded;
    }

    /**
     * Sets the value of the lowerIncluded property.
     *
     * @param value allowed object is
     *              {@link Boolean }
     */
    public void setLowerIncluded(Boolean value) {
        this.lowerIncluded = value;
    }

    /**
     * Gets the value of the upperIncluded property.
     *
     * @return possible object is
     * {@link Boolean }
     */
    public Boolean isUpperIncluded() {
        return upperIncluded;
    }

    /**
     * Sets the value of the upperIncluded property.
     *
     * @param value allowed object is
     *              {@link Boolean }
     */
    public void setUpperIncluded(Boolean value) {
        this.upperIncluded = value;
    }

    /**
     * Gets the value of the lowerUnbounded property.
     */
    public boolean isLowerUnbounded() {
        return lowerUnbounded;
    }

    /**
     * Sets the value of the lowerUnbounded property.
     */
    public void setLowerUnbounded(boolean value) {
        this.lowerUnbounded = value;
    }

    /**
     * Gets the value of the upperUnbounded property.
     */
    public boolean isUpperUnbounded() {
        return upperUnbounded;
    }

    /**
     * Sets the value of the upperUnbounded property.
     */
    public void setUpperUnbounded(boolean value) {
        this.upperUnbounded = value;
    }

}
