package com.synnefx.ehrserver.xsd;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for DV_TEXT complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="DV_TEXT">
 *   &lt;complexContent>
 *     &lt;extension base="{http://schemas.openehr.org/v1}DATA_VALUE">
 *       &lt;sequence>
 *         &lt;element name="value" type="{http://schemas.openehr.org/v1}NotEmptyString"/>
 *         &lt;element name="hyperlink" type="{http://schemas.openehr.org/v1}DV_URI" minOccurs="0"/>
 *         &lt;element name="formatting" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="mappings" type="{http://schemas.openehr.org/v1}TERM_MAPPING" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="language" type="{http://schemas.openehr.org/v1}CODE_PHRASE" minOccurs="0"/>
 *         &lt;element name="encoding" type="{http://schemas.openehr.org/v1}CODE_PHRASE" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DV_TEXT", propOrder = {
        "value",
        "hyperlink",
        "formatting",
        "mappings",
        "language",
        "encoding"
})
@XmlSeeAlso({
        DVCODEDTEXT.class
})
public class DVTEXT
        extends DATAVALUE {

    @XmlElement(required = true)
    protected String value;
    protected DVURI hyperlink;
    protected String formatting;
    protected List<TERMMAPPING> mappings;
    protected CODEPHRASE language;
    protected CODEPHRASE encoding;

    /**
     * Gets the value of the value property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * Gets the value of the hyperlink property.
     *
     * @return possible object is
     * {@link DVURI }
     */
    public DVURI getHyperlink() {
        return hyperlink;
    }

    /**
     * Sets the value of the hyperlink property.
     *
     * @param value allowed object is
     *              {@link DVURI }
     */
    public void setHyperlink(DVURI value) {
        this.hyperlink = value;
    }

    /**
     * Gets the value of the formatting property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getFormatting() {
        return formatting;
    }

    /**
     * Sets the value of the formatting property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setFormatting(String value) {
        this.formatting = value;
    }

    /**
     * Gets the value of the mappings property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the mappings property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMappings().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TERMMAPPING }
     */
    public List<TERMMAPPING> getMappings() {
        if (mappings == null) {
            mappings = new ArrayList<TERMMAPPING>();
        }
        return this.mappings;
    }

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
     * Gets the value of the encoding property.
     *
     * @return possible object is
     * {@link CODEPHRASE }
     */
    public CODEPHRASE getEncoding() {
        return encoding;
    }

    /**
     * Sets the value of the encoding property.
     *
     * @param value allowed object is
     *              {@link CODEPHRASE }
     */
    public void setEncoding(CODEPHRASE value) {
        this.encoding = value;
    }

}
