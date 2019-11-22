package com.synnefx.ehrserver.xsd;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GENERIC_ENTRY complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="GENERIC_ENTRY">
 *   &lt;complexContent>
 *     &lt;extension base="{http://schemas.openehr.org/v1}CONTENT_ITEM">
 *       &lt;sequence>
 *         &lt;element name="data" type="{http://schemas.openehr.org/v1}ITEM_TREE"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GENERIC_ENTRY", propOrder = {
        "data"
})
public class GENERICENTRY
        extends CONTENTITEM {

    @XmlElement(required = true)
    protected ITEMTREE data;

    /**
     * Gets the value of the data property.
     *
     * @return possible object is
     * {@link ITEMTREE }
     */
    public ITEMTREE getData() {
        return data;
    }

    /**
     * Sets the value of the data property.
     *
     * @param value allowed object is
     *              {@link ITEMTREE }
     */
    public void setData(ITEMTREE value) {
        this.data = value;
    }

}
