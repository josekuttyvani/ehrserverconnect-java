package com.synnefx.ehrserver.xsd;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TEMPLATE_ID complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="TEMPLATE_ID">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://schemas.openehr.org/v1}OBJECT_ID">
 *       &lt;sequence>
 *         &lt;element name="value" type="{http://schemas.openehr.org/v1}TEMPLATE_ID_VALUE_FORMAT"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TEMPLATE_ID")
public class TEMPLATEID
        extends OBJECTID {


}
