package ua.burkavtsov.hw26;

import java.io.*;
import java.net.Socket;

public class Client {

    public static void main(String[] args) throws IOException {
        try (Socket socket = new Socket("localhost", 8921);
             BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             Writer writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))) {

            writer.write("Hello, everybody! Tema make homework\n");
            writer.flush();

            String response = reader.readLine();
            System.out.println("Server response: " + response);
        }
    }
}