package com.synnefx.ehrserver.xsd;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for IMPORTED_VERSION complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="IMPORTED_VERSION">
 *   &lt;complexContent>
 *     &lt;extension base="{http://schemas.openehr.org/v1}VERSION">
 *       &lt;sequence>
 *         &lt;element name="item" type="{http://schemas.openehr.org/v1}ORIGINAL_VERSION"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IMPORTED_VERSION", propOrder = {
        "item"
})
public class IMPORTEDVERSION
        extends VERSION {

    @XmlElement(required = true)
    protected ORIGINALVERSION item;

    /**
     * Gets the value of the item property.
     *
     * @return possible object is
     * {@link ORIGINALVERSION }
     */
    public ORIGINALVERSION getItem() {
        return item;
    }

    /**
     * Sets the value of the item property.
     *
     * @param value allowed object is
     *              {@link ORIGINALVERSION }
     */
    public void setItem(ORIGINALVERSION value) {
        this.item = value;
    }

}
