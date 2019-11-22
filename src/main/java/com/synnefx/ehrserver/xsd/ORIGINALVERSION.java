package com.synnefx.ehrserver.xsd;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for ORIGINAL_VERSION complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="ORIGINAL_VERSION">
 *   &lt;complexContent>
 *     &lt;extension base="{http://schemas.openehr.org/v1}VERSION">
 *       &lt;sequence>
 *         &lt;element name="uid" type="{http://schemas.openehr.org/v1}OBJECT_VERSION_ID" minOccurs="0"/>
 *         &lt;element name="data" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/>
 *         &lt;element name="preceding_version_uid" type="{http://schemas.openehr.org/v1}OBJECT_VERSION_ID" minOccurs="0"/>
 *         &lt;element name="other_input_version_uids" type="{http://schemas.openehr.org/v1}OBJECT_VERSION_ID" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="attestations" type="{http://schemas.openehr.org/v1}ATTESTATION" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="lifecycle_state" type="{http://schemas.openehr.org/v1}DV_CODED_TEXT"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ORIGINAL_VERSION", propOrder = {
        "uid",
        "data",
        "precedingVersionUid",
        "otherInputVersionUids",
        "attestations",
        "lifecycleState"
})
@XmlRootElement(name = "version")
public class ORIGINALVERSION
        extends VERSION {

    protected OBJECTVERSIONID uid;
    protected Object data;
    @XmlElement(name = "preceding_version_uid")
    protected OBJECTVERSIONID precedingVersionUid;
    @XmlElement(name = "other_input_version_uids")
    protected List<OBJECTVERSIONID> otherInputVersionUids;
    protected List<ATTESTATION> attestations;
    @XmlElement(name = "lifecycle_state", required = true)
    protected DVCODEDTEXT lifecycleState;

    /**
     * Gets the value of the uid property.
     *
     * @return possible object is
     * {@link OBJECTVERSIONID }
     */
    public OBJECTVERSIONID getUid() {
        return uid;
    }

    /**
     * Sets the value of the uid property.
     *
     * @param value allowed object is
     *              {@link OBJECTVERSIONID }
     */
    public void setUid(OBJECTVERSIONID value) {
        this.uid = value;
    }

    /**
     * Gets the value of the data property.
     *
     * @return possible object is
     * {@link Object }
     */
    public Object getData() {
        return data;
    }

    /**
     * Sets the value of the data property.
     *
     * @param value allowed object is
     *              {@link Object }
     */
    public void setData(Object value) {
        this.data = value;
    }

    /**
     * Gets the value of the precedingVersionUid property.
     *
     * @return possible object is
     * {@link OBJECTVERSIONID }
     */
    public OBJECTVERSIONID getPrecedingVersionUid() {
        return precedingVersionUid;
    }

    /**
     * Sets the value of the precedingVersionUid property.
     *
     * @param value allowed object is
     *              {@link OBJECTVERSIONID }
     */
    public void setPrecedingVersionUid(OBJECTVERSIONID value) {
        this.precedingVersionUid = value;
    }

    /**
     * Gets the value of the otherInputVersionUids property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the otherInputVersionUids property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOtherInputVersionUids().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link OBJECTVERSIONID }
     */
    public List<OBJECTVERSIONID> getOtherInputVersionUids() {
        if (otherInputVersionUids == null) {
            otherInputVersionUids = new ArrayList<OBJECTVERSIONID>();
        }
        return this.otherInputVersionUids;
    }

    /**
     * Gets the value of the attestations property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the attestations property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAttestations().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ATTESTATION }
     */
    public List<ATTESTATION> getAttestations() {
        if (attestations == null) {
            attestations = new ArrayList<ATTESTATION>();
        }
        return this.attestations;
    }

    /**
     * Gets the value of the lifecycleState property.
     *
     * @return possible object is
     * {@link DVCODEDTEXT }
     */
    public DVCODEDTEXT getLifecycleState() {
        return lifecycleState;
    }

    /**
     * Sets the value of the lifecycleState property.
     *
     * @param value allowed object is
     *              {@link DVCODEDTEXT }
     */
    public void setLifecycleState(DVCODEDTEXT value) {
        this.lifecycleState = value;
    }

}
