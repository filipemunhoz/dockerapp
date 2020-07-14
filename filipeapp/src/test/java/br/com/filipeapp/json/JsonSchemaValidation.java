package br.com.filipeapp.json;

import java.io.IOException;
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

	private final String schemaDirectory = "/schema/";
	private final String payloadsDirectory = "/intent/";
	
	@Test
	public void givenInvalidInput_whenValidating_thenInvalid() throws ValidationException, IOException {
		
		JSONObject jsonSchema = new JSONObject(new JSONTokener(JsonSchemaValidation.this.getClass().getResourceAsStream(schemaDirectory + "json-schema.json")));
		Assert.notNull(jsonSchema, "Schema not found");
		
		List<String> files = IOUtils.readLines(JsonSchemaValidation.this.getClass().getResourceAsStream(payloadsDirectory), "UTF-8");
		
		Schema schema = SchemaLoader.load(jsonSchema);
		files.forEach(filename -> {			
			JSONObject json = new JSONObject(new JSONTokener(JsonSchemaValidation.this.getClass().getResourceAsStream(payloadsDirectory + filename)));
			schema.validate(json);
		});
	}	
}