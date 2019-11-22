package com.synnefx.ehrserver.xsd;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for REVISION_HISTORY_ITEM complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="REVISION_HISTORY_ITEM">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="version_id" type="{http://schemas.openehr.org/v1}OBJECT_VERSION_ID"/>
 *         &lt;element name="audits" type="{http://schemas.openehr.org/v1}AUDIT_DETAILS" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "REVISION_HISTORY_ITEM", propOrder = {
        "versionId",
        "audits"
})
public class REVISIONHISTORYITEM {

    @XmlElement(name = "version_id", required = true)
    protected OBJECTVERSIONID versionId;
    @XmlElement(required = true)
    protected List<AUDITDETAILS> audits;

    /**
     * Gets the value of the versionId property.
     *
     * @return possible object is
     * {@link OBJECTVERSIONID }
     */
    public OBJECTVERSIONID getVersionId() {
        return versionId;
    }

    /**
     * Sets the value of the versionId property.
     *
     * @param value allowed object is
     *              {@link OBJECTVERSIONID }
     */
    public void setVersionId(OBJECTVERSIONID value) {
        this.versionId = value;
    }

    /**
     * Gets the value of the audits property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the audits property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAudits().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AUDITDETAILS }
     */
    public List<AUDITDETAILS> getAudits() {
        if (audits == null) {
            audits = new ArrayList<AUDITDETAILS>();
        }
        return this.audits;
    }

}
