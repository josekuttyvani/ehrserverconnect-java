package com.synnefx.ehrserver.utils;

import com.sun.xml.internal.bind.marshaller.NamespacePrefixMapper;
import com.synnefx.ehrserver.xsd.ORIGINALVERSION;
import com.synnefx.ehrserver.xsd.VERSION;

import javax.xml.bind.*;
import javax.xml.namespace.QName;
import java.io.InputStream;
import java.io.StringWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @author Josekutty
 * 21-11-2019
 */
public class Utils {

    private static final String FOO_PREFIX = ""; // DEFAULT NAMESPACE
    private static final String FOO_URI = "http://www.example.com/FOO";

    private static final String OPENEHR_PREFIX = "ehr";
    private static final String OPENEHR_URI = "http://schemas.openehr.org/v1";
    static NamespacePrefixMapper mapper = new NamespacePrefixMapper() {
        public String getPreferredPrefix(String namespaceUri, String suggestion, boolean requirePrefix) {
            if (!requirePrefix || OPENEHR_URI.equalsIgnoreCase(namespaceUri)) {

            }
            return "";
        }
    };

    public static String dateToString(LocalDate date, String format) {
        return date.format(DateTimeFormatter.ofPattern(format));
    }

    public static String xmlToString(ORIGINALVERSION versionsType) {
        JAXBContext jaxbContext;
        try {
            jaxbContext = JAXBContext.newInstance(VERSION.class);
            JAXBElement<ORIGINALVERSION> element = new JAXBElement<>(new QName("http://schemas.openehr.org/v1", "versions"),
                    ORIGINALVERSION.class, versionsType);

            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            //jaxbMarshaller.setProperty("com.sun.xml.internal.bind.namespacePrefixMapper", mapper);
            StringWriter sw = new StringWriter();
            jaxbMarshaller.marshal(versionsType, sw);
            return sw.toString();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return "";
    }

    public static String formatComposionPaylod(ORIGINALVERSION versionsType) {
        return String.format("<versions>%s</versions>", Utils.xmlToString(versionsType));
    }


    public static ORIGINALVERSION initDummyComposition() throws JAXBException {
        InputStream xmlFile = Utils.class.getResourceAsStream("/xsd/Version.xml");
        assert xmlFile != null;
        JAXBContext jaxbContext = JAXBContext.newInstance(ORIGINALVERSION.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        ORIGINALVERSION versions = (ORIGINALVERSION) jaxbUnmarshaller.unmarshal(xmlFile);
        //VersionsType versions = new VersionsType();
        //versions.getVersion().add(initDummyVersion());
        //System.out.println(versions.getVersion().size());
        return versions;
    }


}
