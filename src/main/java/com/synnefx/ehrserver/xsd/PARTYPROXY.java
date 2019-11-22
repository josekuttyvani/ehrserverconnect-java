package com.synnefx.ehrserver.xsd;

import javax.xml.bind.annotation.*;


/**
 * <p>Java class for PARTY_PROXY complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="PARTY_PROXY">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="external_ref" type="{http://schemas.openehr.org/v1}PARTY_REF" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PARTY_PROXY", propOrder = {
        "externalRef"
})
@XmlSeeAlso({
        PARTYSELF.class,
        PARTYIDENTIFIED.class
})
public abstract class PARTYPROXY {

    @XmlElement(name = "external_ref")
    protected PARTYREF externalRef;

    /**
     * Gets the value of the externalRef property.
     *
     * @return possible object is
     * {@link PARTYREF }
     */
    public PARTYREF getExternalRef() {
        return externalRef;
    }

    /**
     * Sets the value of the externalRef property.
     *
     * @param value allowed object is
     *              {@link PARTYREF }
     */
    public void setExternalRef(PARTYREF value) {
        this.externalRef = value;
    }

}
