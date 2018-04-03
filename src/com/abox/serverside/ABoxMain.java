package com.abox.serverside;

import com.abox.serverside.common.AppConst;
import com.abox.serverside.services.EchoServer;

public class ABoxMain {

    public static void main(String[] args) {

        EchoServer server = new EchoServer(AppConst.SERVER_PORT);
        server.start();
    }
}
