package com.synnefx.ehrserver.utils;

import com.sun.xml.internal.bind.marshaller.NamespacePrefixMapper;
import com.synnefx.ehrserver.models.ErrorResponse;
import org.openehr.schemas.v1.VersionDocument;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.InputStream;
import java.io.StringReader;
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


    public static String formatCompositionPaylod(VersionDocument versionDocument) {
        return String.format("<versions>%s</versions>", XMLParser.unmarshall(versionDocument));
    }

    public static VersionDocument initComposition(String fileName) {
        InputStream xmlFile = Utils.class.getResourceAsStream("/xml/" + fileName);
        assert xmlFile != null;
        try {
            return XMLParser.parseComposition(xmlFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public static ErrorResponse parseXmlErrorResponse(String response) {
        JAXBContext jaxbContext;
        ErrorResponse errorResponse = null;
        try {
            jaxbContext = JAXBContext.newInstance(ErrorResponse.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            StringReader reader = new StringReader(response);
            errorResponse = (ErrorResponse) jaxbUnmarshaller.unmarshal(reader);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return errorResponse;
    }

}
