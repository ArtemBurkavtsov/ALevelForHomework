package ua.burkavtsov.hw23.task1;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

public class JsonWritter {
    private final ObjectMapper objectMapper;

    public JsonWriter() {
        this.objectMapper = new ObjectMapper();
    }

    public void writeObjectToJsonFile(Object object, String filePath) throws IOException {
        objectMapper.writeValue(new File(filePath), object);
    }

    public String convertObjectToJsonString(Object object) throws IOException {
        return objectMapper.writeValueAsString(object);
    }

    public <T> T convertJsonStringToObject(String jsonString, Class<T> valueType) throws IOException {
        return objectMapper.readValue(jsonString, valueType);
    }
}
