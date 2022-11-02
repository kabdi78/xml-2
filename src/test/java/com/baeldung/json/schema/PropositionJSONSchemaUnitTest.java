package com.baeldung.json.schema;

import java.io.IOException;
import java.util.Set;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.networknt.schema.JsonSchema;
import com.networknt.schema.JsonSchemaFactory;
import com.networknt.schema.SpecVersion;
import com.networknt.schema.ValidationMessage;

public class PropositionJSONSchemaUnitTest {

    private ObjectMapper mapper = new ObjectMapper();

    @Test
    public void givenValidInput_whenValidating_thenValid() throws IOException {

        JsonSchemaFactory factory = JsonSchemaFactory.getInstance(SpecVersion.VersionFlag.V4);
        JsonSchema jsonSchema = factory.getSchema(PropositionJSONSchemaUnitTest.class.getResourceAsStream(
                "/propostion/propositionSchemaWithUnit.json"));

        JsonNode jsonNode = mapper.readTree(PropositionJSONSchemaUnitTest.class.getResourceAsStream(
                "/propostion/proposition_with_unit_valid.json"));
        Set<ValidationMessage> errors = jsonSchema.validate(jsonNode);
        Assertions.assertTrue(errors.isEmpty());
    }
}