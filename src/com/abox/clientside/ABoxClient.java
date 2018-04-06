package com.abox.clientside;

import com.abox.serverside.models.User;
import com.google.gson.Gson;

import java.io.*;
import java.net.Socket;

public class ABoxClient {

    private static final int PORT = 2225;
    private static final String HOST = "127.0.0.1";

    public static void main(String[] args) throws IOException {

        System.out.println("Welcome to Client side");

        Socket fromServer = new Socket(HOST, PORT);

        BufferedReader in  = new BufferedReader(
                new InputStreamReader(fromServer.getInputStream()));
        PrintWriter out = new PrintWriter(fromServer.getOutputStream(),true);
        BufferedReader inu = new BufferedReader(
                new InputStreamReader(System.in));

        String userIn, serverIn, jsonUser = "";

        while (true) {
            userIn = inu.readLine();

            if (userIn.equalsIgnoreCase("quit")) {
                out.println(userIn);
                break;
            }

            String[] logPass = checkUserIn(userIn);

            if (logPass != null) {
                User user = new User(logPass[0], logPass[1]);
                jsonUser = formatToJson(user);
            }
            out.println(jsonUser);
            serverIn = in.readLine();
            System.out.println("Server echo: " + serverIn);
        }

        out.close();
        in.close();
        inu.close();
        fromServer.close();
    }

    private static String formatToJson(User user) {
        Gson gson = new Gson();

        return "{ \"type\": \"auth\", \"data\": [" + gson.toJson(user) + "]}";
    }

    private static String[] checkUserIn(String userIn) {
        if (userIn.contains(":")) {
            return userIn.split(":");
        }

        return null;
    }
}
