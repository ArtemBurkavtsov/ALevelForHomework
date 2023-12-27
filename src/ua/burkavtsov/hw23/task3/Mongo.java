package ua.burkavtsov.hw23.task3;

import com.mongodb.client.*;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.UpdateOptions;
import org.bson.Document;

public class Mongo{
    public static void main(String[] args) {
        try (MongoClient mongoClient = MongoClients.create("mongodb://admin:admin123@localhost:27017")) {
            MongoDatabase database = mongoClient.getDatabase("your_database");
            MongoCollection<Document> collection = database.getCollection("your_collection");

            Document documentToAdd = new Document("key", "value");
            collection.insertOne(documentToAdd);
            System.out.println("Document added: " + documentToAdd);

            Document documentToRead = collection.find(Filters.eq("key", "value")).first();
            System.out.println("Document read: " + documentToRead);

            Document updatedDocument = new Document("$set", new Document("key", "new_value"));
            collection.updateOne(Filters.eq("key", "value"), updatedDocument, new UpdateOptions().upsert(true));
            System.out.println("Document updated");

            Document updatedDocumentToRead = collection.find(Filters.eq("key", "new_value")).first();
            System.out.println("Updated document read: " + updatedDocumentToRead);

            collection.deleteOne(Filters.eq("key", "new_value"));
            System.out.println("Document deleted");
        }
    }
}
