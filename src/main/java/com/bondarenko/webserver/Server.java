package com.bondarenko.webserver;


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private static final String LINE_END = "\n";

    final static String html = "<!doctype html>\n" +
            "<html lang=\"en\">\n" +
            "<head>\n" +
            "<meta charset=\"UTF-8\">\n" +
            "<meta name=\"viewport\"\n" +
            "content=\"width=device-width,initial-scale=1,shrink-to-fit=no\">\n" +
            " <link rel=\"stylesheet\" type=\"text/css\" href=\"style.css\">\n" +

            "<title> test page</title>\n" +
            "</head>\n" +
            "<body>\n" +
            "<h1> Hello word from HTML!!!</h1>\n" +

            "</body>\n" +
            "</html>";

    public static void main(String[] args) throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(3000);) {


            try (Socket socket = serverSocket.accept();

                 BufferedWriter socketWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                 BufferedReader socketReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));) {

                while (true) {
                    String lineFromClient = socketReader.readLine();//GET -запит
                    System.out.println(lineFromClient);
                    if (lineFromClient.isEmpty()) {
                        break;
                    }
                }
                socketWriter.write("HTTP/1.1 200 OK");
                socketWriter.write(LINE_END);
                socketWriter.write(LINE_END);
                socketWriter.write(html);
                socketWriter.flush();

            }

        }
    }
}




