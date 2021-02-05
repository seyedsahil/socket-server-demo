package org.sydlabz;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Date;

public class ServerThread extends Thread {
    private final ServerAction serverAction;
    private final Socket clientSocket;
    private final int clientId;

    public ServerThread(Socket clientSocket, ServerAction serverAction, int clientId) {
        this.serverAction = serverAction;
        this.clientSocket = clientSocket;
        this.clientId = clientId;
        start();
    }

    @Override
    public void run() {
        try {
            PrintWriter serverOut = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader serverIn = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            serverAction.perform(serverOut, serverIn, clientId);
            serverIn.close();
            serverOut.close();
            clientSocket.close();
            System.out.println("Client-" + clientId + " session ended at " + new Date());
        } catch (IOException ex) {
            ex.printStackTrace(System.err);
        }
    }
}
