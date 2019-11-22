package com.synnefx.ehrserver.xsd;

import javax.xml.bind.annotation.*;


/**
 * <p>Java class for CARE_ENTRY complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="CARE_ENTRY">
 *   &lt;complexContent>
 *     &lt;extension base="{http://schemas.openehr.org/v1}ENTRY">
 *       &lt;sequence>
 *         &lt;element name="protocol" type="{http://schemas.openehr.org/v1}ITEM_STRUCTURE" minOccurs="0"/>
 *         &lt;element name="guideline_id" type="{http://schemas.openehr.org/v1}OBJECT_REF" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CARE_ENTRY", propOrder = {
        "protocol",
        "guidelineId"
})
@XmlSeeAlso({
        INSTRUCTION.class,
        EVALUATION.class,
        OBSERVATION.class,
        ACTION.class
})
public abstract class CAREENTRY
        extends ENTRY {

    protected ITEMSTRUCTURE protocol;
    @XmlElement(name = "guideline_id")
    protected OBJECTREF guidelineId;

    /**
     * Gets the value of the protocol property.
     *
     * @return possible object is
     * {@link ITEMSTRUCTURE }
     */
    public ITEMSTRUCTURE getProtocol() {
        return protocol;
    }

    /**
     * Sets the value of the protocol property.
     *
     * @param value allowed object is
     *              {@link ITEMSTRUCTURE }
     */
    public void setProtocol(ITEMSTRUCTURE value) {
        this.protocol = value;
    }

    /**
     * Gets the value of the guidelineId property.
     *
     * @return possible object is
     * {@link OBJECTREF }
     */
    public OBJECTREF getGuidelineId() {
        return guidelineId;
    }

    /**
     * Sets the value of the guidelineId property.
     *
     * @param value allowed object is
     *              {@link OBJECTREF }
     */
    public void setGuidelineId(OBJECTREF value) {
        this.guidelineId = value;
    }

}
