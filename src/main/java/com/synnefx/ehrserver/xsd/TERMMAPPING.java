package com.synnefx.ehrserver.xsd;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TERM_MAPPING complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="TERM_MAPPING">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="match" type="{http://schemas.openehr.org/v1}matchString"/>
 *         &lt;element name="purpose" type="{http://schemas.openehr.org/v1}DV_CODED_TEXT" minOccurs="0"/>
 *         &lt;element name="target" type="{http://schemas.openehr.org/v1}CODE_PHRASE"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TERM_MAPPING", propOrder = {
        "match",
        "purpose",
        "target"
})
public class TERMMAPPING {

    @XmlElement(required = true, defaultValue = "?")
    protected String match;
    protected DVCODEDTEXT purpose;
    @XmlElement(required = true)
    protected CODEPHRASE target;

    /**
     * Gets the value of the match property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getMatch() {
        return match;
    }

    /**
     * Sets the value of the match property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setMatch(String value) {
        this.match = value;
    }

    /**
     * Gets the value of the purpose property.
     *
     * @return possible object is
     * {@link DVCODEDTEXT }
     */
    public DVCODEDTEXT getPurpose() {
        return purpose;
    }

    /**
     * Sets the value of the purpose property.
     *
     * @param value allowed object is
     *              {@link DVCODEDTEXT }
     */
    public void setPurpose(DVCODEDTEXT value) {
        this.purpose = value;
    }

    /**
     * Gets the value of the target property.
     *
     * @return possible object is
     * {@link CODEPHRASE }
     */
    public CODEPHRASE getTarget() {
        return target;
    }

    /**
     * Sets the value of the target property.
     *
     * @param value allowed object is
     *              {@link CODEPHRASE }
     */
    public void setTarget(CODEPHRASE value) {
        this.target = value;
    }

}
