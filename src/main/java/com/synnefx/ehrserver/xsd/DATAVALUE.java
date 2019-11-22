package com.synnefx.ehrserver.xsd;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DATA_VALUE complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="DATA_VALUE">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DATA_VALUE")
@XmlSeeAlso({
        DVPARAGRAPH.class,
        DVSTATE.class,
        DVTIMESPECIFICATION.class,
        DVINTERVAL.class,
        DVENCAPSULATED.class,
        DVIDENTIFIER.class,
        DVORDERED.class,
        DVBOOLEAN.class,
        DVURI.class,
        DVTEXT.class
})
public abstract class DATAVALUE {


}
