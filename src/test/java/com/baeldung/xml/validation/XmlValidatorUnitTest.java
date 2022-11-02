package com.baeldung.xml.validation;

import java.io.IOException;
import org.junit.jupiter.api.Test;
import org.xml.sax.SAXException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class XmlValidatorUnitTest {

    private static final String BAELDUNG_XML_PATH = "baeldung.xml";
    private static final String PERSON_XSD_PATH = "person.xsd";
    private static final String FULL_PERSON_XSD_PATH = "full-person.xsd";

    @Test
    public void givenValidXML_WhenIsValid_ThenTrue() throws IOException, SAXException {
        assertTrue(new XmlValidator(PERSON_XSD_PATH, BAELDUNG_XML_PATH).isValid());
    }

    @Test
    public void givenInvalidXML_WhenIsValid_ThenFalse() throws IOException, SAXException {
        assertFalse(new XmlValidator(FULL_PERSON_XSD_PATH, BAELDUNG_XML_PATH).isValid());
    }

    @Test
    public void givenValidXML_WhenListParsingExceptions_ThenNone() throws IOException, SAXException {
        assertEquals(0, new XmlValidator(PERSON_XSD_PATH, BAELDUNG_XML_PATH).listParsingExceptions().size());
    }

    @Test
    public void givenInvalidXML_WhenListParsingExceptions_ThenHasThree() throws IOException, SAXException {
        assertEquals(3, new XmlValidator(FULL_PERSON_XSD_PATH, BAELDUNG_XML_PATH).listParsingExceptions().size());
    }

}