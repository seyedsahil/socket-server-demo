package org.sydlabz;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Server {
    private final ServerSocket serverSocket;
    private final int port;
    private final List<ServerThread> serverThreads;
    private int connections;

    public Server(int port) throws IOException {
        this.port = port;
        serverSocket = new ServerSocket(this.port);
        serverThreads = new ArrayList<>();
        connections = 0;
    }

    public void listen(ServerAction action) throws IOException, InterruptedException {
        while (connections != 2) {
            System.out.println("Server is listening on port " + port);
            Socket clientSocket = serverSocket.accept();
            connections++;
            System.out.println("Server connected wth client Client-" + connections + " at " + new Date());
            serverThreads.add(new ServerThread(clientSocket, action, connections));
        }
        for (ServerThread serverThread : serverThreads) {
            serverThread.join();
        }
        serverSocket.close();
    }
}
