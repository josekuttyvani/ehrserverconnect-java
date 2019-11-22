package com.synnefx.ehrserver.xsd;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for ENTRY complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="ENTRY">
 *   &lt;complexContent>
 *     &lt;extension base="{http://schemas.openehr.org/v1}CONTENT_ITEM">
 *       &lt;sequence>
 *         &lt;element name="language" type="{http://schemas.openehr.org/v1}CODE_PHRASE"/>
 *         &lt;element name="encoding" type="{http://schemas.openehr.org/v1}CODE_PHRASE"/>
 *         &lt;element name="subject" type="{http://schemas.openehr.org/v1}PARTY_PROXY"/>
 *         &lt;element name="provider" type="{http://schemas.openehr.org/v1}PARTY_PROXY" minOccurs="0"/>
 *         &lt;element name="other_participations" type="{http://schemas.openehr.org/v1}PARTICIPATION" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="work_flow_id" type="{http://schemas.openehr.org/v1}OBJECT_REF" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ENTRY", propOrder = {
        "language",
        "encoding",
        "subject",
        "provider",
        "otherParticipations",
        "workFlowId"
})
@XmlSeeAlso({
        ADMINENTRY.class,
        CAREENTRY.class
})
public abstract class ENTRY
        extends CONTENTITEM {

    @XmlElement(required = true)
    protected CODEPHRASE language;
    @XmlElement(required = true)
    protected CODEPHRASE encoding;
    @XmlElement(required = true)
    protected PARTYPROXY subject;
    protected PARTYPROXY provider;
    @XmlElement(name = "other_participations")
    protected List<PARTICIPATION> otherParticipations;
    @XmlElement(name = "work_flow_id")
    protected OBJECTREF workFlowId;

    /**
     * Gets the value of the language property.
     *
     * @return possible object is
     * {@link CODEPHRASE }
     */
    public CODEPHRASE getLanguage() {
        return language;
    }

    /**
     * Sets the value of the language property.
     *
     * @param value allowed object is
     *              {@link CODEPHRASE }
     */
    public void setLanguage(CODEPHRASE value) {
        this.language = value;
    }

    /**
     * Gets the value of the encoding property.
     *
     * @return possible object is
     * {@link CODEPHRASE }
     */
    public CODEPHRASE getEncoding() {
        return encoding;
    }

    /**
     * Sets the value of the encoding property.
     *
     * @param value allowed object is
     *              {@link CODEPHRASE }
     */
    public void setEncoding(CODEPHRASE value) {
        this.encoding = value;
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
     * Gets the value of the provider property.
     *
     * @return possible object is
     * {@link PARTYPROXY }
     */
    public PARTYPROXY getProvider() {
        return provider;
    }

    /**
     * Sets the value of the provider property.
     *
     * @param value allowed object is
     *              {@link PARTYPROXY }
     */
    public void setProvider(PARTYPROXY value) {
        this.provider = value;
    }

    /**
     * Gets the value of the otherParticipations property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the otherParticipations property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOtherParticipations().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PARTICIPATION }
     */
    public List<PARTICIPATION> getOtherParticipations() {
        if (otherParticipations == null) {
            otherParticipations = new ArrayList<PARTICIPATION>();
        }
        return this.otherParticipations;
    }

    /**
     * Gets the value of the workFlowId property.
     *
     * @return possible object is
     * {@link OBJECTREF }
     */
    public OBJECTREF getWorkFlowId() {
        return workFlowId;
    }

    /**
     * Sets the value of the workFlowId property.
     *
     * @param value allowed object is
     *              {@link OBJECTREF }
     */
    public void setWorkFlowId(OBJECTREF value) {
        this.workFlowId = value;
    }

}
