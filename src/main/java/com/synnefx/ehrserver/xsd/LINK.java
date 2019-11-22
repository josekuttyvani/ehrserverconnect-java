package com.synnefx.ehrserver.xsd;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for LINK complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="LINK">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="meaning" type="{http://schemas.openehr.org/v1}DV_TEXT"/>
 *         &lt;element name="type" type="{http://schemas.openehr.org/v1}DV_TEXT"/>
 *         &lt;element name="target" type="{http://schemas.openehr.org/v1}DV_EHR_URI"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LINK", propOrder = {
        "meaning",
        "type",
        "target"
})
public class LINK {

    @XmlElement(required = true)
    protected DVTEXT meaning;
    @XmlElement(required = true)
    protected DVTEXT type;
    @XmlElement(required = true)
    protected DVEHRURI target;

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
     * Gets the value of the type property.
     *
     * @return possible object is
     * {@link DVTEXT }
     */
    public DVTEXT getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     *
     * @param value allowed object is
     *              {@link DVTEXT }
     */
    public void setType(DVTEXT value) {
        this.type = value;
    }

    /**
     * Gets the value of the target property.
     *
     * @return possible object is
     * {@link DVEHRURI }
     */
    public DVEHRURI getTarget() {
        return target;
    }

    /**
     * Sets the value of the target property.
     *
     * @param value allowed object is
     *              {@link DVEHRURI }
     */
    public void setTarget(DVEHRURI value) {
        this.target = value;
    }

}
