package com.synnefx.ehrserver.xsd;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ITEM_STRUCTURE complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="ITEM_STRUCTURE">
 *   &lt;complexContent>
 *     &lt;extension base="{http://schemas.openehr.org/v1}LOCATABLE">
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ITEM_STRUCTURE")
@XmlSeeAlso({
        ITEMSINGLE.class,
        ITEMTREE.class,
        ITEMLIST.class,
        ITEMTABLE.class
})
public abstract class ITEMSTRUCTURE
        extends LOCATABLE {


}
