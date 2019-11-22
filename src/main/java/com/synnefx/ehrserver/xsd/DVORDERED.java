package com.synnefx.ehrserver.xsd;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for DV_ORDERED complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="DV_ORDERED">
 *   &lt;complexContent>
 *     &lt;extension base="{http://schemas.openehr.org/v1}DATA_VALUE">
 *       &lt;sequence>
 *         &lt;element name="normal_range" type="{http://schemas.openehr.org/v1}DV_INTERVAL" minOccurs="0"/>
 *         &lt;element name="other_reference_ranges" type="{http://schemas.openehr.org/v1}REFERENCE_RANGE" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="normal_status" type="{http://schemas.openehr.org/v1}CODE_PHRASE" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DV_ORDERED", propOrder = {
        "normalRange",
        "otherReferenceRanges",
        "normalStatus"
})
@XmlSeeAlso({
        DVORDINAL.class,
        DVQUANTIFIED.class
})
public abstract class DVORDERED
        extends DATAVALUE {

    @XmlElement(name = "normal_range")
    protected DVINTERVAL normalRange;
    @XmlElement(name = "other_reference_ranges")
    protected List<REFERENCERANGE> otherReferenceRanges;
    @XmlElement(name = "normal_status")
    protected CODEPHRASE normalStatus;

    /**
     * Gets the value of the normalRange property.
     *
     * @return possible object is
     * {@link DVINTERVAL }
     */
    public DVINTERVAL getNormalRange() {
        return normalRange;
    }

    /**
     * Sets the value of the normalRange property.
     *
     * @param value allowed object is
     *              {@link DVINTERVAL }
     */
    public void setNormalRange(DVINTERVAL value) {
        this.normalRange = value;
    }

    /**
     * Gets the value of the otherReferenceRanges property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the otherReferenceRanges property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOtherReferenceRanges().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link REFERENCERANGE }
     */
    public List<REFERENCERANGE> getOtherReferenceRanges() {
        if (otherReferenceRanges == null) {
            otherReferenceRanges = new ArrayList<REFERENCERANGE>();
        }
        return this.otherReferenceRanges;
    }

    /**
     * Gets the value of the normalStatus property.
     *
     * @return possible object is
     * {@link CODEPHRASE }
     */
    public CODEPHRASE getNormalStatus() {
        return normalStatus;
    }

    /**
     * Sets the value of the normalStatus property.
     *
     * @param value allowed object is
     *              {@link CODEPHRASE }
     */
    public void setNormalStatus(CODEPHRASE value) {
        this.normalStatus = value;
    }

}
