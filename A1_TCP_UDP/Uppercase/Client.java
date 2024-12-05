package Uppercase;

import java.net.*;
import java.io.*;

public class Client {
    // Initialize socket and input-output streams
    private Socket socket = null;
    private BufferedReader input = null;
    private DataOutputStream out = null;

    // Constructor to set IP address and port
    public Client(String address, int port) {
        // Establish a connection
        try {
            socket = new Socket(address, port);
            System.out.println("Connected");

            // Takes input from the terminal using BufferedReader
            input = new BufferedReader(new InputStreamReader(System.in));

            // Sends output to the socket
            out = new DataOutputStream(socket.getOutputStream());

        } catch (UnknownHostException u) {
            System.out.println(u);
        } catch (IOException i) {
            System.out.println(i);
        }

        String line = "";

        // Keep reading until "Over" is input
        while (!line.equals("Over")) {
            try {
                // Read message from input using BufferedReader
                line = input.readLine();
                out.writeUTF(line); // Send message to the server
            } catch (IOException i) {
                System.out.println(i);
            }
        }

        // Close the connection
        try {
            input.close();
            out.close();
            socket.close();
        } catch (IOException i) {
            System.out.println(i);
        }
    }

    public static void main(String args[]) {
        // Starts the client and initiates the connection
        new Client("127.0.0.1", 5000); // Connects to the server on port 5000
    }
}
