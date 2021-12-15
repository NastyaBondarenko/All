package com.bondarenko.servertest;

import com.bondarenko.webserver.Server1;
import org.junit.Test;

import java.io.BufferedOutputStream;
import java.io.File;

public class ServerTest {
    public static void main(String[] args) {
        Server1 server = new Server1();
        server.setPort(3000);
        String separator = File.separator;
        server.setWebAppPath("E:" + separator + "Робоча 2021" + separator + "Java" + separator + "datastructure" + separator + "webapp" + separator + "css" + separator + "index.html");

        server.start();
    }

}

//    @Test
//    public void testConveyResourceToClient(){
//        String resourcePath = server.se
//        conveyResourceToClient(String resourcePath, BufferedOutputStream output)
//    }


//}
