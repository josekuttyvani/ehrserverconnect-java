package com.synnefx.ehrserver.xsd;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DV_MULTIMEDIA complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="DV_MULTIMEDIA">
 *   &lt;complexContent>
 *     &lt;extension base="{http://schemas.openehr.org/v1}DV_ENCAPSULATED">
 *       &lt;sequence>
 *         &lt;element name="alternate_text" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="uri" type="{http://schemas.openehr.org/v1}DV_URI" minOccurs="0"/>
 *         &lt;element name="data" type="{http://www.w3.org/2001/XMLSchema}base64Binary" minOccurs="0"/>
 *         &lt;element name="media_type" type="{http://schemas.openehr.org/v1}CODE_PHRASE"/>
 *         &lt;element name="compression_algorithm" type="{http://schemas.openehr.org/v1}CODE_PHRASE" minOccurs="0"/>
 *         &lt;element name="integrity_check" type="{http://www.w3.org/2001/XMLSchema}base64Binary" minOccurs="0"/>
 *         &lt;element name="integrity_check_algorithm" type="{http://schemas.openehr.org/v1}CODE_PHRASE" minOccurs="0"/>
 *         &lt;element name="size" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="thumbnail" type="{http://schemas.openehr.org/v1}DV_MULTIMEDIA" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DV_MULTIMEDIA", propOrder = {
        "alternateText",
        "uri",
        "data",
        "mediaType",
        "compressionAlgorithm",
        "integrityCheck",
        "integrityCheckAlgorithm",
        "size",
        "thumbnail"
})
public class DVMULTIMEDIA
        extends DVENCAPSULATED {

    @XmlElement(name = "alternate_text")
    protected String alternateText;
    protected DVURI uri;
    protected byte[] data;
    @XmlElement(name = "media_type", required = true)
    protected CODEPHRASE mediaType;
    @XmlElement(name = "compression_algorithm")
    protected CODEPHRASE compressionAlgorithm;
    @XmlElement(name = "integrity_check")
    protected byte[] integrityCheck;
    @XmlElement(name = "integrity_check_algorithm")
    protected CODEPHRASE integrityCheckAlgorithm;
    protected int size;
    protected DVMULTIMEDIA thumbnail;

    /**
     * Gets the value of the alternateText property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getAlternateText() {
        return alternateText;
    }

    /**
     * Sets the value of the alternateText property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setAlternateText(String value) {
        this.alternateText = value;
    }

    /**
     * Gets the value of the uri property.
     *
     * @return possible object is
     * {@link DVURI }
     */
    public DVURI getUri() {
        return uri;
    }

    /**
     * Sets the value of the uri property.
     *
     * @param value allowed object is
     *              {@link DVURI }
     */
    public void setUri(DVURI value) {
        this.uri = value;
    }

    /**
     * Gets the value of the data property.
     *
     * @return possible object is
     * byte[]
     */
    public byte[] getData() {
        return data;
    }

    /**
     * Sets the value of the data property.
     *
     * @param value allowed object is
     *              byte[]
     */
    public void setData(byte[] value) {
        this.data = value;
    }

    /**
     * Gets the value of the mediaType property.
     *
     * @return possible object is
     * {@link CODEPHRASE }
     */
    public CODEPHRASE getMediaType() {
        return mediaType;
    }

    /**
     * Sets the value of the mediaType property.
     *
     * @param value allowed object is
     *              {@link CODEPHRASE }
     */
    public void setMediaType(CODEPHRASE value) {
        this.mediaType = value;
    }

    /**
     * Gets the value of the compressionAlgorithm property.
     *
     * @return possible object is
     * {@link CODEPHRASE }
     */
    public CODEPHRASE getCompressionAlgorithm() {
        return compressionAlgorithm;
    }

    /**
     * Sets the value of the compressionAlgorithm property.
     *
     * @param value allowed object is
     *              {@link CODEPHRASE }
     */
    public void setCompressionAlgorithm(CODEPHRASE value) {
        this.compressionAlgorithm = value;
    }

    /**
     * Gets the value of the integrityCheck property.
     *
     * @return possible object is
     * byte[]
     */
    public byte[] getIntegrityCheck() {
        return integrityCheck;
    }

    /**
     * Sets the value of the integrityCheck property.
     *
     * @param value allowed object is
     *              byte[]
     */
    public void setIntegrityCheck(byte[] value) {
        this.integrityCheck = value;
    }

    /**
     * Gets the value of the integrityCheckAlgorithm property.
     *
     * @return possible object is
     * {@link CODEPHRASE }
     */
    public CODEPHRASE getIntegrityCheckAlgorithm() {
        return integrityCheckAlgorithm;
    }

    /**
     * Sets the value of the integrityCheckAlgorithm property.
     *
     * @param value allowed object is
     *              {@link CODEPHRASE }
     */
    public void setIntegrityCheckAlgorithm(CODEPHRASE value) {
        this.integrityCheckAlgorithm = value;
    }

    /**
     * Gets the value of the size property.
     */
    public int getSize() {
        return size;
    }

    /**
     * Sets the value of the size property.
     */
    public void setSize(int value) {
        this.size = value;
    }

    /**
     * Gets the value of the thumbnail property.
     *
     * @return possible object is
     * {@link DVMULTIMEDIA }
     */
    public DVMULTIMEDIA getThumbnail() {
        return thumbnail;
    }

    /**
     * Sets the value of the thumbnail property.
     *
     * @param value allowed object is
     *              {@link DVMULTIMEDIA }
     */
    public void setThumbnail(DVMULTIMEDIA value) {
        this.thumbnail = value;
    }

}
