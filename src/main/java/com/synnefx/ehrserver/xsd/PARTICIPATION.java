package com.synnefx.ehrserver.xsd;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PARTICIPATION complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="PARTICIPATION">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="function" type="{http://schemas.openehr.org/v1}DV_TEXT"/>
 *         &lt;element name="performer" type="{http://schemas.openehr.org/v1}PARTY_PROXY"/>
 *         &lt;element name="time" type="{http://schemas.openehr.org/v1}DV_INTERVAL" minOccurs="0"/>
 *         &lt;element name="mode" type="{http://schemas.openehr.org/v1}DV_CODED_TEXT"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PARTICIPATION", propOrder = {
        "function",
        "performer",
        "time",
        "mode"
})
public class PARTICIPATION {

    @XmlElement(required = true)
    protected DVTEXT function;
    @XmlElement(required = true)
    protected PARTYPROXY performer;
    protected DVINTERVAL time;
    @XmlElement(required = true)
    protected DVCODEDTEXT mode;

    /**
     * Gets the value of the function property.
     *
     * @return possible object is
     * {@link DVTEXT }
     */
    public DVTEXT getFunction() {
        return function;
    }

    /**
     * Sets the value of the function property.
     *
     * @param value allowed object is
     *              {@link DVTEXT }
     */
    public void setFunction(DVTEXT value) {
        this.function = value;
    }

    /**
     * Gets the value of the performer property.
     *
     * @return possible object is
     * {@link PARTYPROXY }
     */
    public PARTYPROXY getPerformer() {
        return performer;
    }

    /**
     * Sets the value of the performer property.
     *
     * @param value allowed object is
     *              {@link PARTYPROXY }
     */
    public void setPerformer(PARTYPROXY value) {
        this.performer = value;
    }

    /**
     * Gets the value of the time property.
     *
     * @return possible object is
     * {@link DVINTERVAL }
     */
    public DVINTERVAL getTime() {
        return time;
    }

    /**
     * Sets the value of the time property.
     *
     * @param value allowed object is
     *              {@link DVINTERVAL }
     */
    public void setTime(DVINTERVAL value) {
        this.time = value;
    }

    /**
     * Gets the value of the mode property.
     *
     * @return possible object is
     * {@link DVCODEDTEXT }
     */
    public DVCODEDTEXT getMode() {
        return mode;
    }

    /**
     * Sets the value of the mode property.
     *
     * @param value allowed object is
     *              {@link DVCODEDTEXT }
     */
    public void setMode(DVCODEDTEXT value) {
        this.mode = value;
    }

}
