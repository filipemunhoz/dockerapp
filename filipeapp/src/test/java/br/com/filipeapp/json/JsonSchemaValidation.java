package br.com.filipeapp.json;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

import javax.validation.ValidationException;

import org.apache.commons.io.IOUtils;
import org.everit.json.schema.Schema;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

public class JsonSchemaValidation {

	private final String JSON_SCHEMA = "/schema/json-schema.json";
	private final String PAYLOADS = "/intent/";
	private final String SCHEMA_NOT_FOUND = "Schema not found";
	
	@Test
	public void validatePayloadsAgainstSchema() throws ValidationException, IOException {
		
		JSONObject jsonSchema = getJSONObject(JSON_SCHEMA);
		Assert.notNull(jsonSchema, SCHEMA_NOT_FOUND);
		
		List<String> files = IOUtils.readLines(JsonSchemaValidation.this.getClass().getResourceAsStream(PAYLOADS), StandardCharsets.UTF_8);
		
		Schema schema = SchemaLoader.load(jsonSchema);
		files.forEach(filename -> {			
			schema.validate(getJSONObject(PAYLOADS + filename));
		});
	}
	
	private JSONObject getJSONObject(final String filename) {
		return new JSONObject(new JSONTokener(JsonSchemaValidation.this.getClass().getResourceAsStream(filename)));
	}
}