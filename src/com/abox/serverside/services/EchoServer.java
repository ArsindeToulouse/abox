package com.abox.serverside.services;

import com.abox.serverside.models.ReceivedData;
import com.abox.serverside.models.User;
import com.google.gson.Gson;
import org.jetbrains.annotations.Nullable;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {

    private int port;

    public EchoServer(int port) {
        this.port = port;
    }

    public void start() {
        try (ServerSocket boxServer = new ServerSocket(port)) {

            Socket fromClient = boxServer.accept();
            System.out.println("Connection accepted!");

            BufferedReader in = new BufferedReader(new InputStreamReader(
                    fromClient.getInputStream()));

            PrintWriter out = new PrintWriter(new BufferedWriter(
                    new OutputStreamWriter(fromClient.getOutputStream())), true);

            while (true){
                String str = in.readLine();
                if (in.equals("quit"))
                    break;
                System.out.println("Echoing: " + str);

                String string = parseRequest(str);
                out.println("Hello, " + string);
            }

            System.out.println("closing...");
            fromClient.close();
            boxServer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String parseRequest(String str) {
        User user = null;
        Gson gson = new Gson();
        ReceivedData receivedData = gson.fromJson(str, ReceivedData.class);

        for (Object o: receivedData.getData()) {
            String json = gson.toJson(o);

            user = gson.fromJson(json, User.class);
        }

        if (user != null) {
            return user.getLogin();
        }

        return "Anonymous";
    }

    @Nullable
    private String readFromSocket(final InputStream inputStream) {

        int count;
        byte[] buffer = new byte[1024];

        try {
            ByteArrayOutputStream byteStream =
                    new ByteArrayOutputStream(inputStream.available());

            while (true) {
                count = inputStream.read(buffer);
                if (count <= 0)
                    break;
                byteStream.write(buffer, 0, count);
            }

            return byteStream.toString();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
