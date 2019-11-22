package com.synnefx.ehrserver.xsd;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for INTERVAL_EVENT complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="INTERVAL_EVENT">
 *   &lt;complexContent>
 *     &lt;extension base="{http://schemas.openehr.org/v1}EVENT">
 *       &lt;sequence>
 *         &lt;element name="width" type="{http://schemas.openehr.org/v1}DV_DURATION"/>
 *         &lt;element name="sample_count" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="math_function" type="{http://schemas.openehr.org/v1}DV_CODED_TEXT"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "INTERVAL_EVENT", propOrder = {
        "width",
        "sampleCount",
        "mathFunction"
})
public class INTERVALEVENT
        extends EVENT {

    @XmlElement(required = true)
    protected DVDURATION width;
    @XmlElement(name = "sample_count")
    protected Integer sampleCount;
    @XmlElement(name = "math_function", required = true)
    protected DVCODEDTEXT mathFunction;

    /**
     * Gets the value of the width property.
     *
     * @return possible object is
     * {@link DVDURATION }
     */
    public DVDURATION getWidth() {
        return width;
    }

    /**
     * Sets the value of the width property.
     *
     * @param value allowed object is
     *              {@link DVDURATION }
     */
    public void setWidth(DVDURATION value) {
        this.width = value;
    }

    /**
     * Gets the value of the sampleCount property.
     *
     * @return possible object is
     * {@link Integer }
     */
    public Integer getSampleCount() {
        return sampleCount;
    }

    /**
     * Sets the value of the sampleCount property.
     *
     * @param value allowed object is
     *              {@link Integer }
     */
    public void setSampleCount(Integer value) {
        this.sampleCount = value;
    }

    /**
     * Gets the value of the mathFunction property.
     *
     * @return possible object is
     * {@link DVCODEDTEXT }
     */
    public DVCODEDTEXT getMathFunction() {
        return mathFunction;
    }

    /**
     * Sets the value of the mathFunction property.
     *
     * @param value allowed object is
     *              {@link DVCODEDTEXT }
     */
    public void setMathFunction(DVCODEDTEXT value) {
        this.mathFunction = value;
    }

}
