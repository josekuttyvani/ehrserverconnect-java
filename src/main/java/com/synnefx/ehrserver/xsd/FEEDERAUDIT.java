package com.synnefx.ehrserver.xsd;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for FEEDER_AUDIT complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="FEEDER_AUDIT">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="originating_system_item_ids" type="{http://schemas.openehr.org/v1}DV_IDENTIFIER" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="feeder_system_item_ids" type="{http://schemas.openehr.org/v1}DV_IDENTIFIER" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="original_content" type="{http://schemas.openehr.org/v1}DV_ENCAPSULATED" minOccurs="0"/>
 *         &lt;element name="originating_system_audit" type="{http://schemas.openehr.org/v1}FEEDER_AUDIT_DETAILS"/>
 *         &lt;element name="feeder_system_audit" type="{http://schemas.openehr.org/v1}FEEDER_AUDIT_DETAILS" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FEEDER_AUDIT", propOrder = {
        "originatingSystemItemIds",
        "feederSystemItemIds",
        "originalContent",
        "originatingSystemAudit",
        "feederSystemAudit"
})
public class FEEDERAUDIT {

    @XmlElement(name = "originating_system_item_ids")
    protected List<DVIDENTIFIER> originatingSystemItemIds;
    @XmlElement(name = "feeder_system_item_ids")
    protected List<DVIDENTIFIER> feederSystemItemIds;
    @XmlElement(name = "original_content")
    protected DVENCAPSULATED originalContent;
    @XmlElement(name = "originating_system_audit", required = true)
    protected FEEDERAUDITDETAILS originatingSystemAudit;
    @XmlElement(name = "feeder_system_audit")
    protected FEEDERAUDITDETAILS feederSystemAudit;

    /**
     * Gets the value of the originatingSystemItemIds property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the originatingSystemItemIds property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOriginatingSystemItemIds().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DVIDENTIFIER }
     */
    public List<DVIDENTIFIER> getOriginatingSystemItemIds() {
        if (originatingSystemItemIds == null) {
            originatingSystemItemIds = new ArrayList<DVIDENTIFIER>();
        }
        return this.originatingSystemItemIds;
    }

    /**
     * Gets the value of the feederSystemItemIds property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the feederSystemItemIds property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFeederSystemItemIds().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DVIDENTIFIER }
     */
    public List<DVIDENTIFIER> getFeederSystemItemIds() {
        if (feederSystemItemIds == null) {
            feederSystemItemIds = new ArrayList<DVIDENTIFIER>();
        }
        return this.feederSystemItemIds;
    }

    /**
     * Gets the value of the originalContent property.
     *
     * @return possible object is
     * {@link DVENCAPSULATED }
     */
    public DVENCAPSULATED getOriginalContent() {
        return originalContent;
    }

    /**
     * Sets the value of the originalContent property.
     *
     * @param value allowed object is
     *              {@link DVENCAPSULATED }
     */
    public void setOriginalContent(DVENCAPSULATED value) {
        this.originalContent = value;
    }

    /**
     * Gets the value of the originatingSystemAudit property.
     *
     * @return possible object is
     * {@link FEEDERAUDITDETAILS }
     */
    public FEEDERAUDITDETAILS getOriginatingSystemAudit() {
        return originatingSystemAudit;
    }

    /**
     * Sets the value of the originatingSystemAudit property.
     *
     * @param value allowed object is
     *              {@link FEEDERAUDITDETAILS }
     */
    public void setOriginatingSystemAudit(FEEDERAUDITDETAILS value) {
        this.originatingSystemAudit = value;
    }

    /**
     * Gets the value of the feederSystemAudit property.
     *
     * @return possible object is
     * {@link FEEDERAUDITDETAILS }
     */
    public FEEDERAUDITDETAILS getFeederSystemAudit() {
        return feederSystemAudit;
    }

    /**
     * Sets the value of the feederSystemAudit property.
     *
     * @param value allowed object is
     *              {@link FEEDERAUDITDETAILS }
     */
    public void setFeederSystemAudit(FEEDERAUDITDETAILS value) {
        this.feederSystemAudit = value;
    }

}
