package com.synnefx.ehrserver.xsd;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ADMIN_ENTRY complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="ADMIN_ENTRY">
 *   &lt;complexContent>
 *     &lt;extension base="{http://schemas.openehr.org/v1}ENTRY">
 *       &lt;sequence>
 *         &lt;element name="data" type="{http://schemas.openehr.org/v1}ITEM_STRUCTURE"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ADMIN_ENTRY", propOrder = {
        "data"
})
public class ADMINENTRY
        extends ENTRY {

    @XmlElement(required = true)
    protected ITEMSTRUCTURE data;

    /**
     * Gets the value of the data property.
     *
     * @return possible object is
     * {@link ITEMSTRUCTURE }
     */
    public ITEMSTRUCTURE getData() {
        return data;
    }

    /**
     * Sets the value of the data property.
     *
     * @param value allowed object is
     *              {@link ITEMSTRUCTURE }
     */
    public void setData(ITEMSTRUCTURE value) {
        this.data = value;
    }

}
