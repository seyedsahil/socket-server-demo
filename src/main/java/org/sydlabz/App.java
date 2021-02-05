package org.sydlabz;

import java.io.IOException;
import java.util.Date;

/**
 * @author Seyed Sahil
 */
public class App {
    public static void main(String[] args) throws IOException, InterruptedException {
        Server server = new Server(8080);
        System.out.println("Server session started at " + new Date());
        server.listen(new ServerActionImpl());
        System.out.println("Server session ended at " + new Date());
    }
}
