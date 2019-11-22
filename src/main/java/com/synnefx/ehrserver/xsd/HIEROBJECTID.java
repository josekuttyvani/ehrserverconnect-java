package com.synnefx.ehrserver.xsd;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for HIER_OBJECT_ID complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="HIER_OBJECT_ID">
 *   &lt;complexContent>
 *     &lt;extension base="{http://schemas.openehr.org/v1}UID_BASED_ID">
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HIER_OBJECT_ID")
public class HIEROBJECTID
        extends UIDBASEDID {


}
