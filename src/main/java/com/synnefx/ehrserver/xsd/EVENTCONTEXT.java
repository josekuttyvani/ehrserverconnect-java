package com.synnefx.ehrserver.xsd;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for EVENT_CONTEXT complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="EVENT_CONTEXT">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="start_time" type="{http://schemas.openehr.org/v1}DV_DATE_TIME"/>
 *         &lt;element name="end_time" type="{http://schemas.openehr.org/v1}DV_DATE_TIME" minOccurs="0"/>
 *         &lt;element name="location" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="setting" type="{http://schemas.openehr.org/v1}DV_CODED_TEXT"/>
 *         &lt;element name="other_context" type="{http://schemas.openehr.org/v1}ITEM_STRUCTURE" minOccurs="0"/>
 *         &lt;element name="health_care_facility" type="{http://schemas.openehr.org/v1}PARTY_IDENTIFIED" minOccurs="0"/>
 *         &lt;element name="participations" type="{http://schemas.openehr.org/v1}PARTICIPATION" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EVENT_CONTEXT", propOrder = {
        "startTime",
        "endTime",
        "location",
        "setting",
        "otherContext",
        "healthCareFacility",
        "participations"
})
public class EVENTCONTEXT {

    @XmlElement(name = "start_time", required = true)
    protected DVDATETIME startTime;
    @XmlElement(name = "end_time")
    protected DVDATETIME endTime;
    protected String location;
    @XmlElement(required = true)
    protected DVCODEDTEXT setting;
    @XmlElement(name = "other_context")
    protected ITEMSTRUCTURE otherContext;
    @XmlElement(name = "health_care_facility")
    protected PARTYIDENTIFIED healthCareFacility;
    protected List<PARTICIPATION> participations;

    /**
     * Gets the value of the startTime property.
     *
     * @return possible object is
     * {@link DVDATETIME }
     */
    public DVDATETIME getStartTime() {
        return startTime;
    }

    /**
     * Sets the value of the startTime property.
     *
     * @param value allowed object is
     *              {@link DVDATETIME }
     */
    public void setStartTime(DVDATETIME value) {
        this.startTime = value;
    }

    /**
     * Gets the value of the endTime property.
     *
     * @return possible object is
     * {@link DVDATETIME }
     */
    public DVDATETIME getEndTime() {
        return endTime;
    }

    /**
     * Sets the value of the endTime property.
     *
     * @param value allowed object is
     *              {@link DVDATETIME }
     */
    public void setEndTime(DVDATETIME value) {
        this.endTime = value;
    }

    /**
     * Gets the value of the location property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getLocation() {
        return location;
    }

    /**
     * Sets the value of the location property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setLocation(String value) {
        this.location = value;
    }

    /**
     * Gets the value of the setting property.
     *
     * @return possible object is
     * {@link DVCODEDTEXT }
     */
    public DVCODEDTEXT getSetting() {
        return setting;
    }

    /**
     * Sets the value of the setting property.
     *
     * @param value allowed object is
     *              {@link DVCODEDTEXT }
     */
    public void setSetting(DVCODEDTEXT value) {
        this.setting = value;
    }

    /**
     * Gets the value of the otherContext property.
     *
     * @return possible object is
     * {@link ITEMSTRUCTURE }
     */
    public ITEMSTRUCTURE getOtherContext() {
        return otherContext;
    }

    /**
     * Sets the value of the otherContext property.
     *
     * @param value allowed object is
     *              {@link ITEMSTRUCTURE }
     */
    public void setOtherContext(ITEMSTRUCTURE value) {
        this.otherContext = value;
    }

    /**
     * Gets the value of the healthCareFacility property.
     *
     * @return possible object is
     * {@link PARTYIDENTIFIED }
     */
    public PARTYIDENTIFIED getHealthCareFacility() {
        return healthCareFacility;
    }

    /**
     * Sets the value of the healthCareFacility property.
     *
     * @param value allowed object is
     *              {@link PARTYIDENTIFIED }
     */
    public void setHealthCareFacility(PARTYIDENTIFIED value) {
        this.healthCareFacility = value;
    }

    /**
     * Gets the value of the participations property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the participations property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getParticipations().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PARTICIPATION }
     */
    public List<PARTICIPATION> getParticipations() {
        if (participations == null) {
            participations = new ArrayList<PARTICIPATION>();
        }
        return this.participations;
    }

}
