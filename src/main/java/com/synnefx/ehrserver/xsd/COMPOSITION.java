package com.synnefx.ehrserver.xsd;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for COMPOSITION complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="COMPOSITION">
 *   &lt;complexContent>
 *     &lt;extension base="{http://schemas.openehr.org/v1}LOCATABLE">
 *       &lt;sequence>
 *         &lt;element name="language" type="{http://schemas.openehr.org/v1}CODE_PHRASE"/>
 *         &lt;element name="territory" type="{http://schemas.openehr.org/v1}CODE_PHRASE"/>
 *         &lt;element name="category" type="{http://schemas.openehr.org/v1}DV_CODED_TEXT"/>
 *         &lt;element name="composer" type="{http://schemas.openehr.org/v1}PARTY_PROXY"/>
 *         &lt;element name="context" type="{http://schemas.openehr.org/v1}EVENT_CONTEXT" minOccurs="0"/>
 *         &lt;element name="content" type="{http://schemas.openehr.org/v1}CONTENT_ITEM" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "COMPOSITION", propOrder = {
        "language",
        "territory",
        "category",
        "composer",
        "context",
        "content"
})
public class COMPOSITION
        extends LOCATABLE {

    @XmlElement(required = true)
    protected CODEPHRASE language;
    @XmlElement(required = true)
    protected CODEPHRASE territory;
    @XmlElement(required = true)
    protected DVCODEDTEXT category;
    @XmlElement(required = true)
    protected PARTYPROXY composer;
    protected EVENTCONTEXT context;
    protected List<CONTENTITEM> content;

    /**
     * Gets the value of the language property.
     *
     * @return possible object is
     * {@link CODEPHRASE }
     */
    public CODEPHRASE getLanguage() {
        return language;
    }

    /**
     * Sets the value of the language property.
     *
     * @param value allowed object is
     *              {@link CODEPHRASE }
     */
    public void setLanguage(CODEPHRASE value) {
        this.language = value;
    }

    /**
     * Gets the value of the territory property.
     *
     * @return possible object is
     * {@link CODEPHRASE }
     */
    public CODEPHRASE getTerritory() {
        return territory;
    }

    /**
     * Sets the value of the territory property.
     *
     * @param value allowed object is
     *              {@link CODEPHRASE }
     */
    public void setTerritory(CODEPHRASE value) {
        this.territory = value;
    }

    /**
     * Gets the value of the category property.
     *
     * @return possible object is
     * {@link DVCODEDTEXT }
     */
    public DVCODEDTEXT getCategory() {
        return category;
    }

    /**
     * Sets the value of the category property.
     *
     * @param value allowed object is
     *              {@link DVCODEDTEXT }
     */
    public void setCategory(DVCODEDTEXT value) {
        this.category = value;
    }

    /**
     * Gets the value of the composer property.
     *
     * @return possible object is
     * {@link PARTYPROXY }
     */
    public PARTYPROXY getComposer() {
        return composer;
    }

    /**
     * Sets the value of the composer property.
     *
     * @param value allowed object is
     *              {@link PARTYPROXY }
     */
    public void setComposer(PARTYPROXY value) {
        this.composer = value;
    }

    /**
     * Gets the value of the context property.
     *
     * @return possible object is
     * {@link EVENTCONTEXT }
     */
    public EVENTCONTEXT getContext() {
        return context;
    }

    /**
     * Sets the value of the context property.
     *
     * @param value allowed object is
     *              {@link EVENTCONTEXT }
     */
    public void setContext(EVENTCONTEXT value) {
        this.context = value;
    }

    /**
     * Gets the value of the content property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the content property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getContent().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CONTENTITEM }
     */
    public List<CONTENTITEM> getContent() {
        if (content == null) {
            content = new ArrayList<CONTENTITEM>();
        }
        return this.content;
    }

}
