package com.synnefx.ehrserver.xsd;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for INSTRUCTION_DETAILS complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="INSTRUCTION_DETAILS">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="instruction_id" type="{http://schemas.openehr.org/v1}LOCATABLE_REF"/>
 *         &lt;element name="activity_id" type="{http://schemas.openehr.org/v1}atCode"/>
 *         &lt;element name="wf_details" type="{http://schemas.openehr.org/v1}ITEM_STRUCTURE" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "INSTRUCTION_DETAILS", propOrder = {
        "instructionId",
        "activityId",
        "wfDetails"
})
public class INSTRUCTIONDETAILS {

    @XmlElement(name = "instruction_id", required = true)
    protected LOCATABLEREF instructionId;
    @XmlElement(name = "activity_id", required = true)
    protected String activityId;
    @XmlElement(name = "wf_details")
    protected ITEMSTRUCTURE wfDetails;

    /**
     * Gets the value of the instructionId property.
     *
     * @return possible object is
     * {@link LOCATABLEREF }
     */
    public LOCATABLEREF getInstructionId() {
        return instructionId;
    }

    /**
     * Sets the value of the instructionId property.
     *
     * @param value allowed object is
     *              {@link LOCATABLEREF }
     */
    public void setInstructionId(LOCATABLEREF value) {
        this.instructionId = value;
    }

    /**
     * Gets the value of the activityId property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getActivityId() {
        return activityId;
    }

    /**
     * Sets the value of the activityId property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setActivityId(String value) {
        this.activityId = value;
    }

    /**
     * Gets the value of the wfDetails property.
     *
     * @return possible object is
     * {@link ITEMSTRUCTURE }
     */
    public ITEMSTRUCTURE getWfDetails() {
        return wfDetails;
    }

    /**
     * Sets the value of the wfDetails property.
     *
     * @param value allowed object is
     *              {@link ITEMSTRUCTURE }
     */
    public void setWfDetails(ITEMSTRUCTURE value) {
        this.wfDetails = value;
    }

}
