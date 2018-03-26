package com.abox;

import sun.rmi.runtime.Log;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class BoxServer {

    private static final int SERVER_PORT = 2225;

    public static void main(String[] args) {

        try (ServerSocket boxServer = new ServerSocket(SERVER_PORT)) {

            Socket boxClient = boxServer.accept();
            System.out.println("Connection accepted!");

            DataOutputStream out = new DataOutputStream(boxClient.getOutputStream());
            System.out.println("DataOutputStream  created");

            DataInputStream in = new DataInputStream(boxClient.getInputStream());
            System.out.println("DataInputStream created");

            while (!boxClient.isClosed()){
                System.out.println("Server reading from channel");

                String entry = in.readUTF();
                System.out.println("READ from client message - " + entry);

                System.out.println("Server try writing to channel");

                if (entry.equalsIgnoreCase("q")) {
                    System.out.println("Client initialize connections suicide ...");
                    out.writeUTF("Server reply - " + entry + " - OK");
                    out.flush();
                    Thread.sleep(3000);
                    break;
                }

                out.writeUTF("Server reply - " + entry + " - OK");
                out.flush();
            }

            System.out.println("Client disconnected");
            System.out.println("Closing connections & channels.");

            in.close();
            out.close();

            boxClient.close();

            System.out.println("Closing connections & channels - DONE.");

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            System.out.println("Error: " + e.getLocalizedMessage());
        }
    }
}
