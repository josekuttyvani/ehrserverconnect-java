package com.synnefx.ehrserver.xsd;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ITEM_SINGLE complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="ITEM_SINGLE">
 *   &lt;complexContent>
 *     &lt;extension base="{http://schemas.openehr.org/v1}ITEM_STRUCTURE">
 *       &lt;sequence>
 *         &lt;element name="item" type="{http://schemas.openehr.org/v1}ELEMENT"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ITEM_SINGLE", propOrder = {
        "item"
})
public class ITEMSINGLE
        extends ITEMSTRUCTURE {

    @XmlElement(required = true)
    protected ELEMENT item;

    /**
     * Gets the value of the item property.
     *
     * @return possible object is
     * {@link ELEMENT }
     */
    public ELEMENT getItem() {
        return item;
    }

    /**
     * Sets the value of the item property.
     *
     * @param value allowed object is
     *              {@link ELEMENT }
     */
    public void setItem(ELEMENT value) {
        this.item = value;
    }

}
