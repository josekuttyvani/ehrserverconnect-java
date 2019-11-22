package com.synnefx.ehrserver.xsd;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DV_CODED_TEXT complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="DV_CODED_TEXT">
 *   &lt;complexContent>
 *     &lt;extension base="{http://schemas.openehr.org/v1}DV_TEXT">
 *       &lt;sequence>
 *         &lt;element name="defining_code" type="{http://schemas.openehr.org/v1}CODE_PHRASE"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DV_CODED_TEXT", propOrder = {
        "definingCode"
})
public class DVCODEDTEXT
        extends DVTEXT {

    @XmlElement(name = "defining_code", required = true)
    protected CODEPHRASE definingCode;

    /**
     * Gets the value of the definingCode property.
     *
     * @return possible object is
     * {@link CODEPHRASE }
     */
    public CODEPHRASE getDefiningCode() {
        return definingCode;
    }

    /**
     * Sets the value of the definingCode property.
     *
     * @param value allowed object is
     *              {@link CODEPHRASE }
     */
    public void setDefiningCode(CODEPHRASE value) {
        this.definingCode = value;
    }

}
