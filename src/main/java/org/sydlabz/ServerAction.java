package org.sydlabz;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

public interface ServerAction {
    void perform(PrintWriter serverOut, BufferedReader serverIn, int clientId) throws IOException;
}
