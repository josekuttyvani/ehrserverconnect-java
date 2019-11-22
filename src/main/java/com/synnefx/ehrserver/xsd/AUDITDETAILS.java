package com.synnefx.ehrserver.xsd;

import javax.xml.bind.annotation.*;


/**
 * <p>Java class for AUDIT_DETAILS complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="AUDIT_DETAILS">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="system_id" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="committer" type="{http://schemas.openehr.org/v1}PARTY_PROXY"/>
 *         &lt;element name="time_committed" type="{http://schemas.openehr.org/v1}DV_DATE_TIME"/>
 *         &lt;element name="change_type" type="{http://schemas.openehr.org/v1}DV_CODED_TEXT"/>
 *         &lt;element name="description" type="{http://schemas.openehr.org/v1}DV_TEXT" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AUDIT_DETAILS", propOrder = {
        "systemId",
        "committer",
        "timeCommitted",
        "changeType",
        "description"
})
@XmlSeeAlso({
        ATTESTATION.class
})
public class AUDITDETAILS {

    @XmlElement(name = "system_id", required = true)
    protected String systemId;
    @XmlElement(required = true)
    protected PARTYPROXY committer;
    @XmlElement(name = "time_committed", required = true)
    protected DVDATETIME timeCommitted;
    @XmlElement(name = "change_type", required = true)
    protected DVCODEDTEXT changeType;
    protected DVTEXT description;

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
     * Gets the value of the committer property.
     *
     * @return possible object is
     * {@link PARTYPROXY }
     */
    public PARTYPROXY getCommitter() {
        return committer;
    }

    /**
     * Sets the value of the committer property.
     *
     * @param value allowed object is
     *              {@link PARTYPROXY }
     */
    public void setCommitter(PARTYPROXY value) {
        this.committer = value;
    }

    /**
     * Gets the value of the timeCommitted property.
     *
     * @return possible object is
     * {@link DVDATETIME }
     */
    public DVDATETIME getTimeCommitted() {
        return timeCommitted;
    }

    /**
     * Sets the value of the timeCommitted property.
     *
     * @param value allowed object is
     *              {@link DVDATETIME }
     */
    public void setTimeCommitted(DVDATETIME value) {
        this.timeCommitted = value;
    }

    /**
     * Gets the value of the changeType property.
     *
     * @return possible object is
     * {@link DVCODEDTEXT }
     */
    public DVCODEDTEXT getChangeType() {
        return changeType;
    }

    /**
     * Sets the value of the changeType property.
     *
     * @param value allowed object is
     *              {@link DVCODEDTEXT }
     */
    public void setChangeType(DVCODEDTEXT value) {
        this.changeType = value;
    }

    /**
     * Gets the value of the description property.
     *
     * @return possible object is
     * {@link DVTEXT }
     */
    public DVTEXT getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     *
     * @param value allowed object is
     *              {@link DVTEXT }
     */
    public void setDescription(DVTEXT value) {
        this.description = value;
    }

}
