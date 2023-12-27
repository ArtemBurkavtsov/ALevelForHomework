package ua.burkavtsov.hw23.task1;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

public class JsonReader {
    private final ObjectMapper objectMapper;
    public JsonReader() {
        this.objectMapper = new ObjectMapper();
    }
    public <T> T readJsonFromFile(String filePath, Class<T> valueType) throws IOException {
        return objectMapper.readValue(new File(filePath), valueType);
    }
}
