package com.synnefx.ehrserver.xsd;

import javax.xml.bind.annotation.*;


/**
 * <p>Java class for DV_TIME_SPECIFICATION complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="DV_TIME_SPECIFICATION">
 *   &lt;complexContent>
 *     &lt;extension base="{http://schemas.openehr.org/v1}DATA_VALUE">
 *       &lt;sequence>
 *         &lt;element name="value" type="{http://schemas.openehr.org/v1}DV_PARSABLE"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DV_TIME_SPECIFICATION", propOrder = {
        "value"
})
@XmlSeeAlso({
        DVGENERALTIMESPECIFICATION.class,
        DVPERIODICTIMESPECIFICATION.class
})
public abstract class DVTIMESPECIFICATION
        extends DATAVALUE {

    @XmlElement(required = true)
    protected DVPARSABLE value;

    /**
     * Gets the value of the value property.
     *
     * @return possible object is
     * {@link DVPARSABLE }
     */
    public DVPARSABLE getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     *
     * @param value allowed object is
     *              {@link DVPARSABLE }
     */
    public void setValue(DVPARSABLE value) {
        this.value = value;
    }

}
