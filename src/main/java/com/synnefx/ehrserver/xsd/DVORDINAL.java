package com.synnefx.ehrserver.xsd;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DV_ORDINAL complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="DV_ORDINAL">
 *   &lt;complexContent>
 *     &lt;extension base="{http://schemas.openehr.org/v1}DV_ORDERED">
 *       &lt;sequence>
 *         &lt;element name="value" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="symbol" type="{http://schemas.openehr.org/v1}DV_CODED_TEXT"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DV_ORDINAL", propOrder = {
        "value",
        "symbol"
})
public class DVORDINAL
        extends DVORDERED {

    protected int value;
    @XmlElement(required = true)
    protected DVCODEDTEXT symbol;

    /**
     * Gets the value of the value property.
     */
    public int getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     */
    public void setValue(int value) {
        this.value = value;
    }

    /**
     * Gets the value of the symbol property.
     *
     * @return possible object is
     * {@link DVCODEDTEXT }
     */
    public DVCODEDTEXT getSymbol() {
        return symbol;
    }

    /**
     * Sets the value of the symbol property.
     *
     * @param value allowed object is
     *              {@link DVCODEDTEXT }
     */
    public void setSymbol(DVCODEDTEXT value) {
        this.symbol = value;
    }

}
