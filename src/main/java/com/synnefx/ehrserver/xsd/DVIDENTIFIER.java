package com.synnefx.ehrserver.xsd;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DV_IDENTIFIER complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="DV_IDENTIFIER">
 *   &lt;complexContent>
 *     &lt;extension base="{http://schemas.openehr.org/v1}DATA_VALUE">
 *       &lt;sequence>
 *         &lt;element name="issuer" type="{http://schemas.openehr.org/v1}NotEmptyString"/>
 *         &lt;element name="assigner" type="{http://schemas.openehr.org/v1}NotEmptyString"/>
 *         &lt;element name="id" type="{http://schemas.openehr.org/v1}NotEmptyString"/>
 *         &lt;element name="type" type="{http://schemas.openehr.org/v1}NotEmptyString"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DV_IDENTIFIER", propOrder = {
        "issuer",
        "assigner",
        "id",
        "type"
})
public class DVIDENTIFIER
        extends DATAVALUE {

    @XmlElement(required = true)
    protected String issuer;
    @XmlElement(required = true)
    protected String assigner;
    @XmlElement(required = true)
    protected String id;
    @XmlElement(required = true)
    protected String type;

    /**
     * Gets the value of the issuer property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getIssuer() {
        return issuer;
    }

    /**
     * Sets the value of the issuer property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setIssuer(String value) {
        this.issuer = value;
    }

    /**
     * Gets the value of the assigner property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getAssigner() {
        return assigner;
    }

    /**
     * Sets the value of the assigner property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setAssigner(String value) {
        this.assigner = value;
    }

    /**
     * Gets the value of the id property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setId(String value) {
        this.id = value;
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
