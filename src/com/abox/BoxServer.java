package com.abox;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class BoxServer {

    private static final int SERVER_PORT = 2225;

    public static void main(String[] args) {

        try (ServerSocket boxServer = new ServerSocket(SERVER_PORT)) {

            Socket boxClient = boxServer.accept();
            System.out.println("Connection accepted!");


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
