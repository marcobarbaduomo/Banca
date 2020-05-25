package echoserver;

import java.net.ServerSocket;
import java.net.Socket;
import java.net.InetAddress;
import java.io.*;


public class EchoServer {

    public static void main(String[] argv) {
        try {
            ServerSocket server = new ServerSocket(3000, 10);
            System.out.println("Server on");
            Socket client = null;

            while (true) {
                try {
                    client = server.accept();

                    int c;
                    String response = "";
                    BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
                    PrintWriter out = new PrintWriter(new OutputStreamWriter(client.getOutputStream()), true);

                    System.out.print("Connection received: [" + client.getInetAddress().getHostAddress() + "] ");

                    response = in.readLine();
                    while(!response.equals("exit")){
                        System.out.println("String received = "+response);
                        out.write(response.toUpperCase());
                        response = in.readLine();
                    }
                    System.out.println("Exit from while");
                    client.close();

                } catch (IOException ex) {
                    ex.printStackTrace();
                } finally {
                    try {
                        if (client != null) {
                            client.close();
                        }
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
}
