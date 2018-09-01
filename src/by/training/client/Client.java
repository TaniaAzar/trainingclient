package by.training.client;

import java.io.*;
import java.net.Socket;

public class Client{

    public static void main(String argv[]){

        String host = "localhost";
        int port = 8989;
        Socket clientSocket = null;
        try {
            clientSocket = new Socket(host, port);

        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
        DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());

        String lineClient = inFromUser.readLine();
        String message = "{\"name\":\"Tom\",\"message\":\"" + lineClient + "\"}\n";
        outToServer.writeBytes(message);

        //from server answer
        BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        String outServerLine = inFromServer.readLine();

        System.out.println("FROM SERVER: " + outServerLine);

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                clientSocket.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

