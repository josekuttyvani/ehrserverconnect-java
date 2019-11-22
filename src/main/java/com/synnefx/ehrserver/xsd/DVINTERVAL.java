package com.synnefx.ehrserver.xsd;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DV_INTERVAL complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="DV_INTERVAL">
 *   &lt;complexContent>
 *     &lt;extension base="{http://schemas.openehr.org/v1}DATA_VALUE">
 *       &lt;sequence>
 *         &lt;element name="lower" type="{http://schemas.openehr.org/v1}DV_ORDERED" minOccurs="0"/>
 *         &lt;element name="upper" type="{http://schemas.openehr.org/v1}DV_ORDERED" minOccurs="0"/>
 *         &lt;element name="lower_included" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="upper_included" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="lower_unbounded" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="upper_unbounded" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DV_INTERVAL", propOrder = {
        "lower",
        "upper",
        "lowerIncluded",
        "upperIncluded",
        "lowerUnbounded",
        "upperUnbounded"
})
public class DVINTERVAL
        extends DATAVALUE {

    protected DVORDERED lower;
    protected DVORDERED upper;
    @XmlElement(name = "lower_included")
    protected Boolean lowerIncluded;
    @XmlElement(name = "upper_included")
    protected Boolean upperIncluded;
    @XmlElement(name = "lower_unbounded")
    protected boolean lowerUnbounded;
    @XmlElement(name = "upper_unbounded")
    protected boolean upperUnbounded;

    /**
     * Gets the value of the lower property.
     *
     * @return possible object is
     * {@link DVORDERED }
     */
    public DVORDERED getLower() {
        return lower;
    }

    /**
     * Sets the value of the lower property.
     *
     * @param value allowed object is
     *              {@link DVORDERED }
     */
    public void setLower(DVORDERED value) {
        this.lower = value;
    }

    /**
     * Gets the value of the upper property.
     *
     * @return possible object is
     * {@link DVORDERED }
     */
    public DVORDERED getUpper() {
        return upper;
    }

    /**
     * Sets the value of the upper property.
     *
     * @param value allowed object is
     *              {@link DVORDERED }
     */
    public void setUpper(DVORDERED value) {
        this.upper = value;
    }

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
