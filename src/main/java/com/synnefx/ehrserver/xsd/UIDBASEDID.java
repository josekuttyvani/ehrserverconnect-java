package com.synnefx.ehrserver.xsd;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for UID_BASED_ID complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="UID_BASED_ID">
 *   &lt;complexContent>
 *     &lt;extension base="{http://schemas.openehr.org/v1}OBJECT_ID">
 *       &lt;sequence>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UID_BASED_ID")
@XmlSeeAlso({
        OBJECTVERSIONID.class,
        HIEROBJECTID.class
})
public abstract class UIDBASEDID
        extends OBJECTID {


}
