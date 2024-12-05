package Uppercase;

import java.net.*;
import java.io.*;

public class Server {
    // Initialize socket and input stream
    private Socket socket = null;
    private ServerSocket server = null;
    private DataInputStream in = null;

    // Constructor with port
    public Server(int port) {
        // Starts server and waits for a connection
        try {
            server = new ServerSocket(port);
            System.out.println("Server started");
            System.out.println("Waiting for a client ...");
            socket = server.accept();
            System.out.println("Client accepted");

            // Takes input from the client socket
            in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
            String line = "";

            // Read messages from client until "Over" is sent
            while (!line.equals("Over")) {
                try {
                    line = in.readUTF();
                    System.out.println(line.toUpperCase()); // Prints the message in uppercase
                } catch (IOException i) {
                    System.out.println(i);
                }
            }
            System.out.println("Closing connection");
            // Close the connection
            socket.close();
            in.close();
        } catch (IOException i) {
            System.out.println(i);
        }
    }

    public static void main(String args[]) {
        // Starts the server on port 5000
        Server server = new Server(5000);
    }
}
