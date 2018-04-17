package com.abox.serverside;

import com.abox.serverside.common.AppConst;
import com.abox.serverside.services.EchoServer;

import java.io.IOException;

public class ABoxMain {

    public static void main(String[] args) {

        EchoServer server = new EchoServer(AppConst.SERVER_PORT);
        try {
            server.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
