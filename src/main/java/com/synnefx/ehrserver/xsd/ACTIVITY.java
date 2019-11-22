package com.synnefx.ehrserver.xsd;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ACTIVITY complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="ACTIVITY">
 *   &lt;complexContent>
 *     &lt;extension base="{http://schemas.openehr.org/v1}LOCATABLE">
 *       &lt;sequence>
 *         &lt;element name="description" type="{http://schemas.openehr.org/v1}ITEM_STRUCTURE"/>
 *         &lt;element name="timing" type="{http://schemas.openehr.org/v1}DV_PARSABLE"/>
 *         &lt;element name="action_archetype_id" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ACTIVITY", propOrder = {
        "description",
        "timing",
        "actionArchetypeId"
})
public class ACTIVITY
        extends LOCATABLE {

    @XmlElement(required = true)
    protected ITEMSTRUCTURE description;
    @XmlElement(required = true)
    protected DVPARSABLE timing;
    @XmlElement(name = "action_archetype_id", required = true)
    protected String actionArchetypeId;

    /**
     * Gets the value of the description property.
     *
     * @return possible object is
     * {@link ITEMSTRUCTURE }
     */
    public ITEMSTRUCTURE getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     *
     * @param value allowed object is
     *              {@link ITEMSTRUCTURE }
     */
    public void setDescription(ITEMSTRUCTURE value) {
        this.description = value;
    }

    /**
     * Gets the value of the timing property.
     *
     * @return possible object is
     * {@link DVPARSABLE }
     */
    public DVPARSABLE getTiming() {
        return timing;
    }

    /**
     * Sets the value of the timing property.
     *
     * @param value allowed object is
     *              {@link DVPARSABLE }
     */
    public void setTiming(DVPARSABLE value) {
        this.timing = value;
    }

    /**
     * Gets the value of the actionArchetypeId property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getActionArchetypeId() {
        return actionArchetypeId;
    }

    /**
     * Sets the value of the actionArchetypeId property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setActionArchetypeId(String value) {
        this.actionArchetypeId = value;
    }

}
