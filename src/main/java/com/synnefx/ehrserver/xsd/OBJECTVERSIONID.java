package com.synnefx.ehrserver.xsd;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for OBJECT_VERSION_ID complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="OBJECT_VERSION_ID">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://schemas.openehr.org/v1}UID_BASED_ID">
 *       &lt;sequence>
 *         &lt;element name="value" type="{http://schemas.openehr.org/v1}OBJECT_VERSION_ID_VALUE_FORMAT"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OBJECT_VERSION_ID")
public class OBJECTVERSIONID
        extends UIDBASEDID {


}
