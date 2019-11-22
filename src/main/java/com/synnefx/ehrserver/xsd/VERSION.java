package com.synnefx.ehrserver.xsd;

import javax.xml.bind.annotation.*;


/**
 * <p>Java class for VERSION complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="VERSION">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="contribution" type="{http://schemas.openehr.org/v1}OBJECT_REF"/>
 *         &lt;element name="commit_audit" type="{http://schemas.openehr.org/v1}AUDIT_DETAILS"/>
 *         &lt;element name="signature" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VERSION", propOrder = {
        "contribution",
        "commitAudit",
        "signature"
})
@XmlSeeAlso({
        ORIGINALVERSION.class,
        IMPORTEDVERSION.class
})

public abstract class VERSION {

    @XmlElement(required = true)
    protected OBJECTREF contribution;
    @XmlElement(name = "commit_audit", required = true)
    protected AUDITDETAILS commitAudit;
    protected String signature;

    /**
     * Gets the value of the contribution property.
     *
     * @return possible object is
     * {@link OBJECTREF }
     */
    public OBJECTREF getContribution() {
        return contribution;
    }

    /**
     * Sets the value of the contribution property.
     *
     * @param value allowed object is
     *              {@link OBJECTREF }
     */
    public void setContribution(OBJECTREF value) {
        this.contribution = value;
    }

    /**
     * Gets the value of the commitAudit property.
     *
     * @return possible object is
     * {@link AUDITDETAILS }
     */
    public AUDITDETAILS getCommitAudit() {
        return commitAudit;
    }

    /**
     * Sets the value of the commitAudit property.
     *
     * @param value allowed object is
     *              {@link AUDITDETAILS }
     */
    public void setCommitAudit(AUDITDETAILS value) {
        this.commitAudit = value;
    }

    /**
     * Gets the value of the signature property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getSignature() {
        return signature;
    }

    /**
     * Sets the value of the signature property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setSignature(String value) {
        this.signature = value;
    }

}
