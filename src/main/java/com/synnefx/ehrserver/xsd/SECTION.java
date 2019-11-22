package com.synnefx.ehrserver.xsd;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for SECTION complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="SECTION">
 *   &lt;complexContent>
 *     &lt;extension base="{http://schemas.openehr.org/v1}CONTENT_ITEM">
 *       &lt;sequence>
 *         &lt;element name="items" type="{http://schemas.openehr.org/v1}CONTENT_ITEM" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SECTION", propOrder = {
        "items"
})
public class SECTION
        extends CONTENTITEM {

    protected List<CONTENTITEM> items;

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
     * {@link CONTENTITEM }
     */
    public List<CONTENTITEM> getItems() {
        if (items == null) {
            items = new ArrayList<CONTENTITEM>();
        }
        return this.items;
    }

}
