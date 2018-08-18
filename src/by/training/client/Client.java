package by.training.client;

import java.io.*;
import java.net.Socket;

public class Client{

    public static void main(String argv[]){

        Socket clientSocket = null;
        try {
            clientSocket = new Socket("localhost", 8989);

        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
        DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());

        String lineClient = inFromUser.readLine();
        String message = "{\"name\":\"Tom\",\"message\":\"" + lineClient + "\"}\n";
        outToServer.writeBytes(message);

        //from server answer
        BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        String outServerLine = inFromServer.readLine();

        System.out.println("FROM SERVER: " + outServerLine);

        clientSocket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

