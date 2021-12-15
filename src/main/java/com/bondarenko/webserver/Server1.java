package com.bondarenko.webserver;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;


public class Server1 {

    private static final String LINE_END = "\n";
    private static final String GET = "GET";
    private static final String HTTP_OK = "HTTP/1.1 200 OK";
    private static final String HTTP_NOT_FOUND = "HTTP/1.1 404 NOT FOUND";
    private static final String HTTP = "HTTP/";
    private static final String CONTENT_TYPE = "Content-Type: text/html; charset=utf-8";//кодировка
    private static final int TRANSFER_BUFFER_SIZE = 3000;
    private static final String SEPARATOR = "/";

    private int port;
    private String webAppPath;

    public void setWebAppPath(String webAppPath) {
        this.webAppPath = webAppPath;
    }

    public void setPort(int port) {
        this.port = port;
    }
    private BufferedInputStream getResource(String resourcePath) throws FileNotFoundException {
        return new BufferedInputStream(new FileInputStream(resourcePath));//створює файл маючи шлях ресурсу
    }

    public void conveyResourceToClient(String resourcePath, BufferedOutputStream output) throws IOException {
        output.write(HTTP_OK.getBytes());
        output.write(CONTENT_TYPE.getBytes());
        output.write(LINE_END.getBytes());
        BufferedInputStream inputStream = getResource(resourcePath);
        byte[] buffer = new byte[TRANSFER_BUFFER_SIZE];
        while (inputStream.read(buffer) > 0) {
            output.write(buffer);
        }
        output.flush();
    }

    public String getResourcePathFromRequest(String lineFromClient) {
        String resourcePath = null;
        String resourceName = null;
        int indexFrom = lineFromClient.indexOf(GET);
        int indexTo = lineFromClient.indexOf(HTTP);
        if (indexFrom >= 0 && indexTo >= 0) {
            resourceName = lineFromClient.substring(indexFrom + GET.length(), indexTo);
            resourcePath = webAppPath + File.separator + resourceName.trim();
            resourcePath = resourcePath.replace(SEPARATOR, File.separator);
        }
        return resourcePath;
    }

    public void start() {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server started!");

            while (true) {
                //while після закінченя запиту, знову вертає в server.accept і очікує нового запиту
                try (Socket socket = serverSocket.accept()) {
                    System.out.println("New client connected");

                    try (BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                         BufferedOutputStream output = new BufferedOutputStream(socket.getOutputStream())) {

                        String resourcePath = null;
                        String lineFromClient;
                        while (!(lineFromClient = input.readLine()).isEmpty()) {

                            if (resourcePath == null) {
                                resourcePath = getResourcePathFromRequest(lineFromClient);
                            }
                            System.out.println(lineFromClient);

                            if (resourcePath != null) {
                                conveyResourceToClient(resourcePath, output);
                            }
                        }

                    } catch (IOException exception) {
                        exception.printStackTrace();
                    }
                }

            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}




//
//}
//    private static final String LINE_END = "\n";
//    private static final String GET = "GET";
//    private static final String HTTP_OK = "HTTP/1.1 200 OK";
//    private static final String HTTP_NOT_FOUND = "HTTP/1.1 404 NOT FOUND";
//    private static final String HTTP = "HTTP/";
//    private static final String CONTENT_TYPE = "Content-Type: text/html; charset=utf-8";//кодировка
//    private static final int TRANSFER_BUFFER_SIZE = 3000;
//    private int port;
//    private String webAppPath;
//
//    public void setWebAppPath(String webAppPath) {
//        this.webAppPath = webAppPath;
//    }
//
//    public void setPort(int port) {
//        this.port = port;
//    }
//
//
//    private BufferedInputStream getResource(String resourcePath) throws FileNotFoundException {
//        return new BufferedInputStream(new FileInputStream(resourcePath));//створює файл маючи шлях ресурсу
//    }
//
//    private void conveyResourceToClient(String resourcePath, BufferedOutputStream output) throws IOException {
//        output.write(HTTP_OK.getBytes());
//        output.write(CONTENT_TYPE.getBytes());
//        output.write(LINE_END.getBytes());
//
//        byte[] buffer = new byte[TRANSFER_BUFFER_SIZE];
//        while (getResource(resourcePath).read(buffer) > 0) {
//            output.write(buffer);
//        }
//        output.flush();
//    }
//
//    private String getResourcePathFromRequest(String lineFromClient){
//        String resourcePath = null;
//        String resourceName=null;
//        int indexFrom = lineFromClient.indexOf(GET);
//        int indexTo = lineFromClient.indexOf(HTTP);
//        if(indexFrom>=0  && indexTo>=0){
//            resourceName=lineFromClient.substring(indexFrom+GET.length(),indexTo);
//            resourcePath=webAppPath+File.separator+resourceName.trim();
//            resourcePath=resourcePath.re
//        }
//
//    }
//
//
//
//    public void start() {
//        try (ServerSocket serverSocket = new ServerSocket(port)) {
//            System.out.println("Server started!");
//
//            while (true) {//while після закінченя запиту, знову вертає в server.accept і очікує нового запиту
//                try (Socket socket = serverSocket.accept()) {
//                    System.out.println("New client connected");
//
//                    try (BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//                         BufferedOutputStream output = new BufferedOutputStream(socket.getOutputStream())) {
//
//                        String resourcePath = null;
//                        String lineFromClient;
//
//                        while (!input.ready()) {
//
//                            while (input.ready()) {
//
//
//
//                            if (resourcePath.isEmpty()) {
//
//                            }
//
//
//                            if (!resourcePath.isEmpty()) {
//                                conveyResourceToClient(resourcePath, output);
//                            }
//
//
////    //GET / HTTP/1.1 from REQUEST
////    private Path getResourcePathFromRequest(String webAppPath, BufferedReader input) throws IOException {
////        String firstLine = input.readLine();
////        String[] parts = firstLine.split(" ");
////        System.out.println(firstLine);
////        while (input.ready()) {
////            System.out.println(input.readLine());
////        }
////        Path path = Paths.get(webAppPath, parts[1]); // [1]-HTTP  GET / HTTP/1.1 -путь к файлу
////        return path;
////    }
//
//
//
//
//
////https://www.youtube.com/watch?v=8cXq-wtz__E
//
//
//
//
//
//
//
//
//
//
//
//                            // First line from GET-request - find getResourcePath GET / HTTP/1.1 from REQUEST
//                            String firstLine = input.readLine();
//                            String[] parts = firstLine.split(" ");// 3 parts by space
//                            while (input.ready()) {
//                                System.out.println(input.readLine());
//                            }
//
//                            Path path = Paths.get(webAppPath, parts[1]); // [1]-HTTP  GET / HTTP/1.1 -путь к файлу
//                            if (!Files.exists(path)) { // if file not found
//                                output.println(HTTP_NOT_FOUND);
//                                output.println(CONTENT_TYPE);
//                                output.println();//обовязково виводить пусту строку
//                                output.println("<h1>File not found</h>");
//                                output.flush();
//                                continue; //переходим на початок while
//                            }
//
//                            //відповідь сервера на запит
//                            output.println(HTTP_OK);
//                            output.println(CONTENT_TYPE);
//                            output.println();//обовязково виводить пусту строку
//
//                            Files.newBufferedReader(path).transferTo(output);
//                            output.flush();
//
//
//                        } catch(IOException exception){
//                            exception.printStackTrace();
//                        }
//                    } catch (IOException ioException) {
//                        ioException.printStackTrace();
//                    }
//                }
//            } catch(IOException exception){
//                exception.printStackTrace();
//            }
//
//
//        }
//
//
////
////
////
////
////
////
////
////
////
////
////    private static final String LINE_END = "\n";
////    private static final int BUFFER_SIZE = 3000;
////    private static final String GET_METHOD = "GET";
////    private static final String HTTP = "HTTP/";
////    private static final String HTTP_OK = "HTTP/1.1 200 OK";
////    private static final String ADDRESS_LINE_SEPARATOR = "/";
////
////    private int port;
////    private String webAppPath;
////    boolean isOpen = false; //?
////
////    public void setWebAppPath (String webAppPath){
////        this.webAppPath = webAppPath;
////    }
////
////    public void setPort (int port){
////        this.port = port;
////    }
////
////    private BufferedInputStream getResources(String resourcePath) throws FileNotFoundException {
////        return new BufferedInputStream((new FileInputStream(resourcePath)));
////    }
////
////    //https://www.youtube.com/watch?v=8cXq-wtz__E&ab_channel=TheUsharik
////
////
////
////
////
////
////
////
////
////
////
////
////
////}
////
////
////
////
//////    void start() {
//////        try (ServerSocket server = new ServerSocket(this.port)) {
//////            while (true) {
//////                Socket socket = server.accept();
//////                Handler thread = new Handler(socket, this.webAppPath);
//////                thread.start();
//////            }
//////        } catch (IOException e) {
//////            e.printStackTrace();
//////        }
//////    }
////
////
////// server.setWebAppPath("resources/webapp");
////////        server.setPort(3000);
////////        server.start();
////
////
//////    private static final int PORT = 3000;
//////
//////
//////    private static final String GET = "GET";
//////    private static final String HTTP = "HTTP";
//////    private static final String HTTP_OK = "HTTP/1.1 200 OK";
//////    private static final String SEPARATOR = "/";
//////
//////
//////    public void setPort(int port) {
//////        this.port = port;
//////    }
//////
//////    public void setWebAppPath(String webAppPath) {
//////        this.webAppPath = webAppPath;
//////    }
//////
//////    private BufferedInputStream getResources(String resourcePath) throws FileNotFoundException {
//////        return new BufferedInputStream(new FileInputStream(resourcePath));
//////    }
//////    //https://www.youtube.com/watch?v=0jmdSpykbIQ
////////
//////
//////    // https://developer.mozilla.org/ru/docs/Learn/Server-side/First_steps/Client-Server_overview
//////}
