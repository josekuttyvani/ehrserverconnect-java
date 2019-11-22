package com.synnefx.ehrserver.xsd;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DV_PARSABLE complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="DV_PARSABLE">
 *   &lt;complexContent>
 *     &lt;extension base="{http://schemas.openehr.org/v1}DV_ENCAPSULATED">
 *       &lt;sequence>
 *         &lt;element name="value" type="{http://schemas.openehr.org/v1}NotEmptyString"/>
 *         &lt;element name="formalism">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://schemas.openehr.org/v1}NotEmptyString">
 *               &lt;enumeration value="text/xml"/>
 *               &lt;enumeration value="text/rtf"/>
 *               &lt;enumeration value="text/plain"/>
 *               &lt;enumeration value="text/html"/>
 *               &lt;enumeration value="application/json"/>
 *               &lt;enumeration value="ISO8601"/>
 *               &lt;enumeration value="HL7_GTS"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DV_PARSABLE", propOrder = {
        "value",
        "formalism"
})
public class DVPARSABLE
        extends DVENCAPSULATED {

    @XmlElement(required = true)
    protected String value;
    @XmlElement(required = true)
    protected String formalism;

    /**
     * Gets the value of the value property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * Gets the value of the formalism property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getFormalism() {
        return formalism;
    }

    /**
     * Sets the value of the formalism property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setFormalism(String value) {
        this.formalism = value;
    }

}
