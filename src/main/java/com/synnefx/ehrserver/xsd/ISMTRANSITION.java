package com.synnefx.ehrserver.xsd;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ISM_TRANSITION complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="ISM_TRANSITION">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="current_state" type="{http://schemas.openehr.org/v1}DV_CODED_TEXT"/>
 *         &lt;element name="transition" type="{http://schemas.openehr.org/v1}DV_CODED_TEXT" minOccurs="0"/>
 *         &lt;element name="careflow_step" type="{http://schemas.openehr.org/v1}DV_CODED_TEXT" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ISM_TRANSITION", propOrder = {
        "currentState",
        "transition",
        "careflowStep"
})
public class ISMTRANSITION {

    @XmlElement(name = "current_state", required = true)
    protected DVCODEDTEXT currentState;
    protected DVCODEDTEXT transition;
    @XmlElement(name = "careflow_step")
    protected DVCODEDTEXT careflowStep;

    /**
     * Gets the value of the currentState property.
     *
     * @return possible object is
     * {@link DVCODEDTEXT }
     */
    public DVCODEDTEXT getCurrentState() {
        return currentState;
    }

    /**
     * Sets the value of the currentState property.
     *
     * @param value allowed object is
     *              {@link DVCODEDTEXT }
     */
    public void setCurrentState(DVCODEDTEXT value) {
        this.currentState = value;
    }

    /**
     * Gets the value of the transition property.
     *
     * @return possible object is
     * {@link DVCODEDTEXT }
     */
    public DVCODEDTEXT getTransition() {
        return transition;
    }

    /**
     * Sets the value of the transition property.
     *
     * @param value allowed object is
     *              {@link DVCODEDTEXT }
     */
    public void setTransition(DVCODEDTEXT value) {
        this.transition = value;
    }

    /**
     * Gets the value of the careflowStep property.
     *
     * @return possible object is
     * {@link DVCODEDTEXT }
     */
    public DVCODEDTEXT getCareflowStep() {
        return careflowStep;
    }

    /**
     * Sets the value of the careflowStep property.
     *
     * @param value allowed object is
     *              {@link DVCODEDTEXT }
     */
    public void setCareflowStep(DVCODEDTEXT value) {
        this.careflowStep = value;
    }

}
