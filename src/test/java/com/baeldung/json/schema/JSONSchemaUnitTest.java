package com.baeldung.json.schema;


import java.io.IOException;
import java.util.Set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.CollectionUtils;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.networknt.schema.JsonSchema;
import com.networknt.schema.JsonSchemaFactory;
import com.networknt.schema.SpecVersion;
import com.networknt.schema.ValidationMessage;

public class JSONSchemaUnitTest {

    private ObjectMapper mapper = new ObjectMapper();

    @Test
    public void givenInvalidInput_whenValidating_thenInvalid() throws IOException {

        JsonSchemaFactory factory = JsonSchemaFactory.getInstance(SpecVersion.VersionFlag.V4);
        JsonSchema jsonSchema = factory.getSchema(JSONSchemaUnitTest.class.getResourceAsStream("/schema.json"));

        JsonNode jsonNode = mapper.readTree(JSONSchemaUnitTest.class.getResourceAsStream("/product_invalid.json"));
        Set<ValidationMessage> errors = jsonSchema.validate(jsonNode);
        Assertions.assertFalse(errors.isEmpty());
        Assertions.assertTrue(errors.toString().contains("price: must have a minimum value of 0"));
    }

    @Test
    public void givenValidInput_whenValidating_thenValid() throws IOException {

        JsonSchemaFactory factory = JsonSchemaFactory.getInstance(SpecVersion.VersionFlag.V4);
        JsonSchema jsonSchema = factory.getSchema(JSONSchemaUnitTest.class.getResourceAsStream("/schema.json"));

        JsonNode jsonNode = mapper.readTree(JSONSchemaUnitTest.class.getResourceAsStream("/product_valid.json"));
        Set<ValidationMessage> errors = jsonSchema.validate(jsonNode);
        Assertions.assertTrue(errors.isEmpty());
    }
}