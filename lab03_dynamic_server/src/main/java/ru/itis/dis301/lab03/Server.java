package ru.itis.dis301.lab03;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;

public class Server {
    public static final int SERVER_PORT = 5000;
    public static final String ROOT_DIRECTORY = "html/";

    public static void main(String[] args) {
        try {

            // Структура для динамической обработки ресурсов
            Map<String, IResourceHandler> resources = new HashMap<>();

            resources.put("/home", new HomeResourceHandler());

            ServerSocket server = new ServerSocket(SERVER_PORT);
            // wait client connection
            //System.out.println("accept");
            System.out.println("start server");

            Socket clientSocket = server.accept();

            InputStream inputStream = clientSocket.getInputStream();

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String headerLine = bufferedReader.readLine();

            String[] firstLine = headerLine.split("\\s+");

            String method = firstLine[0];
            String uri = firstLine[1];
            String httpVers = firstLine[2];

            System.out.println(method + " " + uri + " " + httpVers);
            while (headerLine != null && !headerLine.equals("")) {
                headerLine = bufferedReader.readLine();
                System.out.println(headerLine);
            }

            // Динамическая обработка
            // К этому моменту надо сформировать параметры
            ResponceContent responceContent = null;
            IResourceHandler handler = resources.get(uri);
            if (handler != null) {
                responceContent = handler.handle(null);
            } else {
                // пытаемся найти файл
            }

            String[] response = {
                    "HTTP/1.1 200 OK\r\n",
                    "Server: NewSuperServer\r\n",
                    "Content-Type: " + responceContent.getMimeType() + "\r\n",
                    "Content-Length: " + responceContent.getContent().length + "\r\n",
                    "\r\n"};

            for (String responseHeaderLine : response) {
                clientSocket.getOutputStream().write(responseHeaderLine.getBytes());
                clientSocket.getOutputStream().flush();
            }

            clientSocket.getOutputStream().write(responceContent.getContent());
            clientSocket.getOutputStream().flush();

            clientSocket.close();
            server.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
