package com.company;

import java.io.*;
import java.net.Socket;

/**
 * small example using resources such as https://www.codejava.net/java-se/networking/java-socket-server-examples-tcp-ip
 */
public class Main {

    public static void main(String[] args) throws IOException {

        String line;
        //create client socket, connect to a server
        var clientSocket = new Socket("localhost", 6868);

        do {
            //create input stream (client input field)
            var in = new BufferedReader(new InputStreamReader(System.in));

            //send message to the server
            var output = clientSocket.getOutputStream();
            var writer = new PrintWriter(output, true);

            //receive messages from server
            var fromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            System.out.print("Message: ");

            line = in.readLine();

            writer.println(line);

            //read line from server
            var displayMessage = fromServer.readLine();
            System.out.println(displayMessage);

        }while (!line.equals("q"));
        System.out.println("connection closed.");
        clientSocket.close();
    }
}
