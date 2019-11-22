package com.synnefx.ehrserver.xsd;

import javax.xml.bind.annotation.*;


/**
 * <p>Java class for EVENT complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="EVENT">
 *   &lt;complexContent>
 *     &lt;extension base="{http://schemas.openehr.org/v1}LOCATABLE">
 *       &lt;sequence>
 *         &lt;element name="time" type="{http://schemas.openehr.org/v1}DV_DATE_TIME"/>
 *         &lt;element name="data" type="{http://schemas.openehr.org/v1}ITEM_STRUCTURE"/>
 *         &lt;element name="state" type="{http://schemas.openehr.org/v1}ITEM_STRUCTURE" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EVENT", propOrder = {
        "time",
        "data",
        "state"
})
@XmlSeeAlso({
        POINTEVENT.class,
        INTERVALEVENT.class
})
public abstract class EVENT
        extends LOCATABLE {

    @XmlElement(required = true)
    protected DVDATETIME time;
    @XmlElement(required = true)
    protected ITEMSTRUCTURE data;
    protected ITEMSTRUCTURE state;

    /**
     * Gets the value of the time property.
     *
     * @return possible object is
     * {@link DVDATETIME }
     */
    public DVDATETIME getTime() {
        return time;
    }

    /**
     * Sets the value of the time property.
     *
     * @param value allowed object is
     *              {@link DVDATETIME }
     */
    public void setTime(DVDATETIME value) {
        this.time = value;
    }

    /**
     * Gets the value of the data property.
     *
     * @return possible object is
     * {@link ITEMSTRUCTURE }
     */
    public ITEMSTRUCTURE getData() {
        return data;
    }

    /**
     * Sets the value of the data property.
     *
     * @param value allowed object is
     *              {@link ITEMSTRUCTURE }
     */
    public void setData(ITEMSTRUCTURE value) {
        this.data = value;
    }

    /**
     * Gets the value of the state property.
     *
     * @return possible object is
     * {@link ITEMSTRUCTURE }
     */
    public ITEMSTRUCTURE getState() {
        return state;
    }

    /**
     * Sets the value of the state property.
     *
     * @param value allowed object is
     *              {@link ITEMSTRUCTURE }
     */
    public void setState(ITEMSTRUCTURE value) {
        this.state = value;
    }

}
