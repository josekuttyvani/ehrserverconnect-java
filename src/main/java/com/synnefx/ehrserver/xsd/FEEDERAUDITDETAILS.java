package com.synnefx.ehrserver.xsd;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for FEEDER_AUDIT_DETAILS complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="FEEDER_AUDIT_DETAILS">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="system_id" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="location" type="{http://schemas.openehr.org/v1}PARTY_IDENTIFIED" minOccurs="0"/>
 *         &lt;element name="provider" type="{http://schemas.openehr.org/v1}PARTY_IDENTIFIED" minOccurs="0"/>
 *         &lt;element name="subject" type="{http://schemas.openehr.org/v1}PARTY_PROXY" minOccurs="0"/>
 *         &lt;element name="time" type="{http://schemas.openehr.org/v1}DV_DATE_TIME" minOccurs="0"/>
 *         &lt;element name="version_id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FEEDER_AUDIT_DETAILS", propOrder = {
        "systemId",
        "location",
        "provider",
        "subject",
        "time",
        "versionId"
})
public class FEEDERAUDITDETAILS {

    @XmlElement(name = "system_id", required = true)
    protected String systemId;
    protected PARTYIDENTIFIED location;
    protected PARTYIDENTIFIED provider;
    protected PARTYPROXY subject;
    protected DVDATETIME time;
    @XmlElement(name = "version_id")
    protected String versionId;

    /**
     * Gets the value of the systemId property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getSystemId() {
        return systemId;
    }

    /**
     * Sets the value of the systemId property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setSystemId(String value) {
        this.systemId = value;
    }

    /**
     * Gets the value of the location property.
     *
     * @return possible object is
     * {@link PARTYIDENTIFIED }
     */
    public PARTYIDENTIFIED getLocation() {
        return location;
    }

    /**
     * Sets the value of the location property.
     *
     * @param value allowed object is
     *              {@link PARTYIDENTIFIED }
     */
    public void setLocation(PARTYIDENTIFIED value) {
        this.location = value;
    }

    /**
     * Gets the value of the provider property.
     *
     * @return possible object is
     * {@link PARTYIDENTIFIED }
     */
    public PARTYIDENTIFIED getProvider() {
        return provider;
    }

    /**
     * Sets the value of the provider property.
     *
     * @param value allowed object is
     *              {@link PARTYIDENTIFIED }
     */
    public void setProvider(PARTYIDENTIFIED value) {
        this.provider = value;
    }

    /**
     * Gets the value of the subject property.
     *
     * @return possible object is
     * {@link PARTYPROXY }
     */
    public PARTYPROXY getSubject() {
        return subject;
    }

    /**
     * Sets the value of the subject property.
     *
     * @param value allowed object is
     *              {@link PARTYPROXY }
     */
    public void setSubject(PARTYPROXY value) {
        this.subject = value;
    }

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
     * Gets the value of the versionId property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getVersionId() {
        return versionId;
    }

    /**
     * Sets the value of the versionId property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setVersionId(String value) {
        this.versionId = value;
    }

}
