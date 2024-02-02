package ua.burkavtsov.hw26;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8921);
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        while (true) {
            Socket accept = serverSocket.accept();
            executorService.submit(() -> handleConnection(accept));
        }
    }

    private static void handleConnection(Socket accept) {
        try (accept;
             InputStream inputStream = accept.getInputStream();
             BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
             OutputStream outputStream = accept.getOutputStream();
             Writer writer = new BufferedWriter(new OutputStreamWriter(outputStream))) {
            String request = reader.readLine();
            System.out.println("Received request: " + request);

            String response = "Response from server!";
            writer.write(response + "\n");
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
