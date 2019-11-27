package com.synnefx.ehrserver.utils;

import org.apache.xmlbeans.XmlOptions;
import org.openehr.schemas.v1.VersionDocument;

import java.io.InputStream;
import java.io.StringWriter;

/**
 * @author Josekutty
 * 27-11-2019
 */
public class XMLParser {

    public static VersionDocument parseComposition(InputStream input) {
        XmlOptions options = new XmlOptions();
        options.setCharacterEncoding("UTF-8");
        try {
            return VersionDocument.Factory.parse(input, options);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String unmarshall(VersionDocument document) {
        XmlOptions options = new XmlOptions();
        options.setCharacterEncoding("UTF-8");
        StringWriter stringWriter = new StringWriter();
        try {
            document.save(stringWriter);
            return stringWriter.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}
