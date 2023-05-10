package com.gameclient;

import java.io.*;
import java.net.*;

public class GameClient {
    private String hostname;
    private int port;
    private Socket socket;
    private PrintWriter out;
    private BufferedReader in;

    public GameClient(String hostname, int port) {
        this.hostname = hostname;
        this.port = port;
    }

    public void start() {
        try {
            socket = new Socket(hostname, port);
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));

			System.out.println("Client started on hostname " + hostname + " and port " + port);

            String userInput;

            while ((userInput = keyboard.readLine()) != null) {
                out.println(userInput);
				
                if (userInput.startsWith("exit")) {
                    break;
                }
                System.out.println("Server response: " + in.readLine());
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

