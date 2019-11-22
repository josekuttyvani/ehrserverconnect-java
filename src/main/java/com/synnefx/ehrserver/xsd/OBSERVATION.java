package com.synnefx.ehrserver.xsd;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for OBSERVATION complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="OBSERVATION">
 *   &lt;complexContent>
 *     &lt;extension base="{http://schemas.openehr.org/v1}CARE_ENTRY">
 *       &lt;sequence>
 *         &lt;element name="data" type="{http://schemas.openehr.org/v1}HISTORY"/>
 *         &lt;element name="state" type="{http://schemas.openehr.org/v1}HISTORY" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OBSERVATION", propOrder = {
        "data",
        "state"
})
public class OBSERVATION
        extends CAREENTRY {

    @XmlElement(required = true)
    protected HISTORY data;
    protected HISTORY state;

    /**
     * Gets the value of the data property.
     *
     * @return possible object is
     * {@link HISTORY }
     */
    public HISTORY getData() {
        return data;
    }

    /**
     * Sets the value of the data property.
     *
     * @param value allowed object is
     *              {@link HISTORY }
     */
    public void setData(HISTORY value) {
        this.data = value;
    }

    /**
     * Gets the value of the state property.
     *
     * @return possible object is
     * {@link HISTORY }
     */
    public HISTORY getState() {
        return state;
    }

    /**
     * Sets the value of the state property.
     *
     * @param value allowed object is
     *              {@link HISTORY }
     */
    public void setState(HISTORY value) {
        this.state = value;
    }

}
