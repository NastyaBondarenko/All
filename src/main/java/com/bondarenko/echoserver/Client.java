package com.bondarenko.echoserver;

import java.io.*;
import java.net.Socket;

public class Client {
    private static Socket socket;
    private static InputStreamReader inputStreamReader;
    private static BufferedReader reader;
    private static InputStreamReader inputStreamReaderBySocket;
    private static BufferedReader bufferedReader;
    private static OutputStreamWriter outputStreamWriter;
    private static BufferedWriter bufferedWriter;

    public static void main(String[] args) {
        try {
            try {
                socket = new Socket("localhost", 3000);
                System.out.println(socket.getLocalPort());

                inputStreamReader = new InputStreamReader(System.in);
                reader = new BufferedReader(inputStreamReader);

                inputStreamReaderBySocket = new InputStreamReader(socket.getInputStream());
                bufferedReader = new BufferedReader(inputStreamReaderBySocket);

                outputStreamWriter = new OutputStreamWriter(socket.getOutputStream());
                bufferedWriter = new BufferedWriter(outputStreamWriter);

                System.out.println("Hello Client!You can type message to Server here:");

                String word = reader.readLine();

                bufferedWriter.write(word + "\n");

                bufferedWriter.flush();

                String serverWord = bufferedReader.readLine();

                System.out.println(serverWord);

            } finally {
                System.out.println("Connection with client is closed");
                socket.close();
                bufferedReader.close();
                bufferedWriter.close();
            }
        } catch (IOException ioException) {
            System.out.println(ioException);
        }
    }
}


