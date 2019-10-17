package echoserver;

import java.net.*;
import java.io.*;

public class EchoServer {
    public static final int portNumber = 6013;

    public static void main(String[] args) throws IOException {
        try {
            // Start listening on the specified port
            ServerSocket sock = new ServerSocket(portNumber);

            // Run forever, which is common for server style services
            while (true) {
                // Wait until someone connects, thereby requesting a date
                Socket client = sock.accept();
                System.out.println("Got a request!");



                // Construct a writer so we can write to the socket, thereby
                // sending something back to the client.
                OutputStream output = client.getOutputStream();
                InputStream input = client.getInputStream();

                while(1==1) { //do always, this is a server
                    int request = client.getInputStream().read(); //get the request from client's input
                    if (request != -1) { //if the request is readable, print it to user
                        output.write(request);
                    }
                    else { //if it isn't, don't, and get rid of buffer
                        output.flush();
                        break;
                    }
                }


                // Close the client socket since we're done.
                client.close();
            }
            // *Very* minimal error handling.
        } catch (IOException ioe) {
            System.out.println("We caught an unexpected exception");
            System.err.println(ioe);
        }
    }
}