package com.synnefx.ehrserver.xsd;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java class for OBJECT_REF complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="OBJECT_REF">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://schemas.openehr.org/v1}OBJECT_ID"/>
 *         &lt;element name="namespace" type="{http://schemas.openehr.org/v1}NotEmptyToken"/>
 *         &lt;element name="type" type="{http://schemas.openehr.org/v1}NotEmptyToken"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OBJECT_REF", propOrder = {
        "id",
        "namespace",
        "type"
})
@XmlSeeAlso({
        LOCATABLEREF.class,
        PARTYREF.class,
        ACCESSGROUPREF.class
})
public class OBJECTREF {

    @XmlElement(required = true)
    protected OBJECTID id;
    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String namespace;
    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String type;

    /**
     * Gets the value of the id property.
     *
     * @return possible object is
     * {@link OBJECTID }
     */
    public OBJECTID getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     *
     * @param value allowed object is
     *              {@link OBJECTID }
     */
    public void setId(OBJECTID value) {
        this.id = value;
    }

    /**
     * Gets the value of the namespace property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getNamespace() {
        return namespace;
    }

    /**
     * Sets the value of the namespace property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setNamespace(String value) {
        this.namespace = value;
    }

    /**
     * Gets the value of the type property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setType(String value) {
        this.type = value;
    }

}
