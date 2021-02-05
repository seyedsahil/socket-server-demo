package org.sydlabz;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

public class ServerActionImpl implements ServerAction {
    @Override
    public void perform(PrintWriter serverOut, BufferedReader serverIn, int clientId) throws IOException {
        serverOut.println("Hello Client-" + clientId + ", What is your name ?");
        serverOut.println("Hey " + serverIn.readLine() + ", Nice to meet you!");
    }
}
