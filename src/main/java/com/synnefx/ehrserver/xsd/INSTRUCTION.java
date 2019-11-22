package com.synnefx.ehrserver.xsd;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for INSTRUCTION complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="INSTRUCTION">
 *   &lt;complexContent>
 *     &lt;extension base="{http://schemas.openehr.org/v1}CARE_ENTRY">
 *       &lt;sequence>
 *         &lt;element name="narrative" type="{http://schemas.openehr.org/v1}DV_TEXT"/>
 *         &lt;element name="expiry_time" type="{http://schemas.openehr.org/v1}DV_DATE_TIME" minOccurs="0"/>
 *         &lt;element name="wf_definition" type="{http://schemas.openehr.org/v1}DV_PARSABLE" minOccurs="0"/>
 *         &lt;element name="activities" type="{http://schemas.openehr.org/v1}ACTIVITY" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "INSTRUCTION", propOrder = {
        "narrative",
        "expiryTime",
        "wfDefinition",
        "activities"
})
public class INSTRUCTION
        extends CAREENTRY {

    @XmlElement(required = true)
    protected DVTEXT narrative;
    @XmlElement(name = "expiry_time")
    protected DVDATETIME expiryTime;
    @XmlElement(name = "wf_definition")
    protected DVPARSABLE wfDefinition;
    protected List<ACTIVITY> activities;

    /**
     * Gets the value of the narrative property.
     *
     * @return possible object is
     * {@link DVTEXT }
     */
    public DVTEXT getNarrative() {
        return narrative;
    }

    /**
     * Sets the value of the narrative property.
     *
     * @param value allowed object is
     *              {@link DVTEXT }
     */
    public void setNarrative(DVTEXT value) {
        this.narrative = value;
    }

    /**
     * Gets the value of the expiryTime property.
     *
     * @return possible object is
     * {@link DVDATETIME }
     */
    public DVDATETIME getExpiryTime() {
        return expiryTime;
    }

    /**
     * Sets the value of the expiryTime property.
     *
     * @param value allowed object is
     *              {@link DVDATETIME }
     */
    public void setExpiryTime(DVDATETIME value) {
        this.expiryTime = value;
    }

    /**
     * Gets the value of the wfDefinition property.
     *
     * @return possible object is
     * {@link DVPARSABLE }
     */
    public DVPARSABLE getWfDefinition() {
        return wfDefinition;
    }

    /**
     * Sets the value of the wfDefinition property.
     *
     * @param value allowed object is
     *              {@link DVPARSABLE }
     */
    public void setWfDefinition(DVPARSABLE value) {
        this.wfDefinition = value;
    }

    /**
     * Gets the value of the activities property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the activities property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getActivities().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ACTIVITY }
     */
    public List<ACTIVITY> getActivities() {
        if (activities == null) {
            activities = new ArrayList<ACTIVITY>();
        }
        return this.activities;
    }

}
