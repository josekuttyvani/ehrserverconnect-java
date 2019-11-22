package com.synnefx.ehrserver.xsd;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for DV_PARAGRAPH complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="DV_PARAGRAPH">
 *   &lt;complexContent>
 *     &lt;extension base="{http://schemas.openehr.org/v1}DATA_VALUE">
 *       &lt;sequence>
 *         &lt;element name="items" type="{http://schemas.openehr.org/v1}DV_TEXT" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DV_PARAGRAPH", propOrder = {
        "items"
})
public class DVPARAGRAPH
        extends DATAVALUE {

    @XmlElement(required = true)
    protected List<DVTEXT> items;

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
     * {@link DVTEXT }
     */
    public List<DVTEXT> getItems() {
        if (items == null) {
            items = new ArrayList<DVTEXT>();
        }
        return this.items;
    }

}
