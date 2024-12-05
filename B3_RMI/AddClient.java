import java.rmi.*;

public class AddClient {
    public static void main(String[] args) {
        try {
            String serverURL = "rmi://" + args[0] + "/AddServer";
            AddServerIntf stub = (AddServerIntf) Naming.lookup(serverURL);

            double num1 = Double.parseDouble(args[1]);
            double num2 = Double.parseDouble(args[2]);

            System.out.println("Sum: " + stub.add(num1, num2));
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

/*
   // 1st Terminal:
    javac AddServerIntf.java AddServerImpl.java AddServer.java AddClient.java
    start rmiregistry
   

   // 2nd Terminal:
    java AddServer
   Server is ready...

   // 3rd Terminal:
    java AddClient localhost 5 7
   Sum: 12.0
   
*/


/*
1) Purpose: RMI allows a Java object to invoke methods on a remote object located on another JVM, enabling distributed computing.

2) Location Transparency: Clients interact with remote objects as if they are local, abstracting network complexity.

3) Key Components:
Remote Interface: Defines the methods available for remote invocation.
Stub and Skeleton: Proxies that facilitate communication between client and server (skeletons are now managed by the RMI runtime).
RMI Registry: A lookup service where remote objects are registered and discovered.

4)Process Overview:
Define a remote interface.
Implement the remote object on the server.
Register the remote object with the RMI registry.
Clients look up and invoke methods on the remote object.

5)Features:
Object Serialization: RMI automatically serializes objects for transmission across the network.
Distributed Garbage Collection: Automatically manages resources for remote objects no longer in use.
Java-Centric: Designed specifically for Java-to-Java communication.

6)Advantages:
Simplifies remote communication between Java objects.
High-level abstraction, hiding complex networking.

7)Limitations:
Only supports Java-based systems.
Adds performance overhead due to object serialization and network latency.
 */