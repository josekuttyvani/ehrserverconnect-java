package com.synnefx.ehrserver.xsd;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ACTION complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="ACTION">
 *   &lt;complexContent>
 *     &lt;extension base="{http://schemas.openehr.org/v1}CARE_ENTRY">
 *       &lt;sequence>
 *         &lt;element name="time" type="{http://schemas.openehr.org/v1}DV_DATE_TIME"/>
 *         &lt;element name="description" type="{http://schemas.openehr.org/v1}ITEM_STRUCTURE"/>
 *         &lt;element name="ism_transition" type="{http://schemas.openehr.org/v1}ISM_TRANSITION"/>
 *         &lt;element name="instruction_details" type="{http://schemas.openehr.org/v1}INSTRUCTION_DETAILS" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ACTION", propOrder = {
        "time",
        "description",
        "ismTransition",
        "instructionDetails"
})
public class ACTION
        extends CAREENTRY {

    @XmlElement(required = true)
    protected DVDATETIME time;
    @XmlElement(required = true)
    protected ITEMSTRUCTURE description;
    @XmlElement(name = "ism_transition", required = true)
    protected ISMTRANSITION ismTransition;
    @XmlElement(name = "instruction_details")
    protected INSTRUCTIONDETAILS instructionDetails;

    /**
     * Gets the value of the time property.
     *
     * @return possible object is
     * {@link DVDATETIME }
     */
    public DVDATETIME getTime() {
        return time;
    }

    /**
     * Sets the value of the time property.
     *
     * @param value allowed object is
     *              {@link DVDATETIME }
     */
    public void setTime(DVDATETIME value) {
        this.time = value;
    }

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
     * Gets the value of the ismTransition property.
     *
     * @return possible object is
     * {@link ISMTRANSITION }
     */
    public ISMTRANSITION getIsmTransition() {
        return ismTransition;
    }

    /**
     * Sets the value of the ismTransition property.
     *
     * @param value allowed object is
     *              {@link ISMTRANSITION }
     */
    public void setIsmTransition(ISMTRANSITION value) {
        this.ismTransition = value;
    }

    /**
     * Gets the value of the instructionDetails property.
     *
     * @return possible object is
     * {@link INSTRUCTIONDETAILS }
     */
    public INSTRUCTIONDETAILS getInstructionDetails() {
        return instructionDetails;
    }

    /**
     * Sets the value of the instructionDetails property.
     *
     * @param value allowed object is
     *              {@link INSTRUCTIONDETAILS }
     */
    public void setInstructionDetails(INSTRUCTIONDETAILS value) {
        this.instructionDetails = value;
    }

}
