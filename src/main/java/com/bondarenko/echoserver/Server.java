package com.bondarenko.echoserver;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private static ServerSocket serverSocket;
    private static Socket socket;
    private static InputStreamReader inputStreamReader;
    private static BufferedReader bufferedReader;
    private static OutputStreamWriter outputStreamWriter;
    private static BufferedWriter bufferedWriter;

    public static void main(String[] args) {
        try {
            try {
                serverSocket = new ServerSocket(3000);
                socket = serverSocket.accept();

                inputStreamReader = new InputStreamReader(socket.getInputStream());
                bufferedReader = new BufferedReader(inputStreamReader);

                outputStreamWriter = new OutputStreamWriter(socket.getOutputStream());
                bufferedWriter = new BufferedWriter(outputStreamWriter);

                String word = bufferedReader.readLine();
                System.out.println(word);

                bufferedWriter.write("Server receive from client message: " + word + "\n");
                bufferedWriter.flush();

            } finally {
                socket.close();
                bufferedWriter.close();
                bufferedReader.close();
                serverSocket.close();
            }
        } catch (IOException e) {
            System.err.println(e);
        }
    }
}


