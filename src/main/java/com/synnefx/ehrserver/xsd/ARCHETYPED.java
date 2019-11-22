package com.synnefx.ehrserver.xsd;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ARCHETYPED complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="ARCHETYPED">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="archetype_id" type="{http://schemas.openehr.org/v1}ARCHETYPE_ID"/>
 *         &lt;element name="template_id" type="{http://schemas.openehr.org/v1}TEMPLATE_ID" minOccurs="0"/>
 *         &lt;element name="rm_version" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ARCHETYPED", propOrder = {
        "archetypeId",
        "templateId",
        "rmVersion"
})
public class ARCHETYPED {

    @XmlElement(name = "archetype_id", required = true)
    protected ARCHETYPEID archetypeId;
    @XmlElement(name = "template_id")
    protected TEMPLATEID templateId;
    @XmlElement(name = "rm_version", required = true)
    protected String rmVersion;

    /**
     * Gets the value of the archetypeId property.
     *
     * @return possible object is
     * {@link ARCHETYPEID }
     */
    public ARCHETYPEID getArchetypeId() {
        return archetypeId;
    }

    /**
     * Sets the value of the archetypeId property.
     *
     * @param value allowed object is
     *              {@link ARCHETYPEID }
     */
    public void setArchetypeId(ARCHETYPEID value) {
        this.archetypeId = value;
    }

    /**
     * Gets the value of the templateId property.
     *
     * @return possible object is
     * {@link TEMPLATEID }
     */
    public TEMPLATEID getTemplateId() {
        return templateId;
    }

    /**
     * Sets the value of the templateId property.
     *
     * @param value allowed object is
     *              {@link TEMPLATEID }
     */
    public void setTemplateId(TEMPLATEID value) {
        this.templateId = value;
    }

    /**
     * Gets the value of the rmVersion property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getRmVersion() {
        return rmVersion;
    }

    /**
     * Sets the value of the rmVersion property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setRmVersion(String value) {
        this.rmVersion = value;
    }

}
