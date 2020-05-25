package echoclient;

import java.io.*;
import java.util.*;
import java.net.*;

public class EchoClient {

    public static void main(String[] args) throws IOException {

        String hostName = "127.0.0.1"; //InetAddress.getLocalHost();
        int portNumber = 3000;

        try {
            Socket echoSocket = new Socket(hostName, portNumber);
            PrintWriter out = new PrintWriter(echoSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));
            BufferedReader stdIn =new BufferedReader(new InputStreamReader(System.in));
            
            String userInput;
            System.out.println("Insert new line:");
            while ((userInput = stdIn.readLine()) != null) {
                out.println(userInput);
                System.out.println("server response: " + in.readLine());
            }
        } catch (UnknownHostException ex) {
            System.err.println("Don't know about host " + hostName);
            System.exit(1);
        } catch (IOException ex) {
            System.err.println("Couldn't get I/O for the connection to " +
                hostName);
            System.exit(1);
        } 
    }
    
}
