package com.synnefx.ehrserver.xsd;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ELEMENT complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="ELEMENT">
 *   &lt;complexContent>
 *     &lt;extension base="{http://schemas.openehr.org/v1}ITEM">
 *       &lt;sequence>
 *         &lt;element name="value" type="{http://schemas.openehr.org/v1}DATA_VALUE" minOccurs="0"/>
 *         &lt;element name="null_flavour" type="{http://schemas.openehr.org/v1}DV_CODED_TEXT" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ELEMENT", propOrder = {
        "value",
        "nullFlavour"
})
public class ELEMENT
        extends ITEM {

    protected DATAVALUE value;
    @XmlElement(name = "null_flavour")
    protected DVCODEDTEXT nullFlavour;

    /**
     * Gets the value of the value property.
     *
     * @return possible object is
     * {@link DATAVALUE }
     */
    public DATAVALUE getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     *
     * @param value allowed object is
     *              {@link DATAVALUE }
     */
    public void setValue(DATAVALUE value) {
        this.value = value;
    }

    /**
     * Gets the value of the nullFlavour property.
     *
     * @return possible object is
     * {@link DVCODEDTEXT }
     */
    public DVCODEDTEXT getNullFlavour() {
        return nullFlavour;
    }

    /**
     * Sets the value of the nullFlavour property.
     *
     * @param value allowed object is
     *              {@link DVCODEDTEXT }
     */
    public void setNullFlavour(DVCODEDTEXT value) {
        this.nullFlavour = value;
    }

}
