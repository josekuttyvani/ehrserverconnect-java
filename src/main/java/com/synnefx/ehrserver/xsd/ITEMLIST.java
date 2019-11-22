package com.synnefx.ehrserver.xsd;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for ITEM_LIST complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="ITEM_LIST">
 *   &lt;complexContent>
 *     &lt;extension base="{http://schemas.openehr.org/v1}ITEM_STRUCTURE">
 *       &lt;sequence>
 *         &lt;element name="items" type="{http://schemas.openehr.org/v1}ELEMENT" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ITEM_LIST", propOrder = {
        "items"
})
public class ITEMLIST
        extends ITEMSTRUCTURE {

    protected List<ELEMENT> items;

    /**
     * Gets the value of the items property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the items property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getItems().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ELEMENT }
     */
    public List<ELEMENT> getItems() {
        if (items == null) {
            items = new ArrayList<ELEMENT>();
        }
        return this.items;
    }

}
