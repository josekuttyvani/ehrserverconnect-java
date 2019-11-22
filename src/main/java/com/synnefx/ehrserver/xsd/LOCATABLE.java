package com.synnefx.ehrserver.xsd;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for LOCATABLE complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="LOCATABLE">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="name" type="{http://schemas.openehr.org/v1}DV_TEXT"/>
 *         &lt;element name="uid" type="{http://schemas.openehr.org/v1}UID_BASED_ID" minOccurs="0"/>
 *         &lt;element name="links" type="{http://schemas.openehr.org/v1}LINK" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="archetype_details" type="{http://schemas.openehr.org/v1}ARCHETYPED" minOccurs="0"/>
 *         &lt;element name="feeder_audit" type="{http://schemas.openehr.org/v1}FEEDER_AUDIT" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="archetype_node_id" use="required" type="{http://schemas.openehr.org/v1}archetypeNodeId" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LOCATABLE", propOrder = {
        "name",
        "uid",
        "links",
        "archetypeDetails",
        "feederAudit"
})
@XmlSeeAlso({
        COMPOSITION.class,
        ITEM.class,
        HISTORY.class,
        FOLDER.class,
        EVENT.class,
        ITEMSTRUCTURE.class,
        CONTENTITEM.class,
        ACTIVITY.class
})
public abstract class LOCATABLE {

    @XmlElement(required = true)
    protected DVTEXT name;
    protected UIDBASEDID uid;
    protected List<LINK> links;
    @XmlElement(name = "archetype_details")
    protected ARCHETYPED archetypeDetails;
    @XmlElement(name = "feeder_audit")
    protected FEEDERAUDIT feederAudit;
    @XmlAttribute(name = "archetype_node_id", required = true)
    protected String archetypeNodeId;

    /**
     * Gets the value of the name property.
     *
     * @return possible object is
     * {@link DVTEXT }
     */
    public DVTEXT getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     *
     * @param value allowed object is
     *              {@link DVTEXT }
     */
    public void setName(DVTEXT value) {
        this.name = value;
    }

    /**
     * Gets the value of the uid property.
     *
     * @return possible object is
     * {@link UIDBASEDID }
     */
    public UIDBASEDID getUid() {
        return uid;
    }

    /**
     * Sets the value of the uid property.
     *
     * @param value allowed object is
     *              {@link UIDBASEDID }
     */
    public void setUid(UIDBASEDID value) {
        this.uid = value;
    }

    /**
     * Gets the value of the links property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the links property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLinks().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LINK }
     */
    public List<LINK> getLinks() {
        if (links == null) {
            links = new ArrayList<LINK>();
        }
        return this.links;
    }

    /**
     * Gets the value of the archetypeDetails property.
     *
     * @return possible object is
     * {@link ARCHETYPED }
     */
    public ARCHETYPED getArchetypeDetails() {
        return archetypeDetails;
    }

    /**
     * Sets the value of the archetypeDetails property.
     *
     * @param value allowed object is
     *              {@link ARCHETYPED }
     */
    public void setArchetypeDetails(ARCHETYPED value) {
        this.archetypeDetails = value;
    }

    /**
     * Gets the value of the feederAudit property.
     *
     * @return possible object is
     * {@link FEEDERAUDIT }
     */
    public FEEDERAUDIT getFeederAudit() {
        return feederAudit;
    }

    /**
     * Sets the value of the feederAudit property.
     *
     * @param value allowed object is
     *              {@link FEEDERAUDIT }
     */
    public void setFeederAudit(FEEDERAUDIT value) {
        this.feederAudit = value;
    }

    /**
     * Gets the value of the archetypeNodeId property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getArchetypeNodeId() {
        return archetypeNodeId;
    }

    /**
     * Sets the value of the archetypeNodeId property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setArchetypeNodeId(String value) {
        this.archetypeNodeId = value;
    }

}
