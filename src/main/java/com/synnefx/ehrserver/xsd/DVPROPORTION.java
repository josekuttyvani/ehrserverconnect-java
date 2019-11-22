package com.synnefx.ehrserver.xsd;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.math.BigInteger;


/**
 * <p>Java class for DV_PROPORTION complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="DV_PROPORTION">
 *   &lt;complexContent>
 *     &lt;extension base="{http://schemas.openehr.org/v1}DV_AMOUNT">
 *       &lt;sequence>
 *         &lt;element name="numerator" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="denominator" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="type" type="{http://schemas.openehr.org/v1}PROPORTION_KIND"/>
 *         &lt;element name="precision" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DV_PROPORTION", propOrder = {
        "numerator",
        "denominator",
        "type",
        "precision"
})
public class DVPROPORTION
        extends DVAMOUNT {

    protected float numerator;
    protected float denominator;
    @XmlElement(required = true)
    protected BigInteger type;
    @XmlElement(defaultValue = "-1")
    protected Integer precision;

    /**
     * Gets the value of the numerator property.
     */
    public float getNumerator() {
        return numerator;
    }

    /**
     * Sets the value of the numerator property.
     */
    public void setNumerator(float value) {
        this.numerator = value;
    }

    /**
     * Gets the value of the denominator property.
     */
    public float getDenominator() {
        return denominator;
    }

    /**
     * Sets the value of the denominator property.
     */
    public void setDenominator(float value) {
        this.denominator = value;
    }

    /**
     * Gets the value of the type property.
     *
     * @return possible object is
     * {@link BigInteger }
     */
    public BigInteger getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     *
     * @param value allowed object is
     *              {@link BigInteger }
     */
    public void setType(BigInteger value) {
        this.type = value;
    }

    /**
     * Gets the value of the precision property.
     *
     * @return possible object is
     * {@link Integer }
     */
    public Integer getPrecision() {
        return precision;
    }

    /**
     * Sets the value of the precision property.
     *
     * @param value allowed object is
     *              {@link Integer }
     */
    public void setPrecision(Integer value) {
        this.precision = value;
    }

}
