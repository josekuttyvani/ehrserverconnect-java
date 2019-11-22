package com.synnefx.ehrserver.xsd;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DV_STATE complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="DV_STATE">
 *   &lt;complexContent>
 *     &lt;extension base="{http://schemas.openehr.org/v1}DATA_VALUE">
 *       &lt;sequence>
 *         &lt;element name="value" type="{http://schemas.openehr.org/v1}DV_CODED_TEXT"/>
 *         &lt;element name="is_terminal" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DV_STATE", propOrder = {
        "value",
        "isTerminal"
})
public class DVSTATE
        extends DATAVALUE {

    @XmlElement(required = true)
    protected DVCODEDTEXT value;
    @XmlElement(name = "is_terminal")
    protected boolean isTerminal;

    /**
     * Gets the value of the value property.
     *
     * @return possible object is
     * {@link DVCODEDTEXT }
     */
    public DVCODEDTEXT getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     *
     * @param value allowed object is
     *              {@link DVCODEDTEXT }
     */
    public void setValue(DVCODEDTEXT value) {
        this.value = value;
    }

    /**
     * Gets the value of the isTerminal property.
     */
    public boolean isIsTerminal() {
        return isTerminal;
    }

    /**
     * Sets the value of the isTerminal property.
     */
    public void setIsTerminal(boolean value) {
        this.isTerminal = value;
    }

}
