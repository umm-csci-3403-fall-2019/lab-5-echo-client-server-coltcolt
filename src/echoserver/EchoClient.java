package echoserver;

import java.net.*;
import java.io.*;

public class EchoClient {
    public static void main(String[] args) throws IOException {
        final int portNumber = 6013;
        String server;
        // Use "127.0.0.1", i.e., localhost, if no server is specified.
        if (args.length == 0) {
            server = "127.0.0.1";
        } else {
            server = args[0];
        }

        try {
            // Connect to the server
            Socket socket = new Socket(server, portNumber);
            int thebyte; //byte wasn't allowed ;(
            // Get the input stream so we can read from that socket
            InputStream input = socket.getInputStream();
            OutputStream output = socket.getOutputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));

            // Print all the input we receive from the server
            while ((thebyte = System.in.read()) != -1) {
                output.write(thebyte);
                System.out.write(input.read());
            }

            // Close the socket when we're done reading from it
            socket.close();

            // Provide some minimal error handling.
        } catch (
                ConnectException ce) {
            System.out.println("We were unable to connect to " + server);
            System.out.println("You should make sure the server is running.");
        } catch (
                IOException ioe) {
            System.out.println("We caught an unexpected exception");
            System.err.println(ioe);
        }
    }
}