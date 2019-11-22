package com.synnefx.ehrserver.xsd;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for HISTORY complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="HISTORY">
 *   &lt;complexContent>
 *     &lt;extension base="{http://schemas.openehr.org/v1}LOCATABLE">
 *       &lt;sequence>
 *         &lt;element name="origin" type="{http://schemas.openehr.org/v1}DV_DATE_TIME"/>
 *         &lt;element name="period" type="{http://schemas.openehr.org/v1}DV_DURATION" minOccurs="0"/>
 *         &lt;element name="duration" type="{http://schemas.openehr.org/v1}DV_DURATION" minOccurs="0"/>
 *         &lt;element name="events" type="{http://schemas.openehr.org/v1}EVENT" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="summary" type="{http://schemas.openehr.org/v1}ITEM_STRUCTURE" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HISTORY", propOrder = {
        "origin",
        "period",
        "duration",
        "events",
        "summary"
})
public class HISTORY
        extends LOCATABLE {

    @XmlElement(required = true)
    protected DVDATETIME origin;
    protected DVDURATION period;
    protected DVDURATION duration;
    protected List<EVENT> events;
    protected ITEMSTRUCTURE summary;

    /**
     * Gets the value of the origin property.
     *
     * @return possible object is
     * {@link DVDATETIME }
     */
    public DVDATETIME getOrigin() {
        return origin;
    }

    /**
     * Sets the value of the origin property.
     *
     * @param value allowed object is
     *              {@link DVDATETIME }
     */
    public void setOrigin(DVDATETIME value) {
        this.origin = value;
    }

    /**
     * Gets the value of the period property.
     *
     * @return possible object is
     * {@link DVDURATION }
     */
    public DVDURATION getPeriod() {
        return period;
    }

    /**
     * Sets the value of the period property.
     *
     * @param value allowed object is
     *              {@link DVDURATION }
     */
    public void setPeriod(DVDURATION value) {
        this.period = value;
    }

    /**
     * Gets the value of the duration property.
     *
     * @return possible object is
     * {@link DVDURATION }
     */
    public DVDURATION getDuration() {
        return duration;
    }

    /**
     * Sets the value of the duration property.
     *
     * @param value allowed object is
     *              {@link DVDURATION }
     */
    public void setDuration(DVDURATION value) {
        this.duration = value;
    }

    /**
     * Gets the value of the events property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the events property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEvents().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EVENT }
     */
    public List<EVENT> getEvents() {
        if (events == null) {
            events = new ArrayList<EVENT>();
        }
        return this.events;
    }

    /**
     * Gets the value of the summary property.
     *
     * @return possible object is
     * {@link ITEMSTRUCTURE }
     */
    public ITEMSTRUCTURE getSummary() {
        return summary;
    }

    /**
     * Sets the value of the summary property.
     *
     * @param value allowed object is
     *              {@link ITEMSTRUCTURE }
     */
    public void setSummary(ITEMSTRUCTURE value) {
        this.summary = value;
    }

}
