package com.cirb.xml.validation;

import java.io.IOException;
import org.junit.jupiter.api.Test;
import org.xml.sax.SAXException;

import static org.junit.jupiter.api.Assertions.assertTrue;

class PropositionXmlValidatorUnitTest {

    private static final String PROPOSITION_XML_PATH = "peb/proposition.xml";
    private static final String PROPOSITON_XSD_PATH  = "peb/proposition.xsd";

    @Test
    public void givenValidXML_WhenIsValid_ThenTrue() throws IOException, SAXException {
        assertTrue(new XmlValidator(PROPOSITON_XSD_PATH, PROPOSITION_XML_PATH).isValid());
    }


}