package ua.burkavtsov.hw23.task1;

import java.io.IOException;

public class JsonSerial {
    public static void main(String[] args) {
        JsonReader jsonReader = new JsonReader();
        JsonWriter jsonWriter = new JsonWriter();

        try {
            YourObjectType object = jsonReader.readJsonFromFile("шлях_до_файлу.json", YourObjectType.class);

            String jsonString = jsonWriter.convertObjectToJsonString(object);
            System.out.println("JSON String: " + jsonString);

            jsonWriter.writeObjectToJsonFile(object, "шлях_до_нового_файлу.json");

            YourObjectType newObject = jsonWriter.convertJsonStringToObject(jsonString, YourObjectType.class);
            System.out.println("Deserialized Object: " + newObject);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
