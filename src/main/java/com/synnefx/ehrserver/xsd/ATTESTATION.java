package com.synnefx.ehrserver.xsd;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for ATTESTATION complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="ATTESTATION">
 *   &lt;complexContent>
 *     &lt;extension base="{http://schemas.openehr.org/v1}AUDIT_DETAILS">
 *       &lt;sequence>
 *         &lt;element name="attested_view" type="{http://schemas.openehr.org/v1}DV_MULTIMEDIA" minOccurs="0"/>
 *         &lt;element name="proof" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="items" type="{http://schemas.openehr.org/v1}DV_EHR_URI" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="reason" type="{http://schemas.openehr.org/v1}DV_TEXT"/>
 *         &lt;element name="is_pending" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ATTESTATION", propOrder = {
        "attestedView",
        "proof",
        "items",
        "reason",
        "isPending"
})
public class ATTESTATION
        extends AUDITDETAILS {

    @XmlElement(name = "attested_view")
    protected DVMULTIMEDIA attestedView;
    protected String proof;
    protected List<DVEHRURI> items;
    @XmlElement(required = true)
    protected DVTEXT reason;
    @XmlElement(name = "is_pending", defaultValue = "false")
    protected boolean isPending;

    /**
     * Gets the value of the attestedView property.
     *
     * @return possible object is
     * {@link DVMULTIMEDIA }
     */
    public DVMULTIMEDIA getAttestedView() {
        return attestedView;
    }

    /**
     * Sets the value of the attestedView property.
     *
     * @param value allowed object is
     *              {@link DVMULTIMEDIA }
     */
    public void setAttestedView(DVMULTIMEDIA value) {
        this.attestedView = value;
    }

    /**
     * Gets the value of the proof property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getProof() {
        return proof;
    }

    /**
     * Sets the value of the proof property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setProof(String value) {
        this.proof = value;
    }

    /**
     * Gets the value of the items property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the items property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getItems().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DVEHRURI }
     */
    public List<DVEHRURI> getItems() {
        if (items == null) {
            items = new ArrayList<DVEHRURI>();
        }
        return this.items;
    }

    /**
     * Gets the value of the reason property.
     *
     * @return possible object is
     * {@link DVTEXT }
     */
    public DVTEXT getReason() {
        return reason;
    }

    /**
     * Sets the value of the reason property.
     *
     * @param value allowed object is
     *              {@link DVTEXT }
     */
    public void setReason(DVTEXT value) {
        this.reason = value;
    }

    /**
     * Gets the value of the isPending property.
     */
    public boolean isIsPending() {
        return isPending;
    }

    /**
     * Sets the value of the isPending property.
     */
    public void setIsPending(boolean value) {
        this.isPending = value;
    }

}
