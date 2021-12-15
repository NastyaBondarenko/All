package com.bondarenko.webserver;

import java.io.*;
import java.net.Socket;

public class Client {
    private static final String LINE_END="\n";

    public static void main(String[] args) throws IOException {

        try (Socket socket = new Socket("127.0.0.1", 3000);
             BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter socketWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
             BufferedReader socketReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));) {
            while (true) {
                String line = consoleReader.readLine();

                socketWriter.write("GET /wiki/HTTP HTTP/1.0");
                socketWriter.write(LINE_END);
                socketWriter.flush();

                String lineFromSocket =socketReader.readLine();
                System.out.println(lineFromSocket);
            }


        }
    }
}
