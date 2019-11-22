package com.synnefx.ehrserver.xsd;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PARTY_RELATED complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="PARTY_RELATED">
 *   &lt;complexContent>
 *     &lt;extension base="{http://schemas.openehr.org/v1}PARTY_IDENTIFIED">
 *       &lt;sequence>
 *         &lt;element name="relationship" type="{http://schemas.openehr.org/v1}DV_CODED_TEXT"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PARTY_RELATED", propOrder = {
        "relationship"
})
public class PARTYRELATED
        extends PARTYIDENTIFIED {

    @XmlElement(required = true)
    protected DVCODEDTEXT relationship;

    /**
     * Gets the value of the relationship property.
     *
     * @return possible object is
     * {@link DVCODEDTEXT }
     */
    public DVCODEDTEXT getRelationship() {
        return relationship;
    }

    /**
     * Sets the value of the relationship property.
     *
     * @param value allowed object is
     *              {@link DVCODEDTEXT }
     */
    public void setRelationship(DVCODEDTEXT value) {
        this.relationship = value;
    }

}
